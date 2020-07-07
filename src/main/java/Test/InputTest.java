package main.java.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputTest {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        System.out.println(s);
//        scanner.close();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String t = br.readLine();
            System.out.println(t);
        } catch (IOException e) {
            System.out.println("" + e);
        }

    }
}
