package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;

public class BeanD extends GenericBean {
    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private int value;

    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private void customInitMethod() {
        System.out.println("inside BeanD customInitMethod");
    }

    private void customDestroyMethod() {
        System.out.println("inside BeanD customDestroyMethod");
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
