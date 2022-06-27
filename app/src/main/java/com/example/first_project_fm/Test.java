package com.example.first_project_fm;


import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String args[]) {

        String strIn = "a1bcd efg!h";
        String strFiltr = "[\\d\\W]+";

        String sOutput = "";
        Pattern pattern = Pattern.compile("\\s");
        String[] arrStr = pattern.split(strIn);

        for (String s : arrStr) {

            TreeMap<Integer, String> states = new TreeMap<Integer, String>();

            Matcher m = Pattern.compile("[^"+strFiltr+"]").matcher(s);
            Matcher m2 = Pattern.compile(strFiltr).matcher(s);

            // находим фильтрующие значения и добавляем их в мапу на своих индекс местах
            while (m2.find()) {
                states.put(m2.start(), m2.group());
            }

            /* находим все не фильтрованные значения и добавляем их в папу с зеркальным и идексом (задом наперед)
             пропуская уже занятые индексы */
            int k = s.length() - 1;;
            while (m.find()) {

                // проверяем пуст ли ключ с данным индексом
                while (states.containsKey(k)) {
                    k--;
                }
                states.put(k, m.group());
            }

            // перебор элементов
            for (
                    Map.Entry<Integer, String> item : states.entrySet()) {
                sOutput += item.getValue();
            }
            sOutput += " ";
        }
        System.out.print(sOutput + " ");
    }
}
