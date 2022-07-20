package com.epam.spring.homework2.beans;

public class BeanC extends GenericBean {

  public BeanC(String name, int value) {
    this.name = name;
    this.value = value;
  }

  private void customInitMethod() {
    System.out.println("inside BeanC customInitMethod");
  }

  private void customDestroyMethod() {
    System.out.println("inside BeanC customDestroyMethod");
  }
}
