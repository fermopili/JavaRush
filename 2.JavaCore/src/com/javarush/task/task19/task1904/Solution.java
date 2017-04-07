package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution
{
    public static void main(String[] args)
        {

        }
    public static class PersonScannerAdapter implements PersonScanner
    {
        private final Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner)
            {
            this.fileScanner = fileScanner;
            }
        @Override
        public Person read() throws IOException
            {
            String tmp=fileScanner.next ();
            String[] tmpArray= tmp.split (" ");
            String firstName  = tmpArray[1];
            String middleName = tmpArray[2];
            String lastName   = tmpArray[0];
            Date   birthDate  = new Date(Integer.parseInt (tmpArray[5]),Integer.parseInt (tmpArray[4]),Integer.parseInt (tmpArray[3]));
            return new Person (firstName, middleName, lastName, birthDate);
            }
        @Override
        public void close() throws IOException
            {
            fileScanner.close ( );
            }
    }
}
