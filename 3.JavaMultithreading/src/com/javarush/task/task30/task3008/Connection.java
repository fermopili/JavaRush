package com.javarush.task.task30.task3008;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Administrator on 13.04.2017.
 */
public class Connection implements Closeable
{

    final private Socket             socket;
    final private ObjectOutputStream out;
    final private ObjectInputStream  in;

    public Connection(Socket socket) throws IOException
        {
        this.socket = socket;
        this.out = new ObjectOutputStream (socket.getOutputStream ( ));
        this.in = new ObjectInputStream (socket.getInputStream ( ));
        }

    public void send(Message message) throws IOException
        {
        synchronized (out)
            {
                out.writeObject (message);
            }
        }

    public Message receive() throws IOException, ClassNotFoundException
        {
        Message message = null;
        synchronized (in)
            {
                message = (Message) in.readObject ( );
            }
        return message;
        }

    public SocketAddress getRemoteSocketAddress()
        {
        return socket.getRemoteSocketAddress ( );
        }

    @Override
    public void close() throws IOException
        {
        in.close ( );
        out.close ( );
        socket.close ( );
        }
}
