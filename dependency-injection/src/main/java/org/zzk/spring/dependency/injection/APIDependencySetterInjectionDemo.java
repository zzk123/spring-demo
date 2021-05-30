package org.zzk.spring.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName APIDependencySetterInjectionDemo
 * @Description TODO
 * @Author zzk
 * @Date 2021/3/10 21:45
 **/
public class APIDependencySetterInjectionDemo {

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //生成UserHolder的BeanDefinition
        BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();
        //注册UserHolder的BeanDefinition
        applicationContext.registerBeanDefinition("userHolder", userHolderBeanDefinition);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourceRath = "classpath:dependency-lookup-context.xml";
        //加载XML资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourceRath);

        // 启动Spring应用上下文
        applicationContext.refresh();

        // 依赖查找并创建Bean
        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);

        //显示关闭Spring应用上下文
        applicationContext.close();
    }


    private static BeanDefinition createUserHolderBeanDefinition(){
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        definitionBuilder.addPropertyReference("user", "user");
        return  definitionBuilder.getBeanDefinition();
    }
}
