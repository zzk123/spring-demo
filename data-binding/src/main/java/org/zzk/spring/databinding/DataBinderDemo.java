package org.zzk.spring.databinding;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.DataBinder;
import org.zzk.spring.bean.definition.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring-demo
 * @description:
 * @author: zzk
 * @create: 2021-06-26 21:03
 */
public class DataBinderDemo {

    public static void main(String[] args) {
        //空白对象
        User user = new User();
        //1.创建DataBinder
        DataBinder binder = new DataBinder(user, "");
        //2.创建PropertyValues
        Map<String, Object> source = new HashMap<>();
        source.put("id",1);
        source.put("name", "小马哥");
        //不存在的属性值添加
        source.put("xxx",  "666");

        //存在一个嵌套属性
        source.put("company.name", "我的公司");

        PropertyValues propertyValues = new MutablePropertyValues(source);

        binder.bind(propertyValues);

        //3.输出内容
        System.out.println(user);
    }
}
