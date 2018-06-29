package com.example.sh.morningtext.javaText;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.InflaterInputStream;

public class IOText {

    private static FileWriter fileWriter;
    private static FileReader fileReader;
    private static FileWriter fileWriter1;
    static int c ;
    public static void main(String[] args) {
//        fileCopy();
//        fileinput();
        buffer();
    }

    private static void buffer() {
        try {
            FileInputStream f1 = new FileInputStream("F:\\Android\\io\\writer.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(f1);
            f1.read();
            while ((c = f1.read()) != -1){
                System.out.print(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }


    }

    private static void fileinput() {
        try {
            fileReader = new FileReader("F:\\Android\\io\\writer.txt");
            fileWriter1 = new FileWriter("F:\\Android\\io\\writer2.txt");

            while ((c =fileReader.read()) != -1){
                System.out.print(c);
                fileWriter1.write(c);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
                fileWriter1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static void fileCopy() {

//        FileReader fileReader = new FileReader("")
        int c = 0;
        try {
            fileWriter = new FileWriter("F:\\Android\\io\\writer.txt");
            fileWriter.write("123123123123123把酒倒满来他个不醉不休");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileWriter != null){
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
