import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: spring-demo
 * @description:
 * @author: zzk
 * @create: 2021-07-08 21:14
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(HellowWorldConfiguration.class) //第二步导入实现
public @interface EnableHelloWorld { //第一步定义
}
