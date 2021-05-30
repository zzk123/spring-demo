package org.zzk.spring.configuration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ObjectUtils;
import org.zzk.spring.dependency.lifecycle.User;

/**
 * @ClassName BeanConfigurationMetadataDemo
 * @Description Bean配置元信息
 * @Author zzk
 * @Date 2021/5/30 21:08
 **/
public class BeanConfigurationMetadataDemo {

    public static void main(String[] args) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name", "zzk");
        //附加属性不影响bean的生成
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        beanDefinition.setAttribute("name", "gege");

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if(ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(bean.getClass())){
                    BeanDefinition bd = beanFactory.getBeanDefinition("user");
                    //属性存储上下文
                    String name = (String) bd.getAttribute("name");
                    User user = (User) bean;
                    user.setName(name);
                }
                return bean;
            }
        });

        beanFactory.registerBeanDefinition("user", beanDefinition);

        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
    }
}
