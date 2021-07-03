package org.zzk.spring.conversion;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.stereotype.Component;
import org.zzk.spring.bean.definition.User;

/**
 * @program: spring-demo
 * @description:
 * @author: zzk
 * @create: 2021-06-30 22:06
 */
@Component
public class CustomizedPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(User.class, "context", new StringToPropertyEditor());
    }
}
