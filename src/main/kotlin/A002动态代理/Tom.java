package A002动态代理;

public class Tom implements IPerson {
    @Override
    public String stduy(String name) {
        System.out.println("执行原生方法");
        return Tom.class.getName()+name;
    }
}