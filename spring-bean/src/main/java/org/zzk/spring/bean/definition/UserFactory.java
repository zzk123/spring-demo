package org.zzk.spring.bean.definition;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @ClassName UserFactory
 * @Description User的工厂类
 * @Author zzk
 * @Date 2021/1/17 20:56
 **/
public class UserFactory implements InitializingBean {

    public User createUser(){
        return User.createUser();
    }

    @PostConstruct
    public void init(){
        System.out.println("注解：@PostConstruct 初始化....");
    }

    public void initFactory(){
        System.out.println("自定义：initFactory 初始化....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("实现InitializingBean接口：initFactory 初始化....");
    }
}
