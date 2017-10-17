import maps.MapAccessible;
import maps.MapFactory;
import players.*;
import worlds.*;

public class TraderClient
{
    private World[] scan( Playable player )
    {
        MapAccessible api = MapFactory.getMapEngine("maps.TravellerMap");
        return api.getJumpMap(player.getWorld().sectorAbbreviation, player.getWorld().hex, player.getShip().getJumpRange());
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
