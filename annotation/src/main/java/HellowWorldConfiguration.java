import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-demo
 * @description:
 * @author: zzk
 * @create: 2021-07-08 21:17
 */
@Configuration
public class HellowWorldConfiguration {

    @Bean
    public String helloWorld(){
        return "Hello, World";
    }
}
