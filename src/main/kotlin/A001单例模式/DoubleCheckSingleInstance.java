package A001单例模式;

public class DoubleCheckSingleInstance {
    private static volatile DoubleCheckSingleInstance instance = null;

    public static DoubleCheckSingleInstance getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleInstance.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleInstance();
                }
            }
        }
        return instance;
    }
}
