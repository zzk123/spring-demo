package org.zzk.spring.configuration;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;
import org.zzk.spring.dependency.lifecycle.User;

/**
 * @program: spring-demo
 * @description: 定义命名空间元素解析器
 * @author: zzk
 * @create: 2021-06-20 14:34
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String name = element.getAttribute("name");
        if(StringUtils.hasText(name)){
            builder.addPropertyValue("name", name);
        }
    }
}
