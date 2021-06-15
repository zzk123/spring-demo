package org.zzk.spring.configuration;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

/**
 * @program: spring-demo
 * @description: 加载properties文件
 * @author: zzk
 * @create: 2021-06-15 22:22
 */
public class PropertiesBeanDefinitionReaderDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new PropertiesBeanDefinitionReader(beanFactory);
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("");
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        int beanDefinition = reader.loadBeanDefinitions(resource);
    }
}
