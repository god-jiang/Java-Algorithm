
/**
 * @author god-jiang
 * @date 2020/2/7  14:11
 */
//饿汉式
/*public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }
}*/
//双重校验锁
/*public class Singleton {
    private volatile static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}*/
//懒汉式线程安全
/*public class Singleton {
    private static Singleton instance;

    private Singleton() {

    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}*/
//静态内部类
/*
public class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {

    }

    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}*/
//枚举
public enum Singleton {
    INSTANCE;

    public void whateverMethod() {

    }
}
