package com.javarush.task.task15.task1504;

import java.util.LinkedList;
import java.util.List;

/* 
ООП - книги
*/

public class Solution
{
    public static void main(String[] args)
        {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
        }

    public static class MarkTwainBook extends Book
    {
        private String title;
       // private String name;

        public MarkTwainBook(String title)
            {
            super("Mark Twain");
            this.title = title;
           // this.name = "Mark Twain";
            }

        @Override
        public MarkTwainBook getBook()
            {
            return this;
            }

        @Override
        public String getTitle()
            {
            return title;
            }
    }

    public static class AgathaChristieBook extends Book
    {
        private String title;
      //  private String name;
        public AgathaChristieBook(String title)
            {
            super("Agatha Christie");
            this.title = title;
        //    this.name ="Agatha Christie";
            }

        @Override
        public AgathaChristieBook getBook()
            {
            return this;
            }

        @Override
        public String getTitle()
            {
            return title;
            }
    }

    abstract static class Book
    {
        private String author;

        public Book(String author)
            {
            this.author = author;
            }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType()
            {
            String agathaChristieOutput = author + ", " + getBook().getTitle() + " is a detective";
            String markTwainOutput      = getBook().getTitle() + " book was written by " + author;

            String output = "output";
            //Add your code here
            if (this instanceof  AgathaChristieBook)
                return agathaChristieOutput;
            if (this instanceof  MarkTwainBook)
                return markTwainOutput;
            return output;
            }

        public String toString()
            {
            return getOutputByBookType();
            }
    }
}
