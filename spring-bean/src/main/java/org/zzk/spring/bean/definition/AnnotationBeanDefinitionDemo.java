package org.zzk.spring.bean.definition;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @ClassName AnnotationBeanDefinitionDemo
 * @Description 注解方式配置元信息
 * @Author zzk
 * @Date 2021/1/17 20:17
 **/
@Import(AnnotationBeanDefinitionDemo.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        // 创建BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册 Configuration Class(配置类)
        applicationContext.register(Config.class);
        // 启动引用上下文
        applicationContext.refresh();
        // 1.通过BeanDefiniation注册 API 实现
        // 1.1.非命名
        registerUserBeanDefinition(applicationContext);
        // 1.2.命名
        registerUserBeanDefinition(applicationContext, "zzk222");

        // 2. 通过Java注解
        // 2.1. 通过 @Bean 方式定义
        // 2.2. 通过 @Component
        // 2.2. 通过@Import 进行导入

        //输出Config定义的所有实例
        Map<String, Config> configMap = applicationContext.getBeansOfType(Config.class);
        //输出User定义的所有实例
        Map<String, User> userConfigMap = applicationContext.getBeansOfType(User.class);

        System.out.println(configMap);
        System.out.println(userConfigMap);

        //显示的关闭Spring 应用上下文
        applicationContext.close();
    }

    @Component //定义组件
    public static class Config{

        @Bean(name={"user", "zzk-user"})
        public User user(){
            User user = new User();
            user.setAge(11);
            user.setName("zzk");
            return user;
        }
    }


    /**
     * Java API 配置元信息
     * @param registry
     * @param beanName
     */
    public static void  registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name", "zzk");
        //判断BeanName 参数存在
        if(StringUtils.hasText(beanName)){
            //命名方式注册方法
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        }else{
            //非命名方式注册方法
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry){
        registerUserBeanDefinition(registry, null);
    }
}
