package ru.innopolis.homework_7;

import javax.tools.*;
import java.io.IOException;
import java.util.Arrays;

public class MyJavaCompiler {
    public static void compiler(String path){
        try {
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
            Iterable<? extends JavaFileObject> compilationUnits = fileManager
                    .getJavaFileObjectsFromStrings(Arrays.asList(path));
            JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null,
                    null, compilationUnits);
            boolean success = task.call();
            fileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
