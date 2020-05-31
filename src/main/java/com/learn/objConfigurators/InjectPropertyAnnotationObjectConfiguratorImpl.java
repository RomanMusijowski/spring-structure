package com.learn.objConfigurators;

import com.learn.annotations.InjectProperty;
import com.learn.root.ApplicationContext;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class InjectPropertyAnnotationObjectConfiguratorImpl implements ObjectConfigurator {

    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        Class<?> impClass = t.getClass();
        for (Field declaredField : impClass.getDeclaredFields()) {
            InjectProperty annotation = declaredField.getAnnotation(InjectProperty.class);
            String resource = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
            Stream<String> lines = new BufferedReader(new FileReader(resource)).lines();
            Map<String, String> collect = lines.map(line -> line.split("=")).collect(toMap(arr -> arr[0], arr -> arr[1]));

            if (annotation != null) {
                String value = annotation.value().isEmpty() ? collect.get(declaredField.getName()) : collect.get(annotation.value());
                declaredField.setAccessible(true);
                declaredField.set(t, value);
            }
        }
    }
}
