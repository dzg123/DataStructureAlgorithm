package com.dzg.test;

import java.util.ArrayList;

public class A {
    public void test(int i){
        System.out.println("a"+i);
    }

    public static void main(String[] args) {
        A a = new B();
        B b = (B) a;
        A c = new A();
        a.test(100);
        b.test(100);
        c.test(100);
        ArrayList<Object> list = new ArrayList<>();
//        list.stream().flatMap()
    }
}
class B extends A{
    @Override
    public void test(int i) {
        System.out.println("b"+i);
    }
}
