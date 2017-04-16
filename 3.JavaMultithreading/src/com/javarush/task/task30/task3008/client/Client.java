package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Administrator on 15.04.2017.
 */
public class Client
{
    protected Connection connection;
    volatile private boolean clientConnected = false;

    protected String getServerAddress()
        {
        ConsoleHelper.writeMessage ("Input server address ");
        return ConsoleHelper.readString ( );
        }

    protected int getServerPort()
        {
        ConsoleHelper.writeMessage ("Input server port ");
        return ConsoleHelper.readInt ( );
        }

    protected String getUserName()
        {
        ConsoleHelper.writeMessage ("Input user name ");
        return ConsoleHelper.readString ( );
        }

    protected boolean shouldSendTextFromConsole()
        {
        return true;
        }

    protected void sendTextMessage(String message)
        {
        try
            {
                connection.send (new Message (MessageType.TEXT, message));
            }
        catch (IOException e)
            {
                clientConnected = false;
            }
        }

    protected SocketThread getSocketThread()
        {
        return new SocketThread ( );
        }

    public void run()
        {
        SocketThread socketThread = getSocketThread ( );
        socketThread.setDaemon (true);
        socketThread.start ( );
        synchronized (this)
            {
                try
                    {
                        this.wait ( );
                    }
                catch (InterruptedException e)
                    {
                        ConsoleHelper.writeMessage ("Connection was interrupted. " + e.getMessage ( ));
                        System.exit (1);
                    }
            }
        if (clientConnected)
            {
                ConsoleHelper.writeMessage ("Connection is true. To exit input command ‘exit’.");
            }
        else
            {
                ConsoleHelper.writeMessage ("Error on work time client.");
            }
        while (clientConnected)
            {
                String text = ConsoleHelper.readString ( );
                if (text.equals ("exit"))
                    {
                        return;
                    }
                if (shouldSendTextFromConsole ( ))
                    {
                        sendTextMessage (text);
                    }
            }
        }

    public class SocketThread extends Thread
    {
        protected void processIncomingMessage(String message)
            {
            ConsoleHelper.writeMessage (message);
            }

        protected void informAboutAddingNewUser(String userName)
            {
            ConsoleHelper.writeMessage (userName + " added to chat");
            }

        protected void informAboutDeletingNewUser(String userName)
            {
            ConsoleHelper.writeMessage (userName + " leave the chat");
            }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
            {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this)
                {
                    Client.this.notify ( );
                }
            }

        protected void clientHandshake() throws IOException, ClassNotFoundException
            {
            Message message;
            while (true)
                {
                    message = connection.receive ( );
                    if (message.getType ( ) == MessageType.NAME_REQUEST)
                        {
                            connection.send (new Message (MessageType.USER_NAME, getUserName ( )));
                        }
                    else if (message.getType ( ) == MessageType.NAME_ACCEPTED)
                        {
                            notifyConnectionStatusChanged (true);
                            return;
                        }
                    else
                        throw new IOException ("Unexpected MessageType");
                }
            }

        protected void clientMainLoop() throws IOException, ClassNotFoundException
            {
            Message message;
            while (!Thread.currentThread ( ).interrupted ( ))
                {
                    message = connection.receive ( );
                    MessageType messageType = message.getType ( );
                    if (messageType == MessageType.TEXT)
                        processIncomingMessage (message.getData ( ));
                    else if (messageType == MessageType.USER_REMOVED)
                        informAboutDeletingNewUser (message.getData ( ));
                    else if (messageType == MessageType.USER_ADDED)
                        informAboutAddingNewUser (message.getData ( ));
                    else
                        throw new IOException ("Unexpected MessageType");
                }
            }
        @Override
        public void run()
            {
            String serverAddress = getServerAddress ( );
            int    serverPort    = getServerPort ( );
            try
                {
                    Socket socket = new Socket (serverAddress, serverPort);
                    connection = new Connection (socket);
                    clientHandshake ( );
                    clientMainLoop ( );
                }
            catch (IOException | ClassNotFoundException e)
                {
                    //    e.printStackTrace ( );
                    ConsoleHelper.writeMessage ("Connection was interrupted. " + e.getMessage ( ));
                    notifyConnectionStatusChanged (false);
                }
            }
    }
    public static void main(String[] args)
        {
        Client client = new Client ( );
        client.run ( );
        }

}
