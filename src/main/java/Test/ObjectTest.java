package main.java.Test;

public class ObjectTest {
    public static void main(String[] args) {
        ObjectTest objectTest = new ObjectTest();
        objectTest.test1();
    }

    private void test1() {
        Object i = 1 == 1 ? new Integer(3) : new Float(1);
        System.out.println(i);
    }
}
