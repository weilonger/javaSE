package main.java.InterviewPrepare.DesignPattern.Jvm.MemoryStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 内存溢出.
 * @author hwl
 */
public class OutOfMemory {

    public static void main(String[] args) {
        List<Demo> demoList = new ArrayList<>();
        int n = 0;
        while (true) {
            demoList.add(new Demo());
//            System.out.println(++n);
        }
    }
}
