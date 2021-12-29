package com.kapcb.framework.web.configuration;

import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import java.util.Arrays;
import java.util.Collections;

/**
 * <a>Title: DozerConfiguration </a>
 * <a>Author: Kapcb <a>
 * <a>Description: DozerConfiguration <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/20 16:49
 */
@Slf4j
public class DozerMapperConfiguration {

    @Bean
    public DozerBeanMapper dozerBeanMapper(@Value("classpath*:dozer/*.xml") Resource[] resources) {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(Collections.singletonList(Arrays.toString(resources)));
        return dozerBeanMapper;
    }

}
