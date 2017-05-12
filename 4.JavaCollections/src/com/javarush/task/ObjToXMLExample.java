package com.javarush.task;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;

/**
 * Created by Administrator on 12.05.2017.
 */
public class ObjToXMLExample
{
    @XmlRootElement
    public static class Cat
    {   @XmlElement(name="name")
    String name = "Murka";
        @XmlElement(name="age")
    int age = 5;
        @XmlElement(name="weight")
    int weight = 4;
    }

    public static void main(String[] args) throws JAXBException
        {
        //------------------------------

        //создание объекта для сериализации в XML
        Cat cat = new Cat ( );
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;

        //писать результат сериализации будем в Writer(StringWriter)
        StringWriter writer = new StringWriter ( );

        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context    = JAXBContext.newInstance (Cat.class);
        Marshaller  marshaller = context.createMarshaller ( );
        marshaller.setProperty (Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // сама сериализация
        marshaller.marshal (cat, writer);

        //преобразовываем в строку все записанное в StringWriter
        String result = writer.toString ( );
        System.out.println (result);
        //-----------------------------------

        }
}
