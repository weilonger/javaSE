package main.java.Test.question;

class Person {
    public void say() {
        System.out.println("Person");
    }
}

//定义Parent类实现Person类
class Parent extends Person {
    public void say() {
        System.out.println("Parent");
    }
}

//定义Child类实现Person类
class Child extends Person{
    public void say() {
        System.out.println("Child");
    }
}

class TestInstanceof {
    public static void main(String[] args) {
/*Person p = new Child();	//向上转型
Parent o = (Parent) p;	//向下转型*/
        Person p = new Child();
//        if (p instanceof Person) {
            Parent o = (Parent) p;
            o.say();
//        } else if(p instanceof Child){
//            Child o = (Child) p;
//            o.say();
//        }
        
    }
}