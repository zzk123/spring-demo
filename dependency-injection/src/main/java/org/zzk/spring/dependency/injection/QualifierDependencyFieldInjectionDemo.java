package org.zzk.spring.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

/**
 * @ClassName QualifierDependencyFieldInjectionDemo
 * @Description Qualifier 注解依赖注入
 * @Author zzk
 * @Date 2021/3/10 22:28
 **/
@Configurable
public class QualifierDependencyFieldInjectionDemo {

    @Autowired  // supperUser
    private User user;

    @Autowired
    @Qualifier("user")
    private User user2;

    @Autowired
    private Collection<User> allUser;

    @Autowired
    @Qualifier
    private Collection<User> qualifiedUser;

    @Bean
    @Qualifier
    public User user11(){
        User user = new User();
        user.setName("user11");
        return user;
    }

    @Bean
    @Qualifier
    public User user22(){
        User user = new User();
        user.setName("user22");
        return user;
    }

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(QualifierDependencyFieldInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourceRath = "classpath:dependency-lookup-context.xml";
        //加载XML资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourceRath);
        // 启动Spring应用上下文
        applicationContext.refresh();

        QualifierDependencyFieldInjectionDemo dependencyFieldInjectionDemo = applicationContext.getBean(QualifierDependencyFieldInjectionDemo.class);

        System.out.println(dependencyFieldInjectionDemo.user);

        System.out.println(dependencyFieldInjectionDemo.user2);

        System.out.println(dependencyFieldInjectionDemo.allUser);

        System.out.println(dependencyFieldInjectionDemo.qualifiedUser);
        // 显示关闭Spring应用上下文
        applicationContext.close();
    }
}
