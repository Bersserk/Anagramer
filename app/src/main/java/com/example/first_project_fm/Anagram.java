package com.example.first_project_fm;

import android.util.Log;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anagram {

    public static String TAG = "log";


    private TreeMap<Integer, String> states = new TreeMap<Integer, String>();


    String buildAnagram(String input, String filtr) {

        String strFiltr;
        String sOutput = "";

        // задаем фильтр по умолчанию либо пользовательский
        if (filtr.isEmpty()) {
            strFiltr = "[^\\W\\d]";
        } else {
            strFiltr = "[" + filtr + "]";
        }

        Pattern p = Pattern.compile(strFiltr);

        // Делим строку на слова (если в строке их больше одного) и заносим в массив слов
        String[] arrayWords = Pattern.compile("\\s").split(input);

        // смотрим каждое слово в массиве
        for (String s : arrayWords) {

            addFilteringValues(s, p);
            // addNonFilterValues();

        }


        // перебор элементов
        for (
                Map.Entry<Integer, String> item : this.states.entrySet()) {
            sOutput += item.getValue() + " (" + item.getKey() + ")";
        }
        sOutput += " ";

        return sOutput + " ";
    }

    private void addFilteringValues(String s, Pattern p) {
        Matcher m = p.matcher(s);
        while (m.find()) {

            if (!s.equals(m.group())) {
                Log.i(TAG, "строка равно фильтру");
                states.put(m.start(), m.group());
                Log.i(TAG, states.get(m.start()));
            }


        }
    }

    private void addValue(TreeMap<Integer, String> st, String s, Pattern p) {
        Matcher m = p.matcher(s);

        while (m.find()) {

            for (int i = s.length() - 1; i >= 0; i--) {
                while (i >= 0 && !states.containsKey(i)) {
                    i--;
                }
                states.put(i + 1, m.group());
            }

        }


    }





}