package com.chenzeqin.threadLocal;

import java.util.concurrent.TimeUnit;

/**
 * @author chenzeqin
 * date 2020/7/11
 */
public class ThreadLocalTest {
    static class Person{
        String name = "zhangsan";
    }

    public static ThreadLocal<Person> tp = new ThreadLocal<Person>();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(tp.get());
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tp.set(new Person());
            }
        }).start();
        tp.remove();
    }

}
