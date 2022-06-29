package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;

public class BeanC extends GenericBean {
    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private int value;

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private void customInitMethod() {
        System.out.println("inside BeanC customInitMethod");
    }

    private void customDestroyMethod() {
        System.out.println("inside BeanC customDestroyMethod");
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
