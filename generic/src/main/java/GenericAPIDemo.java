import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @program: spring-demo
 * @description:
 * @author: zzk
 * @create: 2021-07-03 11:40
 */
public class GenericAPIDemo {

    public static void main(String[] args) {

        // 原生类型 primitive type : int long float
        Class intClass = int.class;

        // 数组类型 array types : int[], Object[]
        Class objectArrayClass = Object[].class;

        // 原始类型 raw types：java.lang.String
        Class rawClass = String.class;

        //泛型参数类型 parameterized type
        ParameterizedType parameterizedType = (ParameterizedType) ArrayList.class.getGenericSuperclass();

        // 泛型类型变量 Type Variable

        System.out.println(parameterizedType.toString());

        // <E>
        Type[] typeVariables = parameterizedType.getActualTypeArguments();

        Stream.of(typeVariables)
                .map(TypeVariable.class::cast) // type -> TypeVariable
                .forEach(System.out::println);
    }
}
