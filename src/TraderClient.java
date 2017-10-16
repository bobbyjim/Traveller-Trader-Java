import players.Playable;
import players.PlayerFactory;
import worlds.MapAccessible;
import worlds.MapFactory;
import worlds.World;

import java.util.ArrayList;

public class TraderClient
{
    private World[] scan( Playable player )
    {
        MapAccessible api = MapFactory.getMapEngine("worlds.TravellerMap");
        return api.getJumpMap(player.getCurrentWorld().sectorAbbreviation, player.getCurrentWorld().hex, player.getJumpDistance());
    }

    public static void main( String[] args ) throws Exception
    {
        String playerType = "CLI";
        if ( args.length > 0 )
            playerType = args[0];

        Playable player = PlayerFactory.createPlayer( playerType );
        TraderClient client = new TraderClient();

        while(true)
        {
            player.visitWorld();
            World[] worlds = client.scan(player);
            player.jump(worlds);
        }
    }
}
