package main.java.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int key = list.indexOf("a");
        list.add("b");
        list.remove("s");
        System.out.println(key);
        Vector<String> vector = new Vector<>();
    }

}
