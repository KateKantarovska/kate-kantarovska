package com.epam.spring.homework2.ppbeans;

import com.epam.spring.homework2.beans.GenericBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeansValidationPostProcessor implements BeanPostProcessor {
  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (bean instanceof GenericBean bean1) {
      if (bean1.getName() == null || bean1.getValue() <= 0) {
        System.out.println(beanName + " has not passed validation");
      } else {
        System.out.println(beanName + " has passed validation");
      }
    }
    return bean;
  }
}
