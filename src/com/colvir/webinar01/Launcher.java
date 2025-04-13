package com.colvir.webinar01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Launcher {

    private static String readFromFile(String pFileName ){
        String sContent = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pFileName));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            reader.close();
            sContent = stringBuilder.toString();
        } catch (IOException e){
            e.printStackTrace(); // asdasdasasdasdasd
        }

        return sContent;
    }

    public static void main(String[] args) {
        String inputFile = "resources\\input.txt";
        String content = readFromFile(inputFile);
        String regex = "[ \\n,.!\\s]";
        // String result[] = content.split(regex, -1);
        String[] result = Arrays.stream(content.split(regex))
                            .filter(str -> !str.isEmpty())
                            .map(String::toLowerCase)
                            .toList()
                            .stream().sorted()
                            .toArray(String[]::new);
        for (String s : result) {
            System.out.print(s);
        }
    }
}
