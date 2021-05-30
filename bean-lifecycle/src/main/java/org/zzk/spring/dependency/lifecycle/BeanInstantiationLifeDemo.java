package org.zzk.spring.dependency.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName BeanInstantiationLifeDemo
 * @Description Bean实例化生命周期实例
 * @Author zzk
 * @Date 2021/4/10 14:36
 **/
public class BeanInstantiationLifeDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 添加实例
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
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


    static class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor{

        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            //覆盖
            if(ObjectUtils.nullSafeEquals("supperUser", beanName)
                    && SupperUser.class.equals(beanClass)){
                //把配置好的supperUser覆盖
                return new SupperUser();
            }
            //保持原样
            return null;
        }
    }
}
