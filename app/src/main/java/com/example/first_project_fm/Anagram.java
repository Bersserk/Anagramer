package com.example.first_project_fm;

public class Anagram {

    static String buildAnagram(String input, String filter) {

        StringBuilder output = new StringBuilder();

        // Making the anagram for each word
        for (String word : input.split("\\s")) {
            output.append(buildAnagramOfWord(word, filter));
        }
        return output.toString();
    }

    private static String buildAnagramOfWord(String word, String filter) {
        StringBuilder newWord = new StringBuilder(word);

        for (int i = 0, k = newWord.length() - 1; i < k; )
            if (check(newWord.charAt(i), filter)) i++;
            else if (check(newWord.charAt(k), filter)) k--;
            else {
                char tmp = newWord.charAt(k);
                newWord.deleteCharAt(k);
                newWord.insert(k, newWord.charAt(i));
                newWord.deleteCharAt(i);
                newWord.insert(i, tmp);
                i++;
                k--;
            }

        return newWord + " ";
    }

    private static boolean check(char i, String filter) {

        if (filter.isEmpty())
            return !Character.isAlphabetic(i);
        return filter.indexOf(i) > -1;
    }

}