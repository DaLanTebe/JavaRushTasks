package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import java.util.Arrays;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes types){
        if (types == null) throw  new IllegalArgumentException("Неизвестный тип картинки");
        if (types.equals(ImageTypes.JPG)){
            return new JpgReader();
        } else if (types.equals(ImageTypes.BMP)) {
            return new BmpReader();
        } else if (types.equals(ImageTypes.PNG)) {
            return new PngReader();
        }
        throw  new IllegalArgumentException("Неизвестный тип картинки");
    }
}
