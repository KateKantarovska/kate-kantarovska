package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

@Configuration
@PropertySource("classpath:/application.properties")
@Import(BeanConfig2.class)
public class BeanConfig1 {
  @Bean(initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
  @Order(1)
  BeanD beanD(@Value("${beanD.name}") final String name, @Value("${beanD.value}") final int value) {
    return new BeanD(name, value);
  }

  @Bean(initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
  @Order(2)
  BeanB beanB(@Value("${beanB.name}") final String name, @Value("${beanB.value}") final int value) {
    return new BeanB(name, value);
  }

  @Bean(initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
  @Order(3)
  BeanC beanC(@Value("${beanC.name}") final String name, @Value("${beanC.value}") final int value) {
    return new BeanC(name, value);
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
