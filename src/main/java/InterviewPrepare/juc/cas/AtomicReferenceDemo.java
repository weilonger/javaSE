package main.java.InterviewPrepare.juc.cas;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {


    public static void main(String[] args) {

        User weilong = new User("weilong", 26);
        User qilin = new User("qilin", 25);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(weilong);

        System.out.println(atomicReference.compareAndSet(weilong, qilin) + "\t" + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(weilong, qilin) + "\t" + atomicReference.get().toString());
    }
}

