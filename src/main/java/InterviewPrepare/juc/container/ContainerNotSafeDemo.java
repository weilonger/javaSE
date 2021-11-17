package main.java.InterviewPrepare.juc.container;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 集合类线程不安全问题
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {
//        listTest();
//        setTest();
        mapTest();
    }

    private static void mapTest() {
//        Map<Integer, String> map = new HashMap<>();
//        Map<Integer, String> map = new Hashtable<>();
//        Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());
        Map<Integer, String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 30; i++) {
            int finalI = i;
            new Thread(()  -> {
                map.put(finalI, UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

    private static void setTest() {
//        Set<String> set = new HashSet<>();
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(()  -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    /**
     * 1. 现象
     *    java.util.ConcurrentModificationException
     * 2. 原因
     *    并发争抢修改导致
     *    一个线程正在写， 另一个线程抢占线程， 导致数据异常
     * 3. 解决方案
     *    3.1 new Vector();
     *    3.2 Collections.synchronizedList(new ArrayList())
     *    3.3 new CopyOnWriteArrayList() 写时复制
     * 4. 优化建议
     *
     */
    public static void listTest() {
        List<String> list = new ArrayList<>();
//        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(()  -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

}
