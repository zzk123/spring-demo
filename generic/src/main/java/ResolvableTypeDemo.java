import org.springframework.core.ResolvableType;

import java.util.Arrays;

/**
 * @program: spring-demo
 * @description:
 * @author: zzk
 * @create: 2021-07-03 14:42
 */
public class ResolvableTypeDemo {

    public static void main(String[] args) {

        //工厂创建
        // StringList <- ArrayList <- AbstractList <- List <- Collection
        ResolvableType resolvableType = ResolvableType.forClass(GenericTypeResolverDemo.StringList.class);

        resolvableType.getSuperType();     // ArrayList
        resolvableType.getSuperType().getSuperType(); // AbstractList

        System.out.println(resolvableType.asCollection().resolve()); // 获取 Raw Type
        System.out.println(resolvableType.asCollection().resolveGeneric(0)); // 获取泛型参数类型

        Arrays.asList(resolvableType.asCollection().getGenerics()).stream().forEach(System.out::println);

    }
}
