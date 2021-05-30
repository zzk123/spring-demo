package org.zzk.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName BeanInstantitationDemo
 * @Description Bean实例化的方式
 * @Author zzk
 * @Date 2021/1/17 20:53
 **/
public class BeanInstantitationDemo {

    public static void main(String[] args) {

        //配置XML配置文件
        //启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-creation-context.xml");
        //静态工厂方法
        User user = beanFactory.getBean("user-by-static-method", User.class);
        //工厂实例方式
        User user2 = beanFactory.getBean("user-by-instance-method", User.class);
        //BeanFactory实现方式
        User user3 = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println(user);
    }
}
