package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.*;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

@Configuration
@PropertySource("classpath:/application.properties")
@Import(BeanConfig2.class)
public class BeanConfig1 {
    @Bean(initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
    @Order(1)
    BeanD beanD() {
        return new BeanD();
    }

    @Bean(initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
    @Order(2)
    BeanB beanB() {
        return new BeanB();
    }

    @Bean(initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
    @Order(3)
    BeanC beanC() {
        return new BeanC();
    }

    @Bean
    BeanA beanA() {
        return new BeanA();
    }

    @Bean
    BeanE beanE() {
        return new BeanE();
    }

    @Bean
    @Lazy
    BeanF beanF() {
        return new BeanF();
    }
}
