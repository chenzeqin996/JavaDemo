package com.chenzeqin.threadLocal;

import java.lang.ref.WeakReference;

/**
 * @author chenzeqin
 * date 2020/7/11
 */
public class WeakReferenceTest {
    static class Person {
        String name = "zhangsan";
    }
    public static void main(String[] args) {
        Person p1 = new Person();
        WeakReference<Person> wp1 = new WeakReference<Person>(p1);
        System.out.println(wp1.get());
        System.gc();
        System.out.println(wp1.get());
        System.out.println("1===============");
        Person p = new Person();
        WeakReference<Person> wp2 = new WeakReference<Person>(p);
        System.out.println(wp2.get());
        p = null;
        System.gc();
        System.out.println(wp2.get());
        System.out.println("2===============");
        WeakReference<Person> wp3 = new WeakReference<Person>(new Person());
        System.out.println(wp3.get());
        System.gc();
        System.out.println(wp3.get());
    }
}
