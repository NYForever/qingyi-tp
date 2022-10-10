package com.qytp.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wenan.ren
 * @date 2022/9/13 14:04
 * @Description
 */
public class OtherTest {

    public static void main(String[] args) {

        List<Long> list = new ArrayList<>();
        list.add(100L);
        list.add(101L);

        if(list.contains(100)){
            System.out.println("sss");
        }


    /*    List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        Map<String,List<String>> map = new HashMap<>();
        map.put("rwn",list);

        List<String> rwnList = map.get("rwn");
        rwnList.add("d");

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            for (String s : value) {
                System.out.println(s);
            }
        }*/
    }
}
