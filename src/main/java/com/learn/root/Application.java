package com.learn.root;

import java.util.Map;

public class Application {
    public static ApplicationContext run(String packageToScat, Map<Class, Class> mapa) {
        JavaConfig config = new JavaConfig(packageToScat, mapa);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory factory = new ObjectFactory(context);
        //todo init all singaltons
        context.setObjectFactory(factory);
        return context;
    }
}
