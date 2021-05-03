package cn.qqchao.other.singleton;

/**
 * 双重校验
 */
public class Singleton {
    public static volatile Singleton singleton;

    private Singleton(){};

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}
