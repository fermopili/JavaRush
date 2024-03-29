package com.javarush.task.task16.task1606;

import java.util.ArrayList;
import java.util.List;

/* 
join
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        PrintListThread firstThread  = new PrintListThread("firstThread");
        PrintListThread secondThread = new PrintListThread("secondThread");
        firstThread.start();
        firstThread.join();
        secondThread.start();
    }
    public static void printList(List<String> list, String threadName) {
        for (String item : list) {
            System.out.println(String.format("%s : %s", threadName, item));
        }
    }
    public static List<String> getList(int name) {
        List<String> result = new ArrayList<String>();
        if (name < 1) {
            return result;
        }
        for (int i = 0; i < name; i++) {
            result.add(String.format("String %d", (i + 1)));
        }
        return result;
    }
    public static class PrintListThread extends Thread {
        public PrintListThread(String name) {
            super(name);
        }

        public void run() {
            printList(getList(20), getName());
        }
    }
}
