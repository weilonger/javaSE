package main.java.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1(){
//        List<String> list1 = new ArrayList<>();
//        list1.add("libai");
//        list1.add("dufu");
//        List<String> list2 = new ArrayList<>(list1);
//        list2.forEach(System.out::println);
        String area = "内地";
        List<String> a = new ArrayList<>(Collections.singletonList(area));
        a.forEach(System.out::println);
    }

}
