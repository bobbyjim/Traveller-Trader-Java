package api.v0;

import api.ApiCommand;
import api.Jump;
import client.TraderClient;
import org.json.simple.util.Mapper;
import players.Playable;
import players.PlayerFactory;
import worlds.World;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class V0Ship implements ApiCommand
{
    /*
     * Signature:
     *
     * PATCH /v0/ship/<playerid>[/destination]
     *
     */
    public String handle(String[] path, Map<String,Object> parameters, HashMap<String,Object> jsonMap  )
    {
        //
        //  Proof-of-Concept:
        //
        Jump jump = splitPath( path );

        Playable player = PlayerFactory.getPlayer( jump.playerID, "WebClient" );
        TraderClient client = new TraderClient( player );
        World[] worlds = client.scan( client.player );

        String response = player.youAreHere()
                + player.unloadShip();

        if ( jump.destination > -1 )
        {
            // we have a destination
            response += player.loadShip();
            player.setWorld( worlds[ jump.destination ] );
            response += "\nJumping to " + player.getWorld().name + "\n";
        }
        else
        {
            // show destination list
            response += player.printDestinations( worlds );
        }

        PlayerFactory.savePlayer( player );
        //
        //
        //

        return response;
    }

    public Jump splitPath( String[] path )
    {
        String version     = path[1];
        String stemNoun    = path[2];
        String playerID    = path[3];
        int destination    = -1;
        if ( path.length > 4 )
            destination = Integer.parseInt( path[4] );
        Jump jump = new Jump();
        jump.playerID = playerID;
        jump.destination = destination;
        return jump;
    }

}
