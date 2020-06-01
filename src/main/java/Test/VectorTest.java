package main.java.Test;

import java.util.Vector;


public class VectorTest {

    int[] count = new int[10000];

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(5);
        vector.add(6);
        VectorTest vectorTest = new VectorTest();
        vectorTest.hasGroupSizeX(vector);
    }

    private void hasGroupSizeX(Vector<Integer> vector) {
        int len = vector.size();
        for (Integer v : vector) {
            count[v]++;
        }
        for (int i = 0; i < 10000; i++) {
            if (count[i] > 0) {

            }
        }
    }
}
