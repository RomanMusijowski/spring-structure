package com.learn.root;

import com.learn.annotations.Singelton;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {
    @Setter
    private ObjectFactory objectFactory;
    @Getter
    private Config config;
    private Map<Class, Object> cache = new ConcurrentHashMap<>();

    public ApplicationContext(Config config) {
        this.config = config;
    }

    public <T> T getObject(Class<T> type) {
        if (cache.containsKey(type)) {
            return (T) cache.get(type);
        }

        Class<? extends T> impClass = type;
        if (type.isInterface()) {
            impClass = config.getImpClass(type);
        }
        T object = objectFactory.createObject(impClass);
        if (object.getClass().isAnnotationPresent(Singelton.class)) {
            cache.put(type, object);
        }
        return object;
    }


}
