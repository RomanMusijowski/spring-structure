package com.learn.root;

import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {
    @Getter
    private Reflections scanner;
    private Map<Class, Class> importedClasses;

    public JavaConfig(String packageToScan, Map<Class, Class> importedClasses) {
        this.scanner = new Reflections(packageToScan);
        this.importedClasses = importedClasses;
    }

    @Override
    public <T> Class<? extends T> getImpClass(Class<T> type) {
        return importedClasses.computeIfAbsent(type, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
            if (classes.size() != 1) {
                throw new RuntimeException(type + " has 0 or more than one impl");
            }
            return classes.iterator().next();
        });
    }
}
