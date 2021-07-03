package org.zzk.spring.conversion;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zzk.spring.bean.definition.User;

/**
 * @program: spring-demo
 * @description:
 * @author: zzk
 * @create: 2021-06-30 22:56
 */
public class SpringCustomizedPropertyEditorDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:/property-editors-context.xml");

        User user = applicationContext.getBean("user", User.class);

        System.out.println(user);

        applicationContext.close();
    }
}
