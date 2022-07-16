package com.example.first_project_fm;

public class Anagram {

    static String buildAnagram(String input, String filter) {

        StringBuilder output = new StringBuilder();

        // Dividing a string into words and adding them into array of words
        String[] arrayWords = input.split("\\s");

        // Determining the filter
        String mFilter = "[" + filter + "]";
        if (filter.equals("")) {
            mFilter = "[\\W\\d*]";
        }

        // Making the anagram for each word
        for (String word : arrayWords) {
            output.append(buildAnagramOfWord(new StringBuilder(word), mFilter));
        }

        return output.toString();
    }

    private static String buildAnagramOfWord(StringBuilder word, String mFilter) {

        for (int i = 0, k = word.length() - 1; i < k; ) {
            if (check(word.charAt(i), mFilter)) {
                i++;
            } else if (check(word.charAt(k), mFilter)) {
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
        return String.valueOf(i).matches(filter);
    }

}