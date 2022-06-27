package com.example.first_project_fm;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anagram {

    public static String TAG = "log";
    private String sOutput = "";

    String buildAnagram(String input, String filtr) {

        String strFiltr;

        // задаем фильтр по умолчанию либо пользовательский
        if (filtr.isEmpty()) {
            strFiltr = "[\\W*\\d*]";
        } else {
            strFiltr = "[" + filtr + "]";
        }

        Pattern p = Pattern.compile(strFiltr);

        // Делим строку на слова (если в строке их больше одного) и заносим в массив слов
        String[] arrayWords = Pattern.compile("\\s").split(input);

        // смотрим каждое слово в массиве
        for (String s : arrayWords) {
            makeAnagram(s, p);
            sOutput += " ";
        }
        return sOutput;
    }

    private String makeAnagram(String s, Pattern p) {
        TreeMap<Integer, String> states = new TreeMap<Integer, String>();
        StringBuilder stringBuilder = new StringBuilder(s);
        Matcher m = p.matcher(s);

        int i = 0;
        while (m.find()) {
            states.put(m.start(), m.group());
            stringBuilder.deleteCharAt(m.start() - i);
            i++;
        }

        char arr[] = stringBuilder.reverse().toString().toCharArray(); // convert the String object to array of char

        int k = 0;
        for (char c : arr) {
            while (states.containsKey(k)) {
                k++;
            }
            states.put(k, String.valueOf(c));
        }

        for (
                Map.Entry<Integer, String> item : states.entrySet()) {
            this.sOutput += item.getValue();
        }

        return this.sOutput;
    }
}