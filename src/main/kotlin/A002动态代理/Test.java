package A002动态代理;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        JDKProxy<IPerson> iPersonJDKProxy = new JDKProxy<>();
        //需要被代理的对象
        IPerson tom = new Tom();
        iPersonJDKProxy.setTarget(tom);
        //获取代理对象，此时这个对象就不再是上面的tom了
        IPerson proxy = iPersonJDKProxy.getProxy();
        proxy.stduy("java");

        // 代理类的字节码数组
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                "RProxy0",
                new Class[]{IPerson.class});
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/zhaojian/code/java/InterviewDemo/src/main/kotlin/A002动态代理/IPersonProxy.class");
        fileOutputStream.write(proxyClassFile);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}