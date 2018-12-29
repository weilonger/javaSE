package main.java.jdk8.Stream;

import main.java.Model.Person;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsDemo {
    private static List<Person> javaProgrammers  = new ArrayList<Person>() {
        {
            add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
            add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
            add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
            add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
            add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
            add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
            add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
            add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
            add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
            add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
        }
    };

    private static List<Person> phpProgrammers = new ArrayList<Person>() {
        {
            add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
            add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
            add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
            add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
            add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
            add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
            add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
            add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
            add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
            add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
        }
    };

    //map, filter, limit, sorted, count, min, max, sum, collect
    public static void main(String[] args) {
        namePrint();
        addSalary();
        getAll();
        getPerson();
        test();
    }

    private static void namePrint(){
        System.out.println("所有程序员的姓名:");
        javaProgrammers.forEach((p) -> System.out.printf("%s %s;\n", p.getFirstName(), p.getLastName()));
        System.out.println("---------------");
        phpProgrammers.forEach((p) -> System.out.printf("%s %s;\n", p.getFirstName(), p.getLastName()));
        System.out.println("===============");
    }

    private static void addSalary(){
        System.out.println("给程序员加薪 5% :");
        Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary());
        javaProgrammers.forEach(giveRaise);
        phpProgrammers.forEach(giveRaise);
        System.out.println("===============");
    }

    private static void getPerson(){
        getPersonByFirstname("Jarrod", phpProgrammers).forEach(v -> System.out.println(v.getLastName()));
        System.out.println("---------------");
        getPersonByAge(25, javaProgrammers).forEach(v -> System.out.println(v.getLastName()));
        System.out.println("---------------");
        getSpecial(22, 1150, "female", phpProgrammers);
        System.out.println("===============");
    }

    //stream
    private static List<Person> getPersonByFirstname(String firstname, List<Person> people){
        return people.stream().filter(person -> person.getFirstName().equals(firstname)).collect(Collectors.toList());
    }

    //biFunction limit方法限制个数
    private static List<Person> getPersonByAge(int age, List<Person> people){
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (personAge, personList) -> {
            return personList.stream().filter(person -> person.getAge() > personAge).limit(4).collect(Collectors.toList());
        };
        return biFunction.apply(age, people);
    }

    private static void getAll(){
        //sort
        Collections.sort(javaProgrammers, Comparator.comparingInt(Person::getSalary));
        javaProgrammers.stream().map(Person::getFirstName).forEach(i -> System.out.print(i + " "));
        System.out.println("\n---------------");
        //sorted
        phpProgrammers.stream().sorted(Comparator.comparingInt(Person::getAge)).map(Person::getLastName).forEach(i -> System.out.print(i + " "));
        System.out.println("\n===============");
    }

    //predicate 定义过滤器
    private static void getSpecial(int age, int salary, String gender, List<Person> people){
        Predicate<Person> ageFilter = p -> p.getAge() > age;
        Predicate<Person> salaryFilter = p -> p.getSalary() > salary;
        Predicate<Person> genderFilter = p -> p.getGender().equals(gender);
        System.out.println("下面是年龄大于 " + age + "岁且月薪在$" + salary + "以上的" + (gender.equals("female") ? "女" : "男") + "程序员:");
        people.stream().filter(ageFilter).filter(salaryFilter).filter(genderFilter)
                .forEach(p -> System.out.println(p.getFirstName() + " " + p.getLastName()));
    }

    //SummaryStatistics
    private static void test(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics stats = numbers
                .stream()
                .mapToInt((x) -> x)
                .summaryStatistics();

        System.out.println("List中最大的数字 : " + stats.getMax());
        System.out.println("List中最小的数字 : " + stats.getMin());
        System.out.println("所有数字的总和   : " + stats.getSum());
        System.out.println("所有数字的平均值 : " + stats.getAverage());
    }
}
