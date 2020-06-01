package main.java.InterviewPrepare.DesignPattern.Jvm.Monitor;

import java.util.ArrayList;
import java.util.List;

public class JconsoleTest {

    Byte[] bytes = new Byte[128 * 1024];    
    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        fill(1000);
    }

    private static void fill(int n) {
        List<JconsoleTest> jList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
            jList.add(new JconsoleTest());
        }
    }
}
