package com.javarush.task;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 26.05.2017.
 */
public class MySocket
{

    public static void main(String... args) throws IOException
        {


       //создаем   сокет
        Socket clientSocket = new Socket ( "localhost", 4444 );

        //получаем OutputStream
        OutputStream outputStream = clientSocket.getOutputStream ( );
        PrintWriter  out          = new PrintWriter ( outputStream, true );
        out.println ( "Kiss my shiny metal ass!" );
        out.flush ( );

        //читаем ответ
        InputStream    inputStream = clientSocket.getInputStream ( );
        BufferedReader in          = new BufferedReader ( new InputStreamReader ( inputStream ) );
        String         answer      = in.readLine ( );
        System.out.println (">>>>>>>>>>   "+answer);

        //=============================================================================
        //создаем объект сервер-сокет
        ServerSocket serverSocket = new ServerSocket(4444); //порт

//в цикле обрабатываем входящие соединения.
        while (true)
            {
                //метод accept ждет, пока кто-то не подключится.
                Socket socket = serverSocket.accept();

                //читаем сообщение
                InputStream inputStream1 = socket.getInputStream();
                BufferedReader in1 = new BufferedReader(new InputStreamReader(inputStream1));
                String message = in1.readLine();

                //придумываем ответ – просто разворачиваем строку задом наперед
                String reverseMessage = new StringBuilder(message).reverse().toString();

                //отправляем ответ
                OutputStream outputStream1 = socket.getOutputStream();
                PrintWriter out1 = new PrintWriter(outputStream1, true);
                out1.println(reverseMessage);
                out1.flush();
            }

        }
}
