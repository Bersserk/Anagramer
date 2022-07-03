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

        for (int i = 0, k = word.length() - 1; i < k; i++, k--) {
            switch (moveOrNot(word.charAt(i), word.charAt(k), mFilter)) {
                case 1:
                    while (String.valueOf(word.charAt(i)).matches(mFilter)) {
                        i++;
                    }
                case 2:
                    while (String.valueOf(word.charAt(k)).matches(mFilter)) {
                        k--;
                    }
                case 4:
                    word = changeChars(i, k, word);
                    break;
                case 3:
                    i++;
                    k--;
                    break;
            }
        }
        return word + " ";
    }

    // filtering method. Returns '1' if the first letter filters, '2' if the second, '4' if none and '3' if both
    private static int moveOrNot(char first, char second, String filter) {
        boolean result1 = String.valueOf(first).matches(filter);
        boolean result2 = String.valueOf(second).matches(filter);
        if (result1 && result2) {
            return 3;
        } else if (result1) {
            return 1;
        } else if (result2) {
            return 2;
        } else {
            return 4;
        }
    }

    // method for change words
    private static String changeChars(int index1, int index2, String tempIn) {
        StringBuilder tempV = new StringBuilder(tempIn);
        char temp = tempV.charAt(index1);
        tempV.setCharAt(index1, tempV.charAt(index2));
        tempV.setCharAt(index2, temp);
        return tempV.toString();
    }

}