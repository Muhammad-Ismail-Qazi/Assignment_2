// A Java program for a serverSide
import java.io.*;
import java.net.*;

public class serverSide {

    // initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    // constructor with port
    public serverSide(int port)
    {
        int counter = 0;
        // starts server and waits for a connection
        try {
            server = new ServerSocket(port);

            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();

            System.out.println("Client accepted");

            while (true) {
                counter++;
                serverThread t = new serverThread(socket, counter);
                t.start();
            }
        }

        catch (IOException i) {

            System.out.println(i);
        }
    }

    public static void main(String[] args)
    {

        serverSide server = new serverSide(5000);
    }
}
