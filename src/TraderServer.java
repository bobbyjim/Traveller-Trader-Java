import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TraderServer
{
    private ServerSocket serverSocket;
    private int SERVER_PORT = 2244; // "TRAV"

    private void startServer()
    {
        try
        {
            serverSocket = new ServerSocket(SERVER_PORT);
        }
        catch( IOException ioe )
        {
            System.err.println( "ERROR starting server: " + ioe.getMessage() );
            System.exit(0);
        }
    }

    private void listen()
    {
        Socket client;
        try
        {
            if ( (client = serverSocket.accept()) != null )
            {
                handleInput( new InputStreamReader( client.getInputStream() ) );
                handleOutput( new OutputStreamWriter( client.getOutputStream() ) );
                client.close();
            }
        }
        catch( IOException ioe )
        {
            System.err.println( "ERROR listening on server socket: " + ioe.getMessage() );
        }
    }

    private void handleInput( InputStreamReader reader ) throws IOException
    {

    }

    private void handleOutput( OutputStreamWriter writer ) throws IOException
    {
        writer.write(
                "HTTP/1.0 200\n"
                        + "\n"
                        + "TraderServer"
        );

        writer.flush();
    }

    public static void main( String[] args ) throws Exception
    {
        TraderServer server = new TraderServer();
        server.startServer();
        while (true) server.listen();
    }
}
