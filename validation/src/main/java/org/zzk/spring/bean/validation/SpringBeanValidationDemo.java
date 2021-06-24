package org.zzk.spring.bean.validation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @program: spring-demo
 * @description:
 * @author: zzk
 * @create: 2021-06-24 23:50
 */
public class SpringBeanValidationDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/bean-validation-context.xml");

        Validator validator = applicationContext.getBean(Validator.class);

        System.out.println(validator instanceof LocalValidatorFactoryBean);

        UserConfiguration userConfiguration = applicationContext.getBean(UserConfiguration.class);
        userConfiguration.processUser(new User());
        //关闭上下文
        applicationContext.close();
    }

    @Configuration(proxyBeanMethods = false)
    @Validated
    static class UserConfiguration{

        public void processUser(@Valid User user){
            System.out.println(user);
        }

    }

    static class User{

        @NotNull
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
