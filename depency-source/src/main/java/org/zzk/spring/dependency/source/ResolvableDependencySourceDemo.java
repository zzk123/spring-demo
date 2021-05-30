package org.zzk.spring.dependency.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @ClassName ResolvableDependencySourceDemo
 * @Description ResolvableDependency作为依赖来源
 * @Author zzk
 * @Date 2021/3/14 17:19
 **/
public class ResolvableDependencySourceDemo {


    @Autowired
    private String value;

    @PostConstruct
    public void init(){
        System.out.println(value);
    }

    public static void main(String[] args) {

        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册
        applicationContext.register(ResolvableDependencySourceDemo.class);
        //事件添加回调操作
        //在依赖注入之前会进行回调操作
        applicationContext.addBeanFactoryPostProcessor(beanFactory->{
            beanFactory.registerResolvableDependency(String.class, "helloworld");
        });

        //启动应用上下文
        applicationContext.refresh();
        //依赖查找
        ResolvableDependencySourceDemo demo = applicationContext.getBean(ResolvableDependencySourceDemo.class);
        //显示关闭
        applicationContext.close();
    }
}
