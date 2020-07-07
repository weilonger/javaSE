package main.java.InterviewPrepare.DesignPattern;

import java.io.Serializable;

/**
 * 饿汉式
 */
public class Singleton implements Serializable {

    private static Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }

}
