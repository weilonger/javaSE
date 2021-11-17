package main.java.InterviewPrepare.juc.cas;

/**
 * 懒汉式单例
 */
public class SingletonDemo {

    /**
     * 不设置volatile还是会存在多线程问题
     * 需要保证指令不重排
     * 在变量 instance 赋值时， 底层为
     * 1. 分配内存空间
     * 2. 初始化对象
     * 3. 设置instance指向内存空间
     * 当 2 和 3发生顺序改变后， 多线程情况下， 会获取到未初始化的instance值
     */
    private static volatile SingletonDemo instance;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t 创建单例");
    }

    /**
     * DCL (Double Check Lock)
     * @return instance
     */
    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, "线程" + String.valueOf(i)).start();
        }
    }
}
