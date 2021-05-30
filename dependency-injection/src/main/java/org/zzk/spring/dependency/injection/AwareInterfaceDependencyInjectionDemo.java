package org.zzk.spring.dependency.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @ClassName AwareInterfaceDependencyInjectionDemo
 * @Description 接口回调注入
 * @Author zzk
 * @Date 2021/3/10 22:08
 **/
public class AwareInterfaceDependencyInjectionDemo implements BeanFactoryAware {

    private static BeanFactory beanFactory;

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        beanFactory = beanFactory;
    }
}
