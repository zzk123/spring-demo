package org.zzk.spring.bean.definition;

import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName UserFactoryBean
 * @Description TODO
 * @Author zzk
 * @Date 2021/1/17 21:02
 **/
public class UserFactoryBean implements FactoryBean {

    public Object getObject() throws Exception {
        return User.createUser();
    }

    public Class<?> getObjectType() {
        return User.class;
    }
}
