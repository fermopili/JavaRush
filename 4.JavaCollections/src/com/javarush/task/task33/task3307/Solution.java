package com.javarush.task.task33.task3307;

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Десериализация XML объекта
*/
public class Solution
{
    public static void main(String[] args) throws IOException, JAXBException
        {
        String xmlData = "<cat><name>Murka</name><age>5</age><weight>4</weight></cat>";
        Cat    cat     = convertFromXmlToNormal (xmlData, Cat.class);
        System.out.println (cat);
        }

    public static <T> T convertFromXmlToNormal(String xmlData, Class<T> clazz) throws IOException, JAXBException
        {
        InputStream stream = new ByteArrayInputStream(xmlData.getBytes(StandardCharsets.UTF_8));
        JAXBContext  jaxbContex = JAXBContext .newInstance (clazz);
        Unmarshaller jaxbUnmarshaller = jaxbContex.createUnmarshaller();
        return  (T )jaxbUnmarshaller.unmarshal(stream);
        }

    @XmlType(name = "cat")
    @XmlRootElement
    public static class Cat
    {
        public String name;
        public int    age;
        public int    weight;

        @Override
        public String toString()
            {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", weight=" + weight +
                    '}';
            }
    }
}
