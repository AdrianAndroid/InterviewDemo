package A002动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy<T> {
    //需要代理的对象。这里我们使用Iperson来接收Tom对象
    private T target;

    public void setTarget(T target) {
        this.target = target;
    }

    public T getProxy() {
        Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InvocationHandler() {
                    /**
                     *
                     * @param proxy 生产的代理对象
                     * @param method 执行的方法
                     * @param args 执行的方法的入参
                     * @return 返回方法执行的结果
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("方法执行前");
                        //执行原有的方法
                        Object invoke = method.invoke(target, args);
                        System.out.println("方法执行后");
                        return invoke;
                    }
                });
        return (T) o;
    }
}