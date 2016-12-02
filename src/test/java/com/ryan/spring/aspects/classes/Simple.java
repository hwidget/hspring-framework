package com.ryan.spring.aspects.classes;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/6/30 17:00.
 */

public class Simple {
    static {
        System.out.println("[src] static init");
    }

    public Simple() {
        System.out.println("[src] construct");
    }

    public String welcome(String name) {
        System.out.println("[src]===========start===========");
        System.out.println("[src] welcome method execute");
        System.out.println("[src] welcome method execute");
        System.out.println("[src]===========end===========");
        // throw new RuntimeException("runtime exception");
        return "welcome " + name;
    }

    public static void main(String[] args) {
        Simple simple = new Simple();
        String greeting = simple.welcome("Jack");
        System.out.println(greeting);
    }
}
