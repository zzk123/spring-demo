import org.springframework.core.GenericCollectionTypeResolver;
import sun.net.www.content.text.Generic;

import java.util.ArrayList;

/**
 * @program: spring-demo
 * @description:
 * @author: zzk
 * @create: 2021-07-03 14:23
 */
public class GenericCollectionTypeResolverDemo {

    public static void main(String[] args) {
        //StringList extends ArrayList<String> 具体化
        // getCollectionType 返回具体化泛型参数类型集合的成员类型 = String
        System.out.println(GenericCollectionTypeResolver.getCollectionType(GenericTypeResolverDemo.StringList.class));

        System.out.println(GenericCollectionTypeResolver.getCollectionType(ArrayList.class));
    }
}
