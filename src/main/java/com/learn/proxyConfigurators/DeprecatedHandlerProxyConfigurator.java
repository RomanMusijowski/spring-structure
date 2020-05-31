package com.learn.proxyConfigurators;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object replaceWithProxyIdNeeded(Object t, Class impClass) {
        if (impClass.isAnnotationPresent(Deprecated.class)) {

            if (impClass.getInterfaces().length == 0) {
                return Enhancer.create(impClass, (InvocationHandler) (o, method, args) -> getInvocationHandlerLogic(method, args, t));
            }
            return  Proxy.newProxyInstance(impClass.getClassLoader(), impClass.getInterfaces(), (o, method, args) -> getInvocationHandlerLogic(method, args, t));
        }else {
            return t;
        }
    }

    private Object getInvocationHandlerLogic(Method method, Object[] args, Object t) throws IllegalAccessException, InvocationTargetException {
        System.out.println("Dude this method is deprecated, don't do it. Be aware you're in dangerous!");
        return method.invoke(t, args);
    }
}
