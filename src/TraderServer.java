import api.Jump;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import players.Playable;
import players.PlayerFactory;
import worlds.World;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TraderServer
{
    private static int SERVER_PORT = 2244; // "TRAV"
    //private HttpServer server;

    /*
    private String handleInput( BufferedReader reader ) throws IOException
    {
        String[] words = reader.readLine().split( " " );
        String verb = words[0];
        String path = words[1];

        String[] pathArray = path.split( "/" );
        String version  = pathArray[0];
        String stemNoun = pathArray[1];

        API api = ApiVersionFactory.getApiVersion( version );
        ApiCommand cmd = api.getCommand( verb, stemNoun );
        return cmd.handle( pathArray, reader );
    }
    */

    public static void main( String[] args ) throws Exception
    {
        InetSocketAddress host = new InetSocketAddress( SERVER_PORT );
        HttpServer server = HttpServer.create( host, 0 );
        server.createContext( "/v0/", new TestOutput() );
        server.setExecutor(null);
        server.start();
        System.out.println( "Server listening on port " + SERVER_PORT );
    }

    static class TestOutput implements HttpHandler
    {
        public void handle(HttpExchange t) throws IOException
        {
            // parse request
            URI requestedUri = t.getRequestURI();
            String path = requestedUri.getPath();
            Jump jump = splitPath( path );
            String query = requestedUri.getRawQuery();
            Map<String,Object> parameters = parseQuery(query);

            Playable player = PlayerFactory.getPlayer( jump.playerID, "WebClient" );
            TraderClient client = new TraderClient( player );
            World[] worlds = client.scan( client.player );

            String response = player.visitWorld()
                    + player.printDestinations( worlds );

            if ( jump.destination > -1 )
            {
                // we have a destination
                player.setWorld( worlds[ jump.destination ] );
                response += "\nJumping to " + player.getWorld().name + "\n";
                PlayerFactory.savePlayer( player );
            }

            t.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = t.getResponseBody();
            os.write( response.getBytes() );
            os.close();
        }

        public Jump splitPath( String path )
        {
            String[] pathArray = path.split( "/" );
            String version     = pathArray[1];
            String stemNoun    = pathArray[2];
            String playerID    = pathArray[3];
            int destination    = -1;
            if ( pathArray.length > 4 )
               destination = Integer.parseInt( pathArray[4] );
            Jump jump = new Jump();
            jump.playerID = playerID;
            jump.destination = destination;
            return jump;
        }

        public static Map<String,Object> parseQuery(String query) throws UnsupportedEncodingException {

            Map<String, Object> parameters = new HashMap<>();
            if (query != null) {
                String pairs[] = query.split("[&]");
                for (String pair : pairs) {
                    String param[] = pair.split("[=]");
                    String key = null;
                    String value = null;
                    if (param.length > 0) {
                        key = URLDecoder.decode(param[0],
                                System.getProperty("file.encoding"));
                    }

                    if (param.length > 1) {
                        value = URLDecoder.decode(param[1],
                                System.getProperty("file.encoding"));
                    }

                    if (parameters.containsKey(key)) {
                        Object obj = parameters.get(key);
                        if (obj instanceof List<?>) {
                            List<String> values = (List<String>) obj;
                            values.add(value);

                        } else if (obj instanceof String) {
                            List<String> values = new ArrayList<>();
                            values.add((String) obj);
                            values.add(value);
                            parameters.put(key, values);
                        }
                    } else {
                        parameters.put(key, value);
                    }
                }
            }
            return parameters;
        }
    }
}
