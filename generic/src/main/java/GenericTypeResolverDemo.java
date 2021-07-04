import org.springframework.core.GenericTypeResolver;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.core.GenericTypeResolver.resolveReturnType;
import static org.springframework.core.GenericTypeResolver.resolveReturnTypeArgument;

/**
 * @program: spring-demo
 * @description:
 * @author: zzk
 * @create: 2021-07-03 12:51
 */
public class GenericTypeResolverDemo {

    public static void main(String[] args) throws Exception {

        //Comparable<String> 具体化
        displayReturnTypeGenericInfo(GenericTypeResolverDemo.class, Comparable.class, "getString");

        displayReturnTypeGenericInfo(GenericTypeResolverDemo.class, List.class, "getList");

        //ArrayList<String> 具体化 List 泛型参数具体化
        displayReturnTypeGenericInfo(GenericTypeResolverDemo.class, List.class, "getStringList");

        // TypeVariable
        Map<TypeVariable, Type> typeVariableTypeMap = GenericTypeResolver.getTypeVariableMap(StringList.class);
        System.out.println(typeVariableTypeMap);
    }

    public static StringList getStringList(){
        return null;
    }

    public static <E> List<E> getList(){
        return null;
    }

    public static String getString(){
        return null;
    }

    private static void displayReturnTypeGenericInfo(Class<?> containingClass, Class<?> genericIfc , String methodName, Class... argumentTypes) throws Exception{
        Method  method = containingClass.getMethod(methodName, argumentTypes);

        //常量类作为方法返回值
        Class<?> returnType = resolveReturnType(method, containingClass);
        System.out.printf("resolveReturnType(%s, %s) = %s\n", methodName, containingClass.getSimpleName(), returnType);

        //常规类型不具备泛型参数类型 List<E>
        Class<?> typeArgument = resolveReturnTypeArgument(method, genericIfc);
        System.out.printf("resolveReturnTypeArgument(%s, %s) = %s\n",methodName, containingClass.getSimpleName(), typeArgument);
    }

    static class StringList extends ArrayList<String> {}
}
