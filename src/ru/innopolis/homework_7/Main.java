package ru.innopolis.homework_7;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        //System.out.println("Helloy");

        WriteClassInFile.writeInFile("d://MyClass.java");

        MyJavaCompiler.compiler("d://MyClass.java");

        ClassLoader parentLoader = MyClass.class.getClassLoader();
        MyClassLoader myClassLoader = new MyClassLoader(parentLoader);
        Class myClass = myClassLoader.loadClass("ru.innopolis.homework_7.MyClass");
        myClass.getMethod("doWork").invoke(myClass.newInstance(),null);
    }
}
