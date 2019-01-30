package main.java.leetcode.compete8;

/*题目描述
    29. 两数相除
    给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
    返回被除数 dividend 除以除数 divisor 得到的商。
*/
/*示例1 :
    输入: dividend = 10, divisor = 3
    输出: 3
*/
/*示例2 :
    输入: dividend = 7, divisor = -3
    输出: -2
*/
/*
说明:
    被除数和除数均为 32 位有符号整数。除数不为 0。
    假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
*/
public class DivideTowIntegers {
    //7017ms
    public int divide(int dividend, int divisor) {
        int i = 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        int sum = dividend;
        Boolean status = true;
        if (dividend < 0 && divisor > 0 || (dividend > 0 && divisor < 0)) {
            status = false;
        }
        if (status) {
            if (dividend == divisor) {
                return 1;
            }
            sum = subtract(sum, divisor);
            while (sum >= 0 && dividend > 0 || (sum <= 0 && dividend < 0)) {
                sum = subtract(sum, divisor);
                i++;
            }
        } else {
            if (dividend == -divisor) {
                return -1;
            }
            sum = add(sum, divisor);
            while (sum >= 0 && dividend > 0 || (sum <= 0 && dividend < 0)) {
                sum = add(sum, divisor);
                i--;
            }
        }
        return i;
    }

    private int add(int v1, int v2) {
        int sum = v1;;
        if (v2 > 0) {
            for (int j = 0; j < v2; j++) {
                sum++;
            }
        } else {
            for (int j = 0; j > v2; j--) {
                sum--;
            }
        }
        return sum;
    }

    private int subtract(int v1, int v2) {
        int div = v1;
        if (v2 > 0) {
            for (int j = 0; j < v2; j++) {
                div--;
            }
        } else {
            for (int j = 0; j > v2; j--) {
                div++;
            }
        }
        return div;
    }

    //评论区大神 24 ms
    //移位  1）负数的表示方法（最高位为1，减去其余位） 2）使用左移形成2的指数倍，加快运算
    public int divide1(int dividend, int divisor) {
        //处理异常
        if(divisor==0) return 0;
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        //处理最大最小值取模的情况。
        long divid = (long)dividend;
        long divi = (long)divisor;
        //减少重复运算
        if(divi==1) return (int) divid;
        if(divi==-1){
            //处理溢出
            if(divid<=min)
                return max;
            return (int)-divid;
        }
        boolean flag=true;
        //处理符号
        if(divid<0){
            divid=-divid;
            if(divi<0){
                divi=-divi;
            }else{
                flag=false;
            }
        }else if(divi<0){
            divi=-divi;
            flag=false;
        }
        long res = 0;
        long tmp = 0;
        long cnt =1;
        while(divi<=divid){
            //2^n次方
            cnt = 1;
            tmp = divi;
            //找到第一个大于被除数的2^n次方
            while(tmp<=divid){
                tmp<<=1;
                cnt<<=1;
            }
            res+=(cnt>>1);
            //减去基数的前一个数
            divid-=(tmp>>1);
        }
        return flag?(int)res:(int)-res;
    }

    public static void main(String[] args) {
        DivideTowIntegers d = new DivideTowIntegers();
        int dividend = -2147483648;
        int divisor = 2;
        System.out.println(d.divide1(dividend, divisor));
    }
}
