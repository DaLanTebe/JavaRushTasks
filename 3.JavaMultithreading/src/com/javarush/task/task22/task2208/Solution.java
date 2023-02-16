package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", null);
        hashMap.put("country", null);
        hashMap.put("age", null);
        System.out.println(getQuery(hashMap));
    }

    public static String getQuery(Map<String, String> params) {

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : params.keySet()) {
            if (params.get(s) != null){
                stringBuilder.append(s).append(" = '").append(params.get(s)).append("' ").append("and ");
            }
        }
        if (stringBuilder.length() != 0){
            stringBuilder.replace(stringBuilder.lastIndexOf("and"), stringBuilder.length(), "");
        }
        return stringBuilder.toString().trim();
    }
}
