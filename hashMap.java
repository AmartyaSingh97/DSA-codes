package com.company;
import java.util.*;

public class hashMap {

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int key=69;
        map.putIfAbsent(key,0);
        map.put(key, map.get(key)+1);
    }

}
