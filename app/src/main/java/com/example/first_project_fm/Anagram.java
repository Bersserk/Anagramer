package com.example.first_project_fm;

public class Anagram {

    static String buildAnagram (String input, String filter) {

        StringBuilder output = new StringBuilder();

        // Making the anagram for each word
        for (String word : input.split("\\s")) {
            output.append(buildAnagramOfWord(word, filter));
        }
        return output.toString();
    }

    private static String buildAnagramOfWord (String word, String filter) {
        // StringBuilder newWord = new StringBuilder(word);
        char[] wordArray = word.toCharArray();

        for (int i = 0, k = wordArray.length - 1; i < k; )
            if (check(wordArray[i], filter)) {
                i++;
            } else if (check(wordArray[k], filter)) {
                k--;
            } else {
                char tmp = wordArray[k];
                wordArray[k] = wordArray[i];
                wordArray[i] = tmp;
                i++;
                k--;
            }

        return String.valueOf(wordArray) + " ";
    }

    private static boolean check (char i, String filter) {

        if (filter.isEmpty()) {
            return !Character.isAlphabetic(i);
        } else {
            return filter.indexOf(i) > -1;
        }
    }

}