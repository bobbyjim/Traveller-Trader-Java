import api.API;
import api.ApiCommand;
import api.ApiVersionFactory;
import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
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
                String result = handleInput( new BufferedReader( new InputStreamReader( client.getInputStream())));
                handleOutput( new OutputStreamWriter( client.getOutputStream() ), result );
                client.close();
            }
        }
        catch( IOException ioe )
        {
            System.err.println( "ERROR listening on server socket: " + ioe.getMessage() );
        }
    }

    private String handleInput( BufferedReader reader ) throws IOException
    {
        String[] words = reader.readLine().split( " " );
        String verb = words[0];
        String path = words[1];

        String[] chunks = path.split( "/" );
        String version = chunks[0];
        String stemNoun = chunks[1];

        API api = ApiVersionFactory.getApiVersion( version );
        ApiCommand cmd = api.getCommand( verb, stemNoun );
        return cmd.handle( chunks );
    }

    private void handleOutput( OutputStreamWriter writer, String result ) throws IOException
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
