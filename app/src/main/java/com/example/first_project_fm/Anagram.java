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
            output.append(buildAnagramOfWord(word, mFilter));
        }

        return output.toString();
    }

    private static String buildAnagramOfWord(String word, String mFilter) {
        StringBuilder str = new StringBuilder(word);

        for (int i = 0, k = word.length() - 1; i < k; ) {
            if (check(word.charAt(i), mFilter)) {
                if (check(word.charAt(k), mFilter)) {
                    char tmp = word.charAt(k);
                    str.deleteCharAt(k);
                    str.insert(k, word.charAt(i));
                    str.deleteCharAt(i);
                    str.insert(i, tmp);
                    i++;
                    k--;
                } else {
                    k--;
                }
            } else {
                i++;
            }
        }
        return str + " ";
    }

    private static boolean check(char s, String filter) {
        String st = String.valueOf(s);
        return !st.matches(filter);
    }

}