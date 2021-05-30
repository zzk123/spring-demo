package org.zzk.spring.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @ClassName XmlDependencySetterInjectionDemo
 * @Description 基于XML资源的依赖Setter方法注入
 * @Author zzk
 * @Date 2021/3/8 23:06
 **/
public class XmlDependencySetterInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String xmlResourceRath = "classpath:dependency-injection-context.xml";

        beanDefinitionReader.loadBeanDefinitions(xmlResourceRath);

        UserHolder userHolder = beanFactory.getBean(UserHolder.class);

        System.out.println(userHolder);
    }
}
