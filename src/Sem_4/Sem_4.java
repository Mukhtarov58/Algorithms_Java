package Sem_4;

import java.util.Comparator;

public class Sem_4 {
    public static void main(String[] args) {
        MyHashMap<Object, String> myHashMap = new MyHashMap<Object, String>(4);
        System.out.println(myHashMap.put(2, "two"));
        System.out.println(myHashMap.put(1, "one"));
        System.out.println(myHashMap.put(2, "three"));
        System.out.println(myHashMap.put(2, "two"));
        System.out.println(myHashMap.put(2.f, "two"));
        System.out.println(myHashMap.put(true, "two"));


    }
}
