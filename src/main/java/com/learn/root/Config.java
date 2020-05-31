package com.learn.root;

import org.reflections.Reflections;

public interface Config {
    Reflections getScanner();
    <T> Class<? extends T> getImpClass(Class<T> type);
}
