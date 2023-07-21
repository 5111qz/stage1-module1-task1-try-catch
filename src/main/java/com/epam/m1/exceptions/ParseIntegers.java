package com.epam.m1.exceptions;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class ParseIntegers {
    private static final List<String> WORDS =
            Arrays.asList(
                    "JDK 17 has released on 14 September 2021 with 10 new features, 2 feature removals and 2 feature deprecations."
                            .split(" "));

    public static void main(String[] args) {
        Iterator<String> words = WORDS.iterator();
        int sum = 0;
        String justWords = "";
        StringBuilder stringBuilder = new StringBuilder(justWords);
        while (words.hasNext()) {
            String next = words.next();
            try {
                int number = Integer.parseInt(next);
                sum += number;
            } catch (NumberFormatException e) {
                stringBuilder.append(next).append(" ");
            }
        }
        justWords = stringBuilder.toString().trim();
        Logger logger = Logger.getLogger(ParseIntegers.class.getName());
        logger.log(Level.INFO, "Sum is "+ sum);
        logger.log(Level.INFO, "Just words: " + justWords);
    }
}
