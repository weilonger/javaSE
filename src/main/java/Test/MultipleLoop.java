package main.java.Test;

public class MultipleLoop {

    public static void main(String[] args) {
        multiBreak();
    }

    private static void multiBreak() {
        A:
        for (int i = 0; i < 10; i++) {
            B:
            for (int j = 0; j < 10; j++) {
                C:
                for (int k = 0; k < 10; k++) {
                    if (k == 5) {
                        break A;
                    }
                }
            }
        }
    }


}
