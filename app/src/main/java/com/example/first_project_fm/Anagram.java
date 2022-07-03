package com.example.first_project_fm;

public class Anagram {

    static String buildAnagram(String input, String filter) {

        String output = "";

        // Dividing a string into words and adding them into array of words
        String[] arrayWords = input.split("\\s");

        // Determining the filter
        String mFilter = "[" + filter + "]";
        if (filter.equals("")) {
            mFilter = "[\\W\\d*]";
        }

        // Making the anagram for each word
        for (String word : arrayWords) {
            output += buildAnagramOfWord(word, mFilter);
        }

        return output;
    }

    private static String buildAnagramOfWord(String word, String mFilter) {
        StringBuilder returnString = new StringBuilder();
        char[] inputArray = word.toCharArray();

        // selecting characters that do not match the filter
        for (Character charArray : inputArray) {
            boolean result = charArray.toString().matches(mFilter);
            if (!result)
                returnString.append(charArray);
        }

        returnString.reverse();

        // adding characters that do match the filter
        int k = 0;
        for (Character charArray : inputArray) {
            boolean result = charArray.toString().matches(mFilter);
            if (result)
                returnString.insert(k, charArray);
            k++;
        }

        return returnString.toString() + " ";
    }

}