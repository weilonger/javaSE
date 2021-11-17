package main.java.InterviewPrepare.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS compareAndSet
 * 与主物理内存值比较
 * 1. 一样，则修改
 * 2. 不一样，则不修改
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2021) + "\tcurrent data: " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\tcurrent data: " + atomicInteger.get());

        atomicInteger.getAndIncrement();
    }

}
