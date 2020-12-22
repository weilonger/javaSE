package main.java.Model;

public class CourceAndPerson {
    private String id;
    private String pid;
    private String firstName;
    private String lastName;
    private String job;
    private String gender;
    private int salary;
    private int age;
    private String name;

    public CourceAndPerson (Person p, Course c) {
        this.id = c.getId();
        this.pid = p.getId();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.job = p.getJob();
        this.gender = p.getGender();
        this.salary = p.getSalary();
        this.age = p.getAge();
        this.name = c.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
