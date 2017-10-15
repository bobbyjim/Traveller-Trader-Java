package worlds;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TravellerMap implements MapAccessible
{
    private JSONParser parser = new JSONParser();

    public HashMap<String,Object> getWorld( String sector, String hex )
    {
        String json = get("https://travellermap.com/data/" + sector + "/" + hex);
        HashMap<String,Object> out;

        try
        {
            out = (HashMap<String,Object>) parser.parse(json);
        }
        catch( ParseException pe )
        {
            out = new HashMap<>();
            out.put( "exception", pe.getMessage() );
        }
        return out;
    }

    public ArrayList getJumpMap( String sector, String hex, int jumpnum )
    {
        String json = get( "https://travellermap.com/data/" + sector + "/" + hex + "/jump/" + jumpnum );
        ArrayList array = null;

        try
        {
            HashMap<String,Object> o = (HashMap<String,Object>) parser.parse(json);
            array = (ArrayList) o.get("Worlds");
        }
        catch( ParseException pe )
        {
            // what?  print stack trace??
        }

        return array;
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
