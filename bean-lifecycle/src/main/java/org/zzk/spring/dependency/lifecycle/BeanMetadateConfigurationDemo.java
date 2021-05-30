package org.zzk.spring.dependency.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @ClassName BeanMetadateConfigurationDemo
 * @Description Bean 元信息配置实例
 * @Author zzk
 * @Date 2021/4/5 22:06
 **/
public class BeanMetadateConfigurationDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //加载properties配置信息，注册对应的类
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(beanFactory);
        String location = "META-INF/user.properties";
        Resource resource = new ClassPathResource(location);
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        int beanNumbers = reader.loadBeanDefinitions(encodedResource);
        System.out.println(beanNumbers);
        User user =  beanFactory.getBean("user", User.class);
        System.out.println(user);
    }
}
