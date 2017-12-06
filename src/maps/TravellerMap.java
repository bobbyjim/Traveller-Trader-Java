package maps;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.util.Mapper;
import worlds.World;
import worlds.WorldBuilder;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Travellermap.com is a service provided by Joshua Bell.  It is, essentially, a REST-based
 * map engine with a rich set of operations.  This class talks to it to retrieve info
 * about the world you're currently at, as well as a list of nearby worlds.
 */
public class TravellerMap implements MapAccessible
{
    private JSONParser parser = new JSONParser();

    public HashMap<String,Object> getWorld( String sector, String hex )
    {
        String json = get("https://travellermap.com/data/" + sector + "/" + hex);
        return Mapper.decode( json );
    }

    public World[] getJumpMap(World currentWorld, String sector, String hex, int jumpnum )
    {
        String json = get( "https://travellermap.com/data/" + sector + "/" + hex + "/jump/" + jumpnum );
        HashMap<String,Object> out = Mapper.decode( json );

        ArrayList array = (ArrayList) out.get("Worlds");
        ArrayList<World> worlds = new ArrayList<>();

        int i = 0;
        for (Object o1 : array)
        {
            World world = WorldBuilder.build( (HashMap) o1 );
            int dist = world.distanceTo( currentWorld );
            if ( dist > 0 ) // exclude current world
            {
                worlds.add( world );
            }
        }

        World[] outWorlds = new World[1];
        outWorlds = worlds.toArray( outWorlds );

        return outWorlds;
    }

    private String get( String urlString )
    {
        HttpURLConnection conn = connect( urlString );
        checkConnectionIntegrity( conn );
        String output = readURLResponse( conn );
        if ( conn != null )
            conn.disconnect();
        return output;
    }

    private HttpURLConnection connect( String urlString )
    {
        try
        {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            return conn;
        }
        catch( IOException ioe )
        {
            ioe.printStackTrace();
        }
        return null;
    }

    private void checkConnectionIntegrity( HttpURLConnection conn )
    {
        try
        {
            if (conn.getResponseCode() != 200)
            {
                throw new RuntimeException("Failed: HTTP error code: "
                        + conn.getResponseCode());
            }
        }
        catch( IOException ioe )
        {
            ioe.printStackTrace();
        }
    }

    private String readURLResponse( HttpURLConnection conn )
    {
        String output = "";
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;

            while ((line = br.readLine()) != null)
            {
                output = output.concat(line);
            }
        }
        catch( IOException ioe )
        {
            ioe.printStackTrace();
        }
        return output;
    }
}
