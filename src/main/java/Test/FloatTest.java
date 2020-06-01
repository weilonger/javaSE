package main.java.Test;

public class FloatTest {

    public static void main(String[] args) {
        FloatTest floatTest = new FloatTest();
        floatTest.test1();
    }

    private void test1() {
        String num = "0.4";
        Double temp1 = Double.parseDouble(num);
        System.out.println(temp1);
        Float temp =  Float.parseFloat(num);
        Double result = (double) temp;
        System.out.println(result);
    }
}
