package org.zzk.spring.dependency.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @ClassName AnnotatedBeanDefinitionParsingDemo
 * @Description 注解 BeanDefinition 解析实例
 * @Author zzk
 * @Date 2021/4/5 22:47
 **/
public class AnnotatedBeanDefinitionParsingDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        int beanDefinitionCountBefore = beanFactory.getBeanDefinitionCount();
        // 基于java注解的AnnotatedBeanDefinitionReader的实现
        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);
        // 注册当前类(非@Component class)
        beanDefinitionReader.register(AnnotatedBeanDefinitionParsingDemo.class);
        int beanDefinitionCountAfter = beanFactory.getBeanDefinitionCount();
        int beanDefinitionCount = beanDefinitionCountAfter - beanDefinitionCountBefore;
        System.out.println("已加载 BeanDefinition 数量：" + beanDefinitionCount);
        // 普通的Class作为 Component注册到Spring IOC容器后。通常Bean名称为annotatedBeanDefinitionParsingDemo
        // Bean名称生成来自于BeanNameGenerator，注解实现 AnntatedBeanNameGenerator
        AnnotatedBeanDefinitionParsingDemo demo = beanFactory.getBean("annotatedBeanDefinitionParsingDemo",
                AnnotatedBeanDefinitionParsingDemo.class);
        System.out.println(demo);
    }
}
