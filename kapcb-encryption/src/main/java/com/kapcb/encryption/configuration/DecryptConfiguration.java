package com.kapcb.encryption.configuration;

import com.kapcb.encryption.util.EncryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * <a>Title: DecryptConfiguration </a>
 * <a>Author: Kapcb <a>
 * <a>Description: DecryptConfiguration <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 14:26
 * @since 1.0
 */
@Slf4j
@Configuration
public class DecryptConfiguration implements EnvironmentAware, BeanFactoryPostProcessor, Ordered {

    private static final String DECRYPT_KEY_PREFIX = "decrypt.prefix";

    private static final String DECRYPT_KEY_SUFFIX = "decrypt.suffix";

    private static final String DECRYPT_KEY_SECRET = "decrypt.secret.key";

    private static final String EMPTY_STRING = "";

    private String decryptCharacteristicPrefix = "Enc[";

    private String decryptCharacteristicSuffix = "]";

    private String secretKey = "kapcb";

    private ConfigurableEnvironment configurableEnvironment;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        // 使用 ConfigurableEnvironment 获取所有的属性文件信息
        MutablePropertySources propertySources = configurableEnvironment.getPropertySources();

        // 使用 lambda 表达式进行刷选出满足条件的
        StreamSupport.stream(propertySources.spliterator(), false)
                .filter(ps -> ps instanceof OriginTrackedMapPropertySource)
                .collect(Collectors.toList())
                .forEach(ps -> convertPropertiesSources(propertySources, (PropertySource<Map>) ps));

    }

    @Override
    public void setEnvironment(Environment environment) {
        this.configurableEnvironment = (ConfigurableEnvironment) environment;
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 100;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 对满足条件的属性文件进行替换处理
     *
     * @param mutablePropertySources {@link MutablePropertySources}
     * @param propertySource         {@link PropertySource}
     */
    private void convertPropertiesSources(MutablePropertySources mutablePropertySources, PropertySource<Map> propertySource) {
        Map source = propertySource.getSource();
        setDecryptProperties(source);

        Map<Object, Object> newMap = new HashMap<>(2 << 3);


        source.forEach((k, v) -> {
            String value = String.valueOf(v);

            if (!value.startsWith(decryptCharacteristicPrefix) || !value.endsWith(decryptCharacteristicSuffix)) {
                newMap.put(k, value);
                return;
            }

            String cipherText = value.replace(decryptCharacteristicPrefix, EMPTY_STRING).replace(decryptCharacteristicSuffix, EMPTY_STRING);
            String clearText = EncryptUtil.decrypt(secretKey, cipherText);

            // 这里要注意, 早期是支持直接source.put(k,clearText)替换的, 现在的版本不支持的, 底层使用了Collections$UnmodifiableMap,
            // 因为UnmodifiableMap不可进行put/remove操作, 否则会抛出异常UnsupportedOperationException
            // 不能source.put(k,clearText);这么写, 因为UnmodifiableMap不可进行put/remove操作, 否则会抛出异常UnsupportedOperationException
            newMap.put(k, clearText);
        });

        mutablePropertySources.replace(propertySource.getName(), new OriginTrackedMapPropertySource(propertySource.getName(), newMap));
    }

    private void setDecryptProperties(Map source) {
        this.decryptCharacteristicPrefix = source.get(DECRYPT_KEY_PREFIX) == null ? this.decryptCharacteristicPrefix : String.valueOf(source.get(DECRYPT_KEY_PREFIX));
        this.decryptCharacteristicSuffix = source.get(DECRYPT_KEY_SUFFIX) == null ? this.decryptCharacteristicPrefix : String.valueOf(source.get(DECRYPT_KEY_SUFFIX));
        this.secretKey = source.get(DECRYPT_KEY_SECRET) == null ? this.secretKey : String.valueOf(source.get(DECRYPT_KEY_SECRET));
    }

}
