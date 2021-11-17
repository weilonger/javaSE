package main.java.InterviewPrepare.juc.helper;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
//        countDownLatchDemo.testCountDownLatch1();
        countDownLatchDemo.testCountDownLatch2();
    }

    public void testCountDownLatch1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 同学" + finalI +  "上完自习，离开教室");
                countDownLatch.countDown();
            }, "thread" + i).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 班长关门离开");
    }

    public void testCountDownLatch2() throws InterruptedException {
        CountryEnum[] countryEnums = CountryEnum.values();
        CountDownLatch countDownLatch = new CountDownLatch(countryEnums.length * 2);
        for (CountryEnum countryEnum : countryEnums) {
            new Thread(() -> {
                String deadYear = countryEnum.getDeadYear();
                String deadTime = "公元" + deadYear.replace("-", "前");
                System.out.println(deadTime + Thread.currentThread().getName() + "被灭了！");
                countDownLatch.countDown();
            }, countryEnum.getName()).start();
        }
        TimeUnit.SECONDS.sleep(1);
        for (int i = 1; i <= countryEnums.length; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "被灭了！");
                countDownLatch.countDown();
            }, CountryEnum.forEachCountryEnum(i).getName()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " 秦国统一中国");
    }


}
