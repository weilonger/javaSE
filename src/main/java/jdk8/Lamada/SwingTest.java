package main.java.jdk8.Lamada;

import javax.swing.*;

public class SwingTest {

    public static void main(String[] args) {
        test1();
        SwingTest1();
    }

    private static void SwingTest1(){
        JFrame jFrame = new JFrame("My JFrame");
        JButton jButton = new JButton("My JButton");
        jButton.addActionListener(e -> System.out.println("Button Pressed!"));
        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void myTest(MyInterface myInterface){
        myInterface.test();
    }

    private static void test1(){
        SwingTest swingTest = new SwingTest();
        swingTest.myTest(() -> System.out.println("test myInterface"));
    }

}
