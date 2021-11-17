package main.java.InterviewPrepare.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Phone implements Runnable{

    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t sendEmail()");
    }

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        getLock();
    }

    public void getLock() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t get Lock");
            setLock();
        } finally {
            lock.unlock();
        }
    }

    public void setLock() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t get Lock");
        } finally {
            lock.unlock();
        }
    }
}
