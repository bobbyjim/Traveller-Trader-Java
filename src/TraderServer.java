import api.API;
import api.ApiCommand;
import api.ApiVersionFactory;
import com.sun.net.httpserver.*;
import org.json.simple.util.Mapper;

import java.io.*;
import java.net.*;
import java.util.*;

public class TraderServer
{
    private static int SERVER_PORT = 2244; // "TRAV"

    public static void main( String[] args ) throws Exception
    {
        InetSocketAddress host = new InetSocketAddress( SERVER_PORT );
        HttpServer server = HttpServer.create( host, 0 );
        server.createContext( "/v0/", new ApiContext() );
        server.setExecutor(null);
        server.start();
        System.out.println( "Server listening on port " + SERVER_PORT );
    }

    static class ApiContext implements HttpHandler
    {
        public void handle(HttpExchange t) throws IOException
        {
            URI requestedUri = t.getRequestURI();
            // get parameters, if any
            String query = requestedUri.getRawQuery();
            Map<String,Object> parameters = parseQuery(query);

            // get stem noun
            String path = requestedUri.getPath();
            String[] pathArray = path.split( "/" );
            String version     = pathArray[1];
            String stemNoun    = pathArray[2];

            // get sub-handler based on stem noun
            API api = ApiVersionFactory.getApiVersion( version );
            ApiCommand cmd = api.getCommand( stemNoun );

            // read body, if any
            BufferedReader br = new BufferedReader( new InputStreamReader( t.getRequestBody() ) );
            HashMap<String,Object> jsonMap = Mapper.decode( br );
            if ( jsonMap.containsKey( "Exception" ) ) // nothing there -- throw on floor.
            {
                jsonMap = null;
            }

            // handle request
            String response =  cmd.handle( pathArray, parameters, jsonMap );

            t.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = t.getResponseBody();
            os.write( response.getBytes() );
            os.close();
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
