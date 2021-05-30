package org.zzk.spring.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName AnnotationDependencyFieldInjectionDemo
 * @Description TODO
 * @Author zzk
 * @Date 2021/3/10 22:02
 **/
public class AnnotationDependencyFieldInjectionDemo {

    @Autowired
    private UserHolder userHolder;

    public static void main(String[] args) {

    }

    @Bean
    public UserHolder userHolder(){
        return new UserHolder(new User());
    }
}
