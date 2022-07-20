package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanA extends GenericBean implements InitializingBean, DisposableBean {

  public BeanA() {
    this.name = "beanA";
    this.value = 1;
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("inside BeanA DisposableBean destroy method");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("inside BeanA InitializingBean afterPropertiesSet method");
  }
}
