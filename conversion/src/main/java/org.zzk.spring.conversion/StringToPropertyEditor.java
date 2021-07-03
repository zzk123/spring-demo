package org.zzk.spring.conversion;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

/**
 * @program: spring-demo
 * @description:
 * @author: zzk
 * @create: 2021-06-30 21:56
 */
public class StringToPropertyEditor extends PropertyEditorSupport implements PropertyEditor {


    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Properties properties = new Properties();
        try{
            properties.load(new StringReader(text));
        }catch (IOException e){
            throw new IllegalArgumentException();
        }
        //临时存储
        setValue(properties);
    }
}
