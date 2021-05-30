package org.zzk.spring.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Optional;

/**
 * @ClassName AnnotationDependencyResolutionDemo
 * @Description 注解驱动的依赖注入处理过程
 * @Author zzk
 * @Date 2021/3/13 14:27
 **/
public class AnnotationDependencyResolutionDemo {

    @Autowired
    private User user;  // DependencyDescriptor ->
                        // 必须的 （request = true）
                        // 实时注入 （eager = true）
                        // 通过类型（User.class）查找（处理）
                        // 字段名称（“user”）
                        // 是否是首要的 （primary = true）

    @Autowired //集合类型的依赖注入
    private Map<String, User> users;


    @Autowired
    private Optional<User> userOptional; // supperUser

    public static void main(String[] args) {

        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册Configuration class 配置类 -> Spring Bean
        applicationContext.register(AnnotationDependencyResolutionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourceRath = "classpath:dependency-lookup-context.xml";
        //加载XML资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourceRath);

        // 启动Spring应用上下文
        applicationContext.refresh();

        //依赖查找 AnnotationDependencyResolutionDemo Bean
        AnnotationDependencyResolutionDemo demo = applicationContext.getBean(AnnotationDependencyResolutionDemo.class);

        System.out.println(demo.user);

        System.out.println(demo.users);

        System.out.println(demo.userOptional);


        applicationContext.close();

    }

}
