package org.zzk.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @ClassName BeanInitializationDemo
 * @Description Bean初始化方式
 * @Author zzk
 * @Date 2021/1/17 21:28
 **/
public class BeanInitializationDemo {

    public static void main(String[] args) {
        // 创建BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册 Configuration Class(配置类)
        applicationContext.register(BeanInitializationDemo.class);
        // 启动引用上下文
        applicationContext.refresh();
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        //关闭
        applicationContext.close();
    }


    @Bean(initMethod = "initFactory")
    @Lazy
    public UserFactory userFactory(){
        return new UserFactory();
    }
}
