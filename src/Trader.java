import client.TraderClient;
import network.ExternalDataServer;
import network.InternalDataServer;

/**
 * Trader main program 11/29/2017.
 */
public class Trader
{
    public static void main( String[] args ) throws Exception
    {
        String playerName = "Jamison";
        int    internalPort = 2244;
        int    externalPort = 7244;

        switch( args.length )
        {
            case 3:  externalPort = Integer.parseInt( args[2] );
            case 2:  internalPort = Integer.parseInt( args[1] );
            case 1:  playerName = args[0];
            default: break;
        }

        new InternalDataServer( internalPort );
        new ExternalDataServer( externalPort );

        //
        //  Launch client using playerName
        //
        new TraderClient( playerName ).run();
    }
}
