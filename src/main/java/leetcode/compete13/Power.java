package main.java.leetcode.compete13;

public class Power {

    public double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            N = -N;
            x = 1/x;
        }
        return fastPower(x, N);
    }

    private double fastPower(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        long n1 = n / 2;
        double half = fastPower(x, n1);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        Power power = new Power();
        double x = 2.00000;
        int n = 10;
        System.out.println(power.myPow(x, n));
    }

}
