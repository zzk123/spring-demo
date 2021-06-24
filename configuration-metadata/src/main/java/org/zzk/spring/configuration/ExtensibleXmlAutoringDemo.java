package org.zzk.spring.configuration;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.zzk.spring.dependency.lifecycle.User;

/**
 * @program: spring-demo
 * @description: 元素扩展
 * @author: zzk
 * @create: 2021-06-20 14:45
 */
public class ExtensibleXmlAutoringDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/users-context.xml");
        User user = beanFactory.getBean(User.class);
        System.out.print(user);
    }
}
