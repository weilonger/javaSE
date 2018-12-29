package main.java.jdk8.Function;

import main.java.jdk8.Lamada.MyInterface;
import main.java.jdk8.Lamada.MyInterface2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        myTest1();
        myTest2();
        myTest3();
        myTest4();
    }

    private static void myTest1(){
        MyInterface i1 = () -> {};
        System.out.println(i1.getClass().getInterfaces()[0]);
        MyInterface2 i2 = () -> {};
        System.out.println(i2.getClass().getInterfaces()[0]);
//        new Thread(() -> System.out.println("Hello World")).start();
        System.out.println("===============");
    }

    private static void myTest2(){
        List<String> list = Arrays.asList("hello","world","hello world");
        List<String> list2 = new ArrayList<>();

        list.forEach(i -> System.out.println(i.toUpperCase()));
        System.out.println("----------------");
        list2.forEach(System.out::println);
//        System.out.println("----------------");
//        list.stream().map(i -> i.toUpperCase()).forEach(i -> System.out.println(i));
        System.out.println("----------------");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("----------------");
        Function<String, String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);
        System.out.println("===============");
    }

    /**
     * ***重点
     * 传递的是方法、不是值
     */
    private static void myTest3(){
        FunctionDemo demo = new FunctionDemo();
        System.out.println(demo.compute(1, value -> 2 * value));
        System.out.println(demo.compute(2, value -> value + 5));
        System.out.println("---------------");
        System.out.println(demo.convert(5, value -> String.valueOf("Hello World " + value)));
        System.out.println("---------------");
        Function<Integer, Integer> function = value -> value * 2;
        System.out.println(demo.compute(2,function));
        System.out.println("===============");
    }

    private int compute(int a, Function<Integer, Integer> function){
        return function.apply(a);
    }

    private String convert(int a, Function<Integer, String> function){
        return function.apply(a);
    }

    private static void myTest4(){
        FunctionDemo demo = new FunctionDemo();
        System.out.println(demo.compute1(2, value -> value * 3, value -> value * value));
        System.out.println(demo.compute2(2, value -> value * 3, value -> value * value));
        System.out.println("---------------");
        System.out.println(demo.compute3(5, 20, (value1, value2) -> value1 + value2 ));
        System.out.println(demo.compute3(5, 20, (value1, value2) -> value2 - value1 ));
        System.out.println("---------------");
        System.out.println(demo.compute4(2, 3, (value1, value2) -> (value1 + value2), value -> value * value));
        System.out.println("===============");
    }

    /**
     * 先执行function2，在执行function1
     * @param a
     * @param function1
     * @param function2
     * @return
     */
    private int compute1(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.compose(function2).apply(a);
    }

    /**
     * 先执行function1，再执行function2
     * @param a
     * @param function1
     * @param function2
     * @return
     */
    private int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.andThen(function2).apply(a);
    }

    /**
     * BiFunction
     * @param a
     * @param b
     * @param biFunction
     * @return
     */
    private int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction){
        return biFunction.apply(a, b);
    }

    /**
     * BiFunction只有andthen方法，没有composer方法
     * @param a
     * @param b
     * @param biFunction
     * @param function
     * @return
     */
    private int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function){
        return biFunction.andThen(function).apply(a, b);
    }

}
