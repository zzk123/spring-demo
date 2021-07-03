package org.zzk.spring.conversion;

import java.beans.PropertyEditor;

/**
 * @program: spring-demo
 * @description:
 * @author: zzk
 * @create: 2021-06-30 21:59
 */
public class PropertyEditorDemo {

    public static void main(String[] args) {
        String text = "小马哥";

        PropertyEditor propertyEditor = new StringToPropertyEditor();
        propertyEditor.setAsText(text);

        System.out.println(propertyEditor.getValue());
    }
}
