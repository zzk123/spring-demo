package org.zzk.spring.conversion;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @program: spring-demo
 * @description:
 * @author: zzk
 * @create: 2021-06-30 22:39
 */
public class PropertiesToStringConverter implements ConditionalGenericConverter {
    //判断类型是否正确
    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return Properties.class.equals(sourceType.getObjectType())
                    && String.class.equals(targetType.getObjectType());
    }

    /**
     * 返回转换类型
     * @return
     */
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(Properties.class, String.class));
    }

    /**
     * 进行类型转换
     * @param source
     * @param sourceType
     * @param targetType
     * @return
     */
    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Properties properties = (Properties) source;

        StringBuilder textBuilder = new StringBuilder();

        for(Map.Entry<Object, Object> entry : properties.entrySet()){
            textBuilder.append(entry.getKey()).append("=").append(entry.getValue())
                    .append(System.getProperty("line.separator"));
        }
        return textBuilder.toString();
    }
}
