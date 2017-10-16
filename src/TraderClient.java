import players.Playable;
import players.PlayerFactory;
import worlds.MapAccessible;
import worlds.MapFactory;

import java.util.ArrayList;

public class TraderClient
{
    private ArrayList scan( Playable player )
    {
        MapAccessible api = MapFactory.getMapEngine("worlds.TravellerMap");
        return api.getJumpMap(player.getSectorAbbreviation(), player.getHex(), player.getJumpDistance());
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
            ArrayList worlds = client.scan(player);
            player.jump(worlds);
        }
    }
}
