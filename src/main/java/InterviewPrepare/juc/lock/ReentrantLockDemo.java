package main.java.InterviewPrepare.juc.lock;

/**
 * 可重入锁(递归锁)
 */
public class ReentrantLockDemo {

    /**
     * 方法1和方法2均上锁， 方法1中访问方法2， 方法2不需要重复上锁， 可复用
     */
    private synchronized void method1() {
        method2();
    }

    private synchronized void method2() {

    }

    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();

        Thread t3 = new Thread(phone, "t3");
        Thread t4 = new Thread(phone, "t4");
        t3.start();
        t4.start();
    }

}
