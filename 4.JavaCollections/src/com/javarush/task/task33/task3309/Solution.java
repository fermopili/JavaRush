package com.javarush.task.task33.task3309;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/*
Комментарий внутри xml
*/
public class Solution
{


    public static String toXmlWithComment1(Object obj, String tagName, String comment) throws IOException, JAXBException
        {

        JAXBContext jaxbContext    = JAXBContext.newInstance (Cat.class);
        Marshaller  jaxbMarshaller = jaxbContext.createMarshaller ( );
        jaxbMarshaller.setProperty (Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter writer = new StringWriter ( );
        jaxbMarshaller.marshal (obj, writer);

        StringBuilder stringBuilder;//=new StringBuilder (writer.toString ( ));

        String xml        = writer.toString ( );
        String commentPut = "<!--" + comment + "-->";
        String tag        = "<" + tagName;

        stringBuilder = new StringBuilder (xml.replaceAll (tag, comment + "\n" + tag));
        return xml;
        }

    public static void main(String[] args) throws Exception
        {
        Cat    cat = new Cat ( );
        String s   = toXmlWithComment (cat, "namer", "commemt");
        System.out.println (s);
        }

    public static String toXmlWithComment(Object obj, String tagName, String comment) throws Exception
        {
        StringWriter writer     = new StringWriter ( );
        JAXBContext  context    = JAXBContext.newInstance (obj.getClass ( ));
        Marshaller   marshaller = context.createMarshaller ( );
        marshaller.setProperty (Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal (obj, writer);
        String out = writer.toString ( ).split ("\n")[0] + "\n";
        writer = new StringWriter ( );
        marshaller.setProperty (Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
        marshaller.marshal (obj, writer);

        ByteArrayInputStream   byteArrayInputStream = new ByteArrayInputStream (writer.toString ( ).getBytes ( ));
        DocumentBuilderFactory dbf                  = DocumentBuilderFactory.newInstance ( );
        dbf.setValidating (false);
        DocumentBuilder db       = dbf.newDocumentBuilder ( );
        Document        doc      = db.parse (byteArrayInputStream);
        Element         element  = doc.getDocumentElement ( );
        Comment         com      = null;
        NodeList        elements = element.getElementsByTagName (tagName);
        for (int i = 0; i < elements.getLength ( ); i++)
            {
                com = doc.createComment (comment);
                element.insertBefore (com, elements.item (i));
            }

        Transformer tf = TransformerFactory.newInstance ( ).newTransformer ( );
        tf.setOutputProperty (OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty (OutputKeys.INDENT, "yes");
        tf.setOutputProperty (OutputKeys.OMIT_XML_DECLARATION, "yes");
        Writer sw = new StringWriter ( );
        tf.transform (new DOMSource (doc), new StreamResult (sw));
        out += sw.toString ( );
        return out;
        }

}
