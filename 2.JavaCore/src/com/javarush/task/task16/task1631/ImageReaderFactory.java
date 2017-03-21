package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by Administrator on 20.03.2017.
 */
public class ImageReaderFactory
{
    public static ImageReader getImageReader(ImageTypes type)
        {

        if (ImageTypes.BMP==type)
            return new BmpReader();
        if (ImageTypes.JPG==type)
            return new JpgReader();
        if (ImageTypes.PNG==type)
            return new PngReader();
        throw new IllegalArgumentException("Неизвестный тип картинки");
        }
}
