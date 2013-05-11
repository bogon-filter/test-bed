package org.personal.testbed.regex;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestHarness {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // console doesn't work on eclipse
        /*
         * Console console = System.console(); if(console == null) {
         * System.out.println("no console"); System.exit(1); }
         */BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
         System.out.println("Enter your regex string");
         String regexStr = bufferedReader.readLine();
         Pattern pattern = Pattern.compile(regexStr);
        while (true) {
            System.out.println("Enter your pattern");
            String matcherStr = bufferedReader.readLine();
            Matcher matcher = pattern.matcher(matcherStr);
            if (matcher.find()) {
                System.out.println("match found");
                System.out.println(matcher.start() + ", " + matcher.end());
            } else {
                System.out.println("Nooo");
            }
        }
    }

}
