package com.company;
import java.io.*;// чтение и запись файлов
import java.util.*;// ввод с клавиатуры
public class Main {

    private static char[] upper = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N', 'O','P','Q',
                    'R','S','T','U','V','W','X','Y','Z'};// верхний регистр

    private static char[] lower= {'a','b','c','d','e','f','g','h',
            'i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};// нижний регистр

    private static final int n = 26;// кол-во символов массива(английский алфавит)
    private static final int k = 3;// ключ к шифру

    public static void main(String[] args)throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите сообщение для зашифровки");
        String input = s.nextLine();
        StringBuilder output = new StringBuilder();
        for(int x = 0; x < input.length(); ++x){
            char c = input.charAt(x);
            if(findIndLower(c) == -1){
                int v = (findIndUpper(c)+k)%n;
                output.append(upper[v]);
            }
            if(findIndUpper(c) == -1){
                int v = (findIndLower(c)+k)%n;
                output.append(lower[v]);
            }
        }
        File file = new File("crypto_text.txt");
        PrintWriter pw = new PrintWriter(file);// запись файла
        pw.println(output.toString());// вывод текста в файл
        pw.close();
        System.out.println(input + " - исходное сообщение");
        System.out.println(output.toString() + " - это сообщение сохранено в crypto_text.txt");
    }

    private static int findIndUpper(char c){
        int rez = -1;
        for(int x = 0; x < upper.length; ++x){
            if(c == upper[x]) rez = x;
        }
        return rez;
    }

    private static int findIndLower(char c){
        int rez = -1;
        for(int x = 0; x < lower.length; ++x){
            if(c == lower[x]) rez = x;
        }
        return rez;
    }
}