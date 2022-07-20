package com.epam.spring.homework2.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanE extends GenericBean {

  public BeanE() {
    this.name = "beanE";
    this.value = 5;
  }

  @PostConstruct
  public void postConstruct() {
    System.out.println("inside BeanE postConstruct method");
  }

  @PreDestroy
  public void preDestroy() {
    System.out.println("inside BeanE preDestroy method");
  }
}
