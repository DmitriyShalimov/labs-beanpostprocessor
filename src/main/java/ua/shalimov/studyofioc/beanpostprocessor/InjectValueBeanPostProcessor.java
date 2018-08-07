package ua.shalimov.studyofioc.beanpostprocessor;

import ua.shalimov.ioc.context.beanpostprocessor.BeanPostProcessor;

import java.lang.reflect.Field;

public class InjectValueBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        Class<?> clazz= bean.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            InjectValue annotation=field.getAnnotation(InjectValue.class);
            if(annotation!=null){
                Class<?> type = field.getType();
                field.setAccessible(true);
                try {
                if (type.equals(int.class)){
                    field.set(bean,Integer.parseInt(annotation.value()));

                }else if (type.equals(double.class)){
                    field.set(bean,Double.parseDouble(annotation.value()));
                }else if (type.equals(String.class)){
                    field.set(bean,annotation.value());
                }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                field.setAccessible(false);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
