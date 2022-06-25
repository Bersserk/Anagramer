package com.example.first_project_fm;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anagram {

    public static String TAG = "log";
    static TreeMap<Integer, String> states = new TreeMap<Integer, String>();


    static String buildAnagram(String input, String filtr) {
        //Log.d(TAG, "Anagram/input: " + input);
        //Log.d(TAG, "Anagram/filtr: " + filtr);
        String strIn = input;
        String strFiltr;
        String sOutput = "";




        if (filtr.isEmpty()) {
            strFiltr = "[^\\W\\d]";
            //sOutput = "if";
        } else {

            strFiltr = "[" + filtr + "]";
            //sOutput = "else";
        }

        Pattern p = Pattern.compile(strFiltr);

        // Делим строку на слова (если в строке их больше одного) и заносим в массив слов
        String[] arrayWords = Pattern.compile("\\s").split(strIn);

        // смотрим каждое слово в массиве
        for (String s : arrayWords) {

            addFilteringValues(states, s, p);
            // addNonFilterValues();

        }


        //Log.d(TAG, "Anagram/input: " + input);
        //Log.d(TAG, "Anagram/arrStr[0]: " + arrStr[0]);

        //Log.d(TAG, "Anagram/arrStr.length: " + arrStr.length);



            /* находим все не фильтрованные значения и добавляем их в папу с зеркальным и идексом (задом наперед)
             пропуская уже занятые индексы
        int k = s.length() - 1;
        ;
        while (m.find()) {

            //Log.d(TAG, "Anagram/while2: " + m.find());

            // проверяем пуст ли ключ с данным индексом
            while (states.containsKey(k)) {
                k--;
            }
            states.put(k, m.group());
        }

        //Log.d(TAG, "Anagram/states size: " + states.size());



        //Log.d(TAG, "Anagram/sOutput: " + sOutput);
    }

    */
        //System.out.print(sOutput + " ");

        // перебор элементов
        for (
                Map.Entry<Integer, String> item : states.entrySet()) {
            sOutput += item.getValue() + " (" + item.getKey() + ")";
        }
        sOutput += " ";

        return sOutput + " ";
    }

    private static void addFilteringValues(TreeMap<Integer, String> st, String s, Pattern f) {
        addValue(st, s, f);
        //addValue(st, s, "");

    }

    private static void addValue(TreeMap<Integer, String> st, String s, Pattern f) {
        Matcher m = f.matcher(s);

        while (m.find()) {

            for (int i = s.length()-1; i >= 0 ; i--) {
                while (i>=0 && !states.containsKey(i)) {
                    i--;
                }
                states.put(i+1, m.group());
            }

        }


    }


}