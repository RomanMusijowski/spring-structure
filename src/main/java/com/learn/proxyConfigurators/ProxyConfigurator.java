package com.learn.proxyConfigurators;

public interface ProxyConfigurator {
    Object replaceWithProxyIdNeeded(Object t, Class impClass);
}
