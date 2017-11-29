package network;

import api.API;
import api.ApiVersionFactory;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Server for client access, 11/29/2017.
 */
public class InternalDataServer extends AbstractDataServer
{
    public InternalDataServer( int port ) throws IOException
    {
        super( port );
        System.out.println( "Internal server listening on port " + port );
    }

    V0Context buildV0Context( V0Context ctx, API fac )
    {
        //
        // Add commands to the context
        //
        ctx.commands.add( fac.getCommand( "ship" ));
        ctx.commands.add( fac.getCommand( "person" ));
        ctx.commands.add( fac.getCommand( "jump" ));

        return ctx;
    }
}
