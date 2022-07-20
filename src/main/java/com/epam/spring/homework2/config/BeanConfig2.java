package com.epam.spring.homework2.config;

import com.epam.spring.homework2.ppbeans.BFPostProcessor;
import com.epam.spring.homework2.ppbeans.BeansValidationPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig2 {
  @Bean
  BeansValidationPostProcessor beansValidationPostProcessor() {
    return new BeansValidationPostProcessor();
  }

  @Bean
  static BFPostProcessor beanFactoryPostProcessor() {
    return new BFPostProcessor();
  }
}
