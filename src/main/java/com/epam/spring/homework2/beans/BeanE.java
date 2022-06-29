package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanE extends GenericBean {
    private String name = "beanE";
    private int value = 5;

    @PostConstruct
    public void postConstruct() {
        System.out.println("inside BeanE postConstruct method");

    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("inside BeanE preDestroy method");
    }

    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
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
