package org.zzk.spring.dependency.source;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

/**
 * @ClassName DepencySourceDemo
 * @Description 依赖来源实例
 * @Author zzk
 * @Date 2021/3/14 16:50
 **/
public class DepencySourceDemo {

    //注入在postProcessProperties方法执行，早于stter注入，也早于@PostConstruct
    @Autowired
    private BeanFactory beanFactory;
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostConstruct
    public void init(){
        System.out.println(beanFactory == applicationContext);
        System.out.println(beanFactory == applicationContext.getAutowireCapableBeanFactory());
        System.out.println(applicationContext == resourceLoader);
        System.out.println(applicationContext == applicationEventPublisher);
    }

    public static void main(String[] args) {

        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册
        applicationContext.register(DepencySourceDemo.class);
        //启动应用上下文
        applicationContext.refresh();
        //依赖查找
        DepencySourceDemo demo = applicationContext.getBean(DepencySourceDemo.class);
        //显示关闭
        applicationContext.close();
    }
}
