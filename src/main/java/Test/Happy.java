package main.java.Test;

public class Happy {
    static String s = "hello";

    public static void main(String[] args) {
        Happy happy = new Happy();
        happy.methodA(s);
        System.out.println(s);
    }

    public void methodA(String s) {
        s = s.replace('e', 'a');
        this.s = s.concat(" world");
    }
}
