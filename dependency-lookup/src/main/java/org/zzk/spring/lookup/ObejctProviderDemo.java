package org.zzk.spring.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName ObejctProviderDemo
 * @Description 通过 ObejctProvider 进行依赖查找
 * @Author zzk
 * @Date 2021/2/24 23:16
 **/
public class ObejctProviderDemo {

    public static void main(String[] args) {
        // 创建BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册 Configuration Class(配置类)
        applicationContext.register(ObejctProviderDemo.class);
        // 启动引用上下文
        applicationContext.refresh();
        //依赖查找集合对象
        lookupByObjectProvider(applicationContext);
        lookupByIfAvailable(applicationContext);
        lookupByStreamop(applicationContext);
        
        //显示的关闭Spring 应用上下文
        applicationContext.close();
    }

    private static void lookupByStreamop(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        for(String string : objectProvider){
            System.out.println(string);
        }
    }

    /**
     * 找不到对应的Bean默认返回一个值
     * @param applicationContext
     */
    private static void lookupByIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<Double> doubleProvider = applicationContext.getBeanProvider(Double.class);
        Double dd = doubleProvider.getIfAvailable(() ->new Double("6666"));
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }

    @Bean
    @Primary
    public String helloWorld(){
        return "hello, world";
    }

    @Bean
    public String message(){
        return "message";
    }

}
