package org.example.task3205ProxyObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {

    SomeInterfaceWithMethods inter;

    public CustomInvocationHandler(SomeInterfaceWithMethods inter){
        this.inter = inter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");
        Object invoke = method.invoke(inter, args);
        System.out.println(method.getName() + " out");
        return invoke;
    }
}
