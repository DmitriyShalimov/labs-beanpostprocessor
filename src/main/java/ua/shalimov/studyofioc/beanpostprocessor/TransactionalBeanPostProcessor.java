package ua.shalimov.studyofioc.beanpostprocessor;

import ua.shalimov.ioc.context.beanpostprocessor.BeanPostProcessor;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class TransactionalBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> originalClassMap = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        Class<?> clazz = bean.getClass();
        if (clazz.isAnnotationPresent(Logger.class)) {
            originalClassMap.put(beanName, clazz);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (originalClassMap.containsKey(beanName)) {
            Class clazz = originalClassMap.get(beanName);
            return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), (proxy, method, args) -> {
                System.out.println("start transaction...");
                Object result = method.invoke(bean, args);
                System.out.println("transaction is finished.");
                return result;
            });
        }
        return bean;
    }
}
