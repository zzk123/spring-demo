package main.java.org.zzk.spring.bean.validation;

import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.zzk.spring.bean.definition.User;
import java.util.List;
import java.util.Locale;

/**
 * @program: spring-demo
 * @description: Errors错误文案实例
 * @author: zzk
 * @create: 2021-06-24 23:03
 */
public class ErrorsMessageDemo {

    public static void main(String[] args) {
        //0.创建对象
        User user = new User();
        user.setName("6666");
        //1.选择Errors - BeanPropertyBindingResult
        Errors errors = new BeanPropertyBindingResult(user, "user");
        //2.调用reject 或 rejectValue
        errors.reject("user.properties.not.null");
        errors.rejectValue("name", "name.required");
        //3.获取Errors中ObjectError和FieldError
        List<ObjectError> globalErrors = errors.getGlobalErrors();
        List<FieldError> fieldErrorList = errors.getFieldErrors();
        List<ObjectError> allErrors = errors.getAllErrors();
        //4.通过ObjectError和FieldError中的code与args来关联MessageSource实现
        MessageSource messageSource = createMessageSource();
        for(ObjectError error : allErrors){
            String message = messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault());
            System.out.println(message);
        }
    }

    public static MessageSource createMessageSource() {
        StaticMessageSource messageSource = new StaticMessageSource();
        messageSource.addMessage("user.properties.not.null", Locale.getDefault(), "User 属性不能为空");
        messageSource.addMessage("name.required", Locale.getDefault(), "the name of user must not be null");
        return messageSource;
    }
}
