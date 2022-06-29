package com.epam.spring.homework2.ppbeans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BFPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition beanBDefinition = configurableListableBeanFactory.getBeanDefinition("beanB");
        beanBDefinition.setInitMethodName("customInitMethod2");
        System.out.println("changed BeanB init method");
    }


}
