import players.Playable;
import players.PlayerFactory;
import worlds.MapAccessible;
import worlds.MapFactory;

import java.util.ArrayList;

public class Trader
{
    private ArrayList scan( Playable player )
    {
        MapAccessible api = MapFactory.getMapEngine("worlds.TravellerMap");
        return api.getJumpMap(player.getSectorAbbreviation(), player.getHex(), player.getJumpDistance());
    }

    public static void main( String[] args )
    {
        Playable player = PlayerFactory.createPlayer( "CLI" );
        Trader trader = new Trader();
        ArrayList worlds = trader.scan( player );
        player.showWorlds( worlds );
    }
}
