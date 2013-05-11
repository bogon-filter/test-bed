package org.personal.testbed.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

public @interface MyAnnotation {

    String name();

    String value();

}
