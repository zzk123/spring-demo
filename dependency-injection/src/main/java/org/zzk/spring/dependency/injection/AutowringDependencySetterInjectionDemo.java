package org.zzk.spring.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @ClassName AutowringDependencySetterInjectionDemo
 * @Description 自动注入ByName
 * @Author zzk
 * @Date 2021/3/10 21:56
 **/
public class AutowringDependencySetterInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String xmlResourceRath = "classpath:dependency-injection-context.xml";

        beanDefinitionReader.loadBeanDefinitions(xmlResourceRath);

        UserHolder userHolder = beanFactory.getBean(UserHolder.class);

        System.out.println(userHolder);
    }
}
