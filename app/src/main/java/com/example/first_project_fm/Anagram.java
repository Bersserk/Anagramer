package com.example.first_project_fm;

public class Anagram {

    static String buildAnagram(String input, String filter) {

        StringBuilder output = new StringBuilder();

        // Making the anagram for each word
        for (String word : input.split(" ")) {
            output.append(buildAnagramOfWord(new StringBuilder(word), filter.isEmpty()?"default":filter));
        }

        return output.toString();
    }

    private static String buildAnagramOfWord(StringBuilder word, String filter) {

        for (int i = 0, k = word.length() - 1; i < k; ) {
            if (check(word.charAt(i), filter)) {
                i++;
            } else if (check(word.charAt(k), filter)) {
                k--;
            } else {
                char tmp = word.charAt(k);
                word.deleteCharAt(k);
                word.insert(k, word.charAt(i));
                word.deleteCharAt(i);
                word.insert(i, tmp);
                i++;
                k--;
            }
        }

        return word + " ";
    }

    private static boolean check(char i, String filter) {

        if (filter.equals("default"))
            return Character.isAlphabetic(i) ? false : true;
            return filter.indexOf(i) > -1 ? true : false;
    }

}