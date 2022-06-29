package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;

public class BeanB extends GenericBean {
    @Value("${beanB.name}")
    private String name;

    @Value("${beanB.value}")
    private int value;

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
