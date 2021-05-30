package org.zzk.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @ClassName SpecialBeanInstantitationDemo
 * @Description 特殊的实例化Bean方式
 * @Author zzk
 * @Date 2021/1/17 21:05
 **/
public class SpecialBeanInstantitationDemo {

    public static void main(String[] args) {
        //配置XML配置文件
        //启动Spring应用上下文
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-creation-context.xml");
        // 1. ServiceLoader
        demoServiceLoader();
        demoServiceLoader2(beanFactory);
        // 2. AutowireCapableBeanFactory
        AutowireCapableBeanFactory autowireCapableBeanFactory = beanFactory.getAutowireCapableBeanFactory();
        UserFactory userFactory = autowireCapableBeanFactory.createBean(UserFactory.class);
        userFactory.createUser();
    }

    /**
     * 通过 ServiceLoaderFactoryBean 注册
     * @param beanFactory
     */
    public static void demoServiceLoader2(BeanFactory beanFactory){
        ServiceLoader<UserFactory> serviceLoade =  beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);
        display(serviceLoade);
    }

    /**
     * 通过 ServiceLoader 注册
     */
    public static void demoServiceLoader(){
        ServiceLoader<UserFactory> serviceLoade =  ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());;
        display(serviceLoade);
    }


    /**
     * 输出
     * @param serviceLoade
     */
    public static void display(ServiceLoader<UserFactory> serviceLoade){
        Iterator<UserFactory> iterable = serviceLoade.iterator();
        while(iterable.hasNext()){
            UserFactory userFactory = iterable.next();
            System.out.println(userFactory.createUser());
        }
    }
}
