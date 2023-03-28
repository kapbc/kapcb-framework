package com.kapcb.context.runner;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * <a>Title: BaseApplicationRunner </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BaseApplicationRunner <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/28 21:02
 * @since 1.0
 */
@Slf4j
@Component
public class BaseApplicationRunner implements ApplicationRunner {

    @Setter(onMethod_ = {@Autowired})
    public Environment initEnvironment;

    @Setter(onMethod_ = {@Autowired})
    public ConfigurableApplicationContext initApplicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (initApplicationContext.isActive()) {
            log.info("--------------------------------------------------------");
            log.info("server name : ");
            log.info("--------------------------------------------------------");
        }
    }

}
