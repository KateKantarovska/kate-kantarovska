package com.epam.spring.homework2;

import com.epam.spring.homework2.beans.GenericBean;
import com.epam.spring.homework2.config.BeanConfig1;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(BeanConfig1.class);
    for (var beanDefinitionName : context.getBeanDefinitionNames()) {
      BeanDefinition beanDefinition = context.getBeanDefinition(beanDefinitionName);
      System.out.println(beanDefinitionName + " definition: " + beanDefinition);
      if (context.getBean(beanDefinitionName) instanceof GenericBean bean) {
        System.out.println("name: " + bean.getName() + ", value: " + bean.getValue());
      }
    }
    context.close();
  }
}
