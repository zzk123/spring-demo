package org.zzk.spring.bean.definition;

/**
 * @ClassName User
 * @Description TODO
 * @Author zzk
 * @Date 2021/1/17 16:22
 **/
public class User {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    public static User createUser(){
        return new User();
    }
}
