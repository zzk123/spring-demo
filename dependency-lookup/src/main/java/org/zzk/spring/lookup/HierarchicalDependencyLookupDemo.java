package org.zzk.spring.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName HierarchicalDependencyLookupDemo
 * @Description 层次性依赖查找
 * @Author zzk
 * @Date 2021/2/27 12:55
 **/
public class HierarchicalDependencyLookupDemo {

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类作为配置类
        applicationContext.register(HierarchicalDependencyLookupDemo.class);

        // 1. 获取HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println("当前 BeanFactory 的Parent BeanFactory：" + beanFactory.getParentBeanFactory());

        // 2. 设置Parent BeanFactory
        beanFactory.setParentBeanFactory(createParentBeanFactory());
        System.out.println("当前 BeanFactory 的Parent BeanFactory：" + beanFactory.getParentBeanFactory());

        //启动应用上下文
        applicationContext.register();


        //关闭应用上下文
        applicationContext.close();
    }

    private static void displayLocalBean(HierarchicalBeanFactory beanFactory, String beanName){
        System.out.printf("当前 BeanFactory[%s] 是否包含bean[name : %s] : %s\n", beanFactory, beanName, beanFactory.containsLocalBean(beanName));
    }

    private static BeanFactory createParentBeanFactory(){
        //创建BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //xml配置文件ClassPath路径
        String location = "";
        //加载配置
        reader.loadBeanDefinitions(location);

        return beanFactory;
    }
}
