package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void readFile(int shift){
        try{
            File f = new File("C:\\Dev\\SSe 2022 Classes\\Cryptography\\plaintext.txt");
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String plaintext = sc.nextLine();
                System.out.println(plaintext);

                shift %= 26;

                StringBuilder result = new StringBuilder();
                for(char ch: plaintext.toCharArray()){
                    int originalAlphabetPos = ch - 'A';
                    int newAlphabetPos = (originalAlphabetPos + shift)%26;
                    char newCharacter = (char) ('A' + newAlphabetPos);
                    result.append(newCharacter);
                    System.out.println(result);
                }

                FileOutputStream fs = new FileOutputStream("C:\\Dev\\SSe 2022 Classes\\Cryptography\\shifted.txt");
                byte[] resultToBytes = result.toString().getBytes();
                fs.write(resultToBytes);
                fs.close();
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Path doesn't exist");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readFile(3);
    }
}
