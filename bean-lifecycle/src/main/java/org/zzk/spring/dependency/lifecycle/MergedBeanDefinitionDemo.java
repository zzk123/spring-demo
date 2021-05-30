package org.zzk.spring.dependency.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @ClassName MergedBeanDefinition
 * @Description BeanDefinition合并实例
 * @Author zzk
 * @Date 2021/4/10 13:55
 **/
public class MergedBeanDefinitionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String location = "dependency-lookup-context.xml";
        Resource resource = new ClassPathResource(location);
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        beanDefinitionReader.loadBeanDefinitions(encodedResource);

        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);

        SupperUser supperUser = beanFactory.getBean("supperUser", SupperUser.class);
        System.out.println(supperUser);
    }
}
