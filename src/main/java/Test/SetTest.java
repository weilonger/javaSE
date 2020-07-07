package main.java.Test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            set.add(i);
            set.remove(i-1);
        }

        System.out.println(set.size());
    }

    private static void test2() {
        Set<Short> set = new HashSet<>();
        for (short i = 0; i < 100; i++) {
            set.add(i);
            set.remove(i-1);
        }
        System.out.println(set.size());
    }

}
