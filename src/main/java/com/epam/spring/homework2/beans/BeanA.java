package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

public class BeanA extends GenericBean implements InitializingBean, DisposableBean {
    private String name = "beanA";
    private int value = 1;

    @Override
    public void destroy() throws Exception {
        System.out.println("inside BeanA DisposableBean destroy method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("inside BeanA InitializingBean afterPropertiesSet method");
    }

    @Override
    public String toString() {
        return "BeanA{" +
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
