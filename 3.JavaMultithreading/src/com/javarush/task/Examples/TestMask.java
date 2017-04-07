package com.javarush.task.Examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 02.04.2017.
 */
class ListPrinter {
    static void printList(List<?> list){
    Class c = list.getClass();
    for(Object n:list){
        System.out.print(n + " ");
    }
    System.out.println();
    }
}

public class TestMask{



    public static void main(String[] args) {
    ArrayList<Double>  listD =  new ArrayList<>(Arrays.asList(new Double(3.14),new Double(99.54),new Double(5d)));
    ArrayList<Integer> listI =  new ArrayList<>(Arrays.asList(new Integer(3),new Integer(99),new Integer(5)));
    ArrayList<Float>   listF =  new ArrayList<>(Arrays.asList(new Float(3.14f),new Float(99f),new Float(5f)));
    ArrayList<String>  listS = new ArrayList<>(Arrays.asList("first","second"));
    ListPrinter.printList(listD);
    ListPrinter.printList(listF);
    ListPrinter.printList(listI);
     ListPrinter.printList(listS);

    }
}