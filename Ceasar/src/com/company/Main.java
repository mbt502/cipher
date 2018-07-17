package com.company;
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("key.txt"));
        String key = br.readLine();
        br.close();
        int k = Integer.parseInt(key);
        System.out.println("1: Зашифровать текст");
        System.out.println("2: Расшифровать текст");
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        StringBuilder output = new StringBuilder();
        if(r == 1) {
            FileInputStream fstream = new FileInputStream("text.txt");
            BufferedReader bf = new BufferedReader(new InputStreamReader(fstream));
            File file = new File("crypto_text.txt");
            PrintWriter pw = new PrintWriter(file);
            String text;
            while((text = bf.readLine()) != null) {
                char[] chars = text.toCharArray();
                for (int i = 0; text.length() > i; i++) {
                    chars[i] = (char) (chars[i] + k);
                    output.append(chars[i]);
                }
                System.out.print("Зашифрованный текст:" + output.toString());
            }
            pw.print(output.toString());
            pw.close();
            bf.close();
        }
        else if(r == 2){
            BufferedReader bf = new BufferedReader(new FileReader("crypto_text.txt"));
            String text = bf.readLine();
                bf.close();
                char[] chars = text.toCharArray();
                for (int i = 0; text.length() > i; i++) {
                    chars[i] = (char) (chars[i] - k);
                    output.append(chars[i]);
                }
                System.out.println("Расшифрованный текст: " + output.toString());
                }
        else{
            System.out.println("Error");
        }
    }
}