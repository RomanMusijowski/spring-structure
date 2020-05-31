# Spring-structure

It's a simple project created for understanding and imitating spring framework behaviour.
In this project i implemented next stuff:

```
- ObjectFactory
- ApplicationContext
- ProxyConfigurator
- ObjectConfigurator
```

## ObjectFactory
Responsibilities:
```
- creating
- configuring
- invoking init method
- wrap in proxy (if need)
```

## ApplicationContext
Responsibilities:
```
- caching objects (singeltons)
```

## ProxyConfigurator
This type of configurators is used in order to add custom logic. It wraps an object in a proxy. 

By one of those ways: 
```$xslt
- Dynamic proxy (if class has an interface)
- CGlib (if there is no interfaces)
```



## ObjectConfigurator
This type of configurators works with annotations. By adding annotations to class fields, it will add new logic to an object.
It's the same as BeanPostProcessor in Spring.

Example:
```
- InjectByType ( using ApplicationContext it will set an object to fields annotated with this annotation)
```

### Purpose
Additional purpose to make this project was understanding and using SOLID principles and chain of responsibility pattern. 
