package com.chenzeqin.threadLocal;

import java.lang.ref.SoftReference;

/**
 * @author chenzeqin
 * date 2020/7/11
 */
public class SoftReferenceTest {
    static class Person {
        String name = "zhangsan";
    }
    public static void main(String[] args) {
        Person p1 = new Person();
        SoftReference<Person> wp1 = new SoftReference<Person>(p1);
        System.out.println(wp1.get());
        p1 = null;
        System.gc();
        System.out.println(wp1.get());
        System.out.println(p1);
    }
}
