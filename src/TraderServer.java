import api.API;
import api.ApiCommand;
import api.ApiVersionFactory;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
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
        server.createContext( "/", new TestOutput() );
        server.setExecutor(null);
        server.start();
    }

    static class TestOutput implements HttpHandler
    {
        public void handle(HttpExchange t) throws IOException
        {
            // parse request
/*            Map<String, Object> parameters = new HashMap<String, Object>();
            URI requestedUri = he.getRequestURI();
            String query = requestedUri.getRawQuery();
            parseQuery(query, parameters);*/

            String response = "Testing";
            t.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = t.getResponseBody();
            os.write( response.getBytes() );
            os.close();
        }

        public static void parseQuery(String query, Map<String,
                        Object> parameters) throws UnsupportedEncodingException {

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
        }
    }
}
