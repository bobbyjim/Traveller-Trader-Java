package network;

import api.API;
import api.ApiVersionFactory;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Serves queries from peers, 11/29/2017.
 */
public class ExternalDataServer extends AbstractDataServer
{
    public ExternalDataServer( int port ) throws IOException
    {
        super( port );
        System.out.println( "External server listening on port " + port );
    }

    V0Context buildV0Context( V0Context ctx, API fac )
    {
        //
        // Add commands to the context
        //
        ctx.commands.add( fac.getCommand( "ship" ));
        ctx.commands.add( fac.getCommand( "person" ));

        return ctx;
    }
}
