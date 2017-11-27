package client;

import maps.MapAccessible;
import maps.MapFactory;
import players.*;
import worlds.*;

public class TraderClient
{
    public Playable player;

    public TraderClient( Playable player ) { this.player = player; }
    public TraderClient( String name )
    {
        player = PlayerFactory.getPlayer( name );
    }

    public World[] scan( Playable player )
    {
        MapAccessible api = MapFactory.getMapEngine("maps.TravellerMap");
        return api.getJumpMap(player.getWorld(), player.getWorld().sectorAbbreviation, player.getWorld().hex, player.getShip().getJumpRange());
    }

    public static void main( String[] args ) throws Exception
    {
        String playerName = "Jamison";

        if ( args.length > 0 )
            playerName = args[0];

        TraderClient client = new TraderClient( playerName );

        while(true)
        {
            System.out.println( client.player.youAreHere() );
            System.out.println( client.player.unloadShip() );
            World[] worlds = client.scan( client.player );
            client.player.jump(worlds);
            PlayerFactory.savePlayer( client.player );
        }
    }
}
