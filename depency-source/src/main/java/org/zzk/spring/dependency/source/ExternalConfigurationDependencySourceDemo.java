package org.zzk.spring.dependency.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * @ClassName ExternalConfigurationDependencySourceDemo
 * @Description 外部化配置
 * @Author zzk
 * @Date 2021/3/14 17:30
 **/
@Configuration
@PropertySource(value = "classpath:/META-INF/default.properties",encoding="UTF-8")
public class ExternalConfigurationDependencySourceDemo {


    @Value("${user.id:-1}")
    private Long id;

    @Value("${user.resource:test}")
    private Resource resource;

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册
        applicationContext.register(ExternalConfigurationDependencySourceDemo.class);
        //启动应用上下文
        applicationContext.refresh();
        //依赖查找
        ExternalConfigurationDependencySourceDemo demo = applicationContext.getBean(ExternalConfigurationDependencySourceDemo.class);
        System.out.println(demo.id);
        System.out.println(demo.resource);
        //显示关闭
        applicationContext.close();
    }

}
