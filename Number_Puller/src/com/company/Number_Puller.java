package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number_Puller {
    public static void main(String[] args) throws IOException {
        String line, line2;
        FileReader fr = new FileReader("src/com/company/a.txt");
        FileReader fr2 = new FileReader("src/com/company/a.txt");

        BufferedReader read = new BufferedReader(fr);
        BufferedReader read2 = new BufferedReader(fr2);

        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Double> list2 = new ArrayList<Double>();

        while ((line = read.readLine()) != null) {
            Matcher matcher = Pattern.compile("(?<=\\s|^)\\d+(?=\\s|$)").matcher(line);

            System.out.println(line);
            for (int i = 0; i < line.length(); i++) {
                while (matcher.find()) {
                    list.add(Integer.parseInt(matcher.group()));
                    System.out.println(list);
                }
            }
        }

        FileOutputStream fo = new FileOutputStream("src/com/company/b.txt");
        PrintWriter pw = new PrintWriter(fo);

        for (int i : list) {
            pw.println(i);
        }
        pw.close();
        fo.close();

        //----------------------------------------------------------------------

        while ((line2 = read2.readLine()) != null) {
            Matcher matcher2 = Pattern.compile("-?\\d+[.]\\d+").matcher(line2);
            System.out.println(line2);
            for (int i = 0; i < line2.length(); i++) {
                while (matcher2.find()) {
                    list2.add(Double.parseDouble(matcher2.group()));
                    System.out.println(list2);
                }
            }
        }

        FileOutputStream fo2 = new FileOutputStream("src/com/company/c.txt");
        PrintWriter pw2 = new PrintWriter(fo2);

        for (Double i : list2) {
            pw2.println(i);
        }
        pw2.close();
        fo2.close();
    }
}
