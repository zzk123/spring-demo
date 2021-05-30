package org.zzk.spring.bean.definition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 *
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建实例
 *
 * @ClassName BeanDefinitionCreationDemo
 * @Description 构建Bean的方式
 * @Author zzk
 * @Date 2021/1/17 16:14
 **/
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {

        // 1.通过BeanDefinitionBuilder构建
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //属性设置
        builder.addPropertyValue("name", "zzk");
        builder.addPropertyValue("age", 12);
        //获取 BeanDefinition 实例
        BeanDefinition beanDefinition = builder.getBeanDefinition();
        // BeanDefinition并非Bean终态，可以自定义修改

        // 2.通过AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        //设置Bean的类型
        genericBeanDefinition.setBeanClass(User.class);
        // 通过MutablePropertyValues批量操作
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("name", "zzk");
        propertyValues.addPropertyValue("age", 12);
        genericBeanDefinition.setPropertyValues(propertyValues);
    }
}
