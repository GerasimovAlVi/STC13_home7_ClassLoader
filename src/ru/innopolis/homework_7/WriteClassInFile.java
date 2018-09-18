package ru.innopolis.homework_7;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteClassInFile {
    public static void writeInFile(String fileName){
        Scanner scanner = new Scanner(System.in);
        String string = "";
        while(true){
            String str =  scanner.nextLine();
            string += str;
            if(str.equals("")) {
                break;
            }
        }
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            byte[] buffer = ("package ru.innopolis.homework_7;" + "\r\n" + "public class MyClass {" + "\r\n" +
                    "\tpublic void doWork(){" + "\r\n" + "\t\t" +
                    string+ "\r\n" + "\t}"+ "\r\n" +"}").getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
