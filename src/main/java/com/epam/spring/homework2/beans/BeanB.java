package com.epam.spring.homework2.beans;

public class BeanB extends GenericBean {

  public BeanB(String name, int value) {
    this.name = name;
    this.value = value;
  }

  private void customInitMethod() {
    System.out.println("inside BeanB customInitMethod");
  }

  private void customInitMethod2() {
    System.out.println("inside BeanB customInitMethod2");
  }

  private void customDestroyMethod() {
    System.out.println("inside BeanB customDestroyMethod");
  }
}
