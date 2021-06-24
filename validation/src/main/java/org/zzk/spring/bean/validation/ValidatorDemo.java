package main.java.org.zzk.spring.bean.validation;

import org.springframework.context.MessageSource;
import org.springframework.validation.*;
import org.zzk.spring.bean.definition.User;

import java.util.Locale;

import static main.java.org.zzk.spring.bean.validation.ErrorsMessageDemo.createMessageSource;

/**
 * @program: spring-demo
 * @description:
 * @author: zzk
 * @create: 2021-06-24 23:24
 */
public class ValidatorDemo {

    public static void main(String[] args) {
        //1.创建Validator
        Validator validator = new UserValidator();
        //2.判断是否支持目标对象的类型
        User user = new User();
        System.out.println("user 对象是否被 UserValidator 支持检验："  + validator.supports(user.getClass()));
        //3.创建Errors对象
        Errors errors = new BeanPropertyBindingResult(user, "user");
        validator.validate(user, errors);

        //4.获取MessageSource
        MessageSource messageSource = createMessageSource();
        //5.文案输出
        for(ObjectError error : errors.getAllErrors()){
            String message = messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault());
            System.out.println(message);
        }

    }

    static class UserValidator implements Validator{

        @Override
        public boolean supports(Class<?> clazz) {
            return User.class.isAssignableFrom(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            User user = (User) target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
            String userName = user.getName();
        }
    }
}
