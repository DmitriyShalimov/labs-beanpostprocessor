package ua.shalimov.studyofioc.beanpostprocessor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InjectValue {
    String value();
}
