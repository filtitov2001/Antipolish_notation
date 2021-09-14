package com.company;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] arr) {
        Scanner in = new Scanner(System.in);
        String close = "";
        while(!close.equals("close")) {
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("Если хотите завершить программу введите \"close\".\n Иначе нажмите enter");
            close = in.nextLine();
            if(!close.equals("close")) {
                try {

                    System.out.print("Введите математическое выражение : ");
                    String str = in.nextLine();
                    str = com.company.Calculating.StringToPolsk(str);
                    System.out.print("Польская запись : ");
                    System.out.println(str);
                    System.out.println("Результат операции : " + com.company.Calculating.exchangeToDouble(str));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
