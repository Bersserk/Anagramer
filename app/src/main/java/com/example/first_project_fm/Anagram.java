package com.example.first_project_fm;

import android.text.Editable;
import android.util.Log;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.first_project_fm.MainActivity.TAG;

public class Anagram {

    public static String TAG = "log";

    static String buildAnagram(String input, String text){
        //Log.d(TAG, "Anagram/input: " + input);
        //Log.d(TAG, "Anagram/filtr: " + text);

        String strIn = input;
        String strFiltr = "[" + text + "]+";
        //String strFiltr = "[\\d\\W]+";

        String sOutput = "";
        Pattern pattern = Pattern.compile("\\s");

        String[] arrStr = pattern.split(strIn);
        //Log.d(TAG, "Anagram/input: " + input);
        //Log.d(TAG, "Anagram/arrStr[0]: " + arrStr[0]);

        //Log.d(TAG, "Anagram/arrStr.length: " + arrStr.length);

        for (String s : arrStr) {

            TreeMap<Integer, String> states = new TreeMap<Integer, String>();

            Matcher m = Pattern.compile("[^"+strFiltr+"]").matcher(s);
            Matcher m2 = Pattern.compile(strFiltr).matcher(s);

          //  Log.d(TAG, "Anagram/m.group: " + m.group());
            //Log.d(TAG, "Anagram/m.toString: " + m.toString());
            //Log.d(TAG, "Anagram/m2.toString: " + m2.toString());

            // находим фильтрующие значения и добавляем их в мапу на своих индекс местах
            while (m2.find()) {
               // Log.d(TAG, "Anagram/while1: " + m2.find());
                states.put(m2.start(), m2.group());
            }

            /* находим все не фильтрованные значения и добавляем их в папу с зеркальным и идексом (задом наперед)
             пропуская уже занятые индексы */
            int k = s.length() - 1;;
            while (m.find()) {

                //Log.d(TAG, "Anagram/while2: " + m.find());

                // проверяем пуст ли ключ с данным индексом
                while (states.containsKey(k)) {
                    k--;
                }
                states.put(k, m.group());
            }

            //Log.d(TAG, "Anagram/states size: " + states.size());

            // перебор элементов
            for (
                    Map.Entry<Integer, String> item : states.entrySet()) {
                sOutput += item.getValue();
            }
            sOutput += " ";

            //Log.d(TAG, "Anagram/sOutput: " + sOutput);
        }
        //System.out.print(sOutput + " ");
        return sOutput + " ";
    }
}
