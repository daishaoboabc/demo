package CGlib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

    private Object targetClass;

    public Object createProxy(Object targetClass) {
        // 传入真实实现类, 本身要做的事情会由他自己做, 代理类会额外进行其他增强操作
        this.targetClass = targetClass;
        // 获取本类类加载器
        ClassLoader classLoader = JdkProxy.class.getClassLoader();
        /// 获取被代理对象的所有接口
        Class[] clazz = targetClass.getClass().getInterfaces();
        // 生成代理类并返回
        return Proxy.newProxyInstance(classLoader, clazz, this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDKProxy前置增强");
        Object obj = method.invoke(targetClass, args);
        System.out.println("JDKProxy后置增强");
        return obj;
    }

    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();
        TargetClass targetClass = new TargetClassImpl();
        TargetClass targetClass1 = (TargetClass) jdkProxy.createProxy(targetClass);
        targetClass1.sayHello();
    }

}
