package org.zzk.spring.configuration;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @program: spring-demo
 * @description:
 * @author: zzk
 * @create: 2021-06-20 14:33
 */
public class UserNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        //注册user元素的解析器
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
