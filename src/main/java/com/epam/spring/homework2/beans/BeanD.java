package com.epam.spring.homework2.beans;

public class BeanD extends GenericBean {

  public BeanD(String name, int value) {
    this.name = name;
    this.value = value;
  }

  private void customInitMethod() {
    System.out.println("inside BeanD customInitMethod");
  }

  private void customDestroyMethod() {
    System.out.println("inside BeanD customDestroyMethod");
  }
}
