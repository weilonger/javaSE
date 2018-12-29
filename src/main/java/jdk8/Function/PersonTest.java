package main.java.jdk8.Function;

import main.java.Model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonTest {
    private static List<Person> people  = new ArrayList<Person>() {
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

    public static void main(String[] args) {

    }

    private static List<Person> getPersonByFirstname(String firstname, List<Person> people){
        return people.stream().filter(person -> person.getFirstName().equals(firstname)).collect(Collectors.toList());
    }


}
