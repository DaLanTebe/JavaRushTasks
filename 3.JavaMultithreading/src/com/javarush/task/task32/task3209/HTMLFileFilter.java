package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.Locale;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
                return f.getName().toLowerCase(Locale.ROOT).endsWith(".html")
                || f.getName().toLowerCase(Locale.ROOT).endsWith(".htm")
                || f.isDirectory();
//        return f.isDirectory() ||f.getName().toLowerCase().matches("\\.html?$");
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
