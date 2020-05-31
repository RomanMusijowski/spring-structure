package com.learn.objConfigurators;

import com.learn.root.ApplicationContext;

public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context);
}
