package org.zzk.spring.dependency.injection;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName LazyDependencyFieldInjectionDemo
 * @Description TODO
 * @Author zzk
 * @Date 2021/3/10 22:53
 **/
public class LazyDependencyFieldInjectionDemo {


    @Autowired
    private User user; // 实时注入

    @Autowired
    private ObjectProvider<User> userObjectProviderr; // 延迟注入

    @Autowired
    private ObjectFactory<User> userObjectFactory;

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(LazyDependencyFieldInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourceRath = "classpath:dependency-lookup-context.xml";
        //加载XML资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourceRath);
        // 启动Spring应用上下文
        applicationContext.refresh();

        //依赖查找 LazyDependencyFieldInjectionDemo

        LazyDependencyFieldInjectionDemo demo = applicationContext.getBean(LazyDependencyFieldInjectionDemo.class);

        System.out.println(demo.userObjectProviderr.getObject());

        System.out.println(demo.userObjectFactory.getObject());

        demo.userObjectProviderr.forEach(System.out::println);

        // 显示关闭Spring应用上下文
        applicationContext.close();
    }
}
