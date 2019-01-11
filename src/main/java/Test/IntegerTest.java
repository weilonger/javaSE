package main.java.Test;

public class IntegerTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1(){
        Integer a = 20;
        Integer b = 20;
        //Number Object use equals()
        if (a != b) {
            System.out.println("success1");
        }
        if (!a.equals(b)){
            System.out.println("success2");
        }
        System.out.println("=====================");
    }

    private static void test2(){
        Integer a = 200;
        Integer b = 200;

        if (a != b) {
            System.out.println("success1");
        }
        if (!a.equals(b)){
            System.out.println("success2");
        }
    }
}
