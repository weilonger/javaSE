package main.java.jdk8.Lamada;

import java.util.*;

public class LambdaDemo {

    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);
//        forTest2(players);
        sortTest(players);
//        sortTest1(atp, players);
//        sortTest2(atp, players);
//        sortTest3(players);

        String string1 = "1995.04.17";
        String string3 = "1997.01.29";
        String string2 = "1996.11.07";
        List<String> list = new ArrayList<>();
        list.add(string2);
        list.add(string1);
        list.add(string3);
        sortTest(list);
    }

    // 以前的循环方式
    private static  void forTest1(List<String> players){
        System.out.println("=================method1 普通foreach");
        for (String player : players) {
            System.out.println(player + "; ");
        }
    }

    //使用 lambda 表达式以及函数操作(functional operation)
    private static  void forTest2(List<String> players){
        System.out.println("=================method2 lambda expression排序");
        players.forEach((player) -> System.out.println(player + "; "));
    }

    // 在 Java 8 中使用双冒号操作符(double colon operator)
    private static  void forTest3(List<String> players){
        System.out.println("=================method3 method reference");
        players.forEach(System.out::println);
    }

    //匿名内部类
    private static void sortTest(List<String> players){
        System.out.println("=================匿名内部类首字母排序");
        //style1
        Collections.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2.compareTo(s1));
            }
        });
        //style2
//        Collections.sort(players, (s1,s2) -> s1.compareTo(s2));
        //style3
//        Collections.sort(players, String::compareTo);
        //reverseOrder() 按逆序排序 naturalOrder 按正序排序 jdk1.8新函数
        //style4
//        Collections.sort(players, Comparator.naturalOrder());
        players.forEach(System.out::println);
    }

    // 1.1 方式1：使用匿名内部类根据 surname 排序 players
    private static void sortTest1(String[] atp, List<String> players) {
        System.out.println("=================匿名内部类第二个单词首字母排序");
        Arrays.sort(atp, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
            }
        });
        players.forEach(System.out::println);
    }

    // 1.2 方式2：使用 lambda expression 排序,根据 surname
    private static void sortTest2(String[] atp, List<String> players){
        System.out.println("=================匿名内部类最后一个字母lambda expression排序");
        Comparator<String> sortByLastLetter =
                (s1, s2) ->
                        (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
        Arrays.sort(atp, sortByLastLetter);
        players.forEach(System.out::println);
    }

    // 1.3 方式3  lamada排序
    private static void sortTest3(List<String> players){
        System.out.println("=================匿名内部类长度排序");
        Collections.sort(players, (s1, s2) -> (s1.length() - s2.length()));
        players.forEach(System.out::println);
    }
}
