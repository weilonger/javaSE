package main.java.Test;

import java.util.Arrays;
import java.util.List;

public class StringTest {

    public static void main(String[] args) {
        String temp = "";
        List<String> result = Arrays.asList(temp.split(","));
        result.forEach(System.out::println);
        String a = "a";
        StringBuffer b = new StringBuffer();
        b.append("b");
        StringBuilder c = new StringBuilder();
        c.append("c");

        String s = "a";
        System.out.println(a == s);
//        StringTest test = new StringTest();
        String tag="速度与激情";//正确的
        String test1="速度与激情1";
        System.out.println(test1.lastIndexOf(tag));
//        String test2="速度与激情之利刃出击";
//        String test3="速度与激情3";
//        String test4="《速度与激情》";
//        String test5="速度";
//        String test6="度情";
//        String test7="《无双》讲的是画家";
//        System.out.println("similarity=" + test.getSimilarityRatio(test1, tag));
//        System.out.println("similarity=" + test.getSimilarityRatio(test2, tag));
//        System.out.println("similarity=" + test.getSimilarityRatio(test3, tag));
//        System.out.println("similarity=" + test.getSimilarityRatio(test4, tag));
//        System.out.println("similarity=" + test.getSimilarityRatio(test5, tag));
//        System.out.println("similarity=" + test.getSimilarityRatio(test6, tag));
//        System.out.println("similarity=" + test.getSimilarityRatio(test7, tag));
    }

    //字符串相似度算法
    private int compare(String str, String target){
        int d[][];              // 矩阵
        int n = str.length();
        int m = target.length();
        int i;                  // 遍历str的
        int j;                  // 遍历target的
        char ch1;               // str的
        char ch2;               // target的
        int temp;               // 记录相同字符,在某个矩阵位置值的增量,不是0就是1
        if (n == 0) { return m; }
        if (m == 0) { return n; }
        d = new int[n + 1][m + 1];
        for (i = 0; i <= n; i++) {                       // 初始化第一列
            d[i][0] = i;
        }
    
        for (j = 0; j <= m; j++) {                       // 初始化第一行
            d[0][j] = j;
        }
    
        for (i = 1; i <= n; i++) {                       // 遍历str
            ch1 = str.charAt(i - 1);
            // 去匹配target
            for (j = 1; j <= m; j++) {
                ch2 = target.charAt(j - 1);
                if (ch1 == ch2 || ch1 == ch2+32 || ch1+32 == ch2) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                // 左边+1,上边+1, 左上角+temp取最小
                d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + temp);
            }
        }
        return d[n][m];
    }

    private int min(int one, int two, int three) {
        return (one = one < two ? one : two) < three ? one : three;
    }

    public float getSimilarityRatio(String str, String target) {
        return 1 - (float) compare(str, target) / Math.max(str.length(), target.length());
    }
}
