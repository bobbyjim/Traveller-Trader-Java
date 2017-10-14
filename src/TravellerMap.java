import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.script.*;

public class TravellerMap
{
    public String getWorldByHex( String sector, String hex )
    {
        return get( "https://travellermap.com/data/" + sector + "/" + hex );
    }

    public String getJumpMapByHex( String sector, String hex, int jumpnum )
    {
        return get( "https://travellermap.com/data/" + sector + "/" + hex + "/jump/" + jumpnum );
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
            HttpURLConnection conn;
            conn = (HttpURLConnection) url.openConnection();
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
                output += line;
            }
        }
        catch( IOException ioe )
        {
            ioe.printStackTrace();
        }
        return output;
    }

    public static String pad( String in, int length )
    {
        while( in.length() < length )
            in += " ";
        return in;
    }

    public static void main( String[] args ) throws Exception
    {
        String sector = "spin";
        String hex = "1910";
        int jumpno = 2;

        switch( args.length )
        {
            case 3: jumpno = Integer.parseInt( args[2] );
            case 2: sector = args[1];
            case 1: hex    = args[0];
            default: break;
        }

        TravellerMap api = new TravellerMap();
        String json = api.getJumpMapByHex( sector, hex, jumpno );

        JSONParser parser = new JSONParser();
        HashMap o = (HashMap) parser.parse( json );
        ArrayList a = (ArrayList) o.get( "Worlds" );
        Object[] list = a.toArray();

        int i=1;
        for ( Object o1 : list )
        {
            HashMap h1 = (HashMap) o1;
            String index = pad( i + "", 2 );
            String sec = h1.get( "SectorAbbreviation" ).toString();
            String bases = pad( h1.get( "Bases" ).toString(), 2 );
            String name  = pad( h1.get( "Name" ).toString(), 15 );
            String uwp   = h1.get( "UWP" ).toString();
            String rem   = h1.get( "Remarks" ).toString();
            //String dist  = h1.get( "Distance" ).toString();

            System.out.println( index + ": " + sec + " " + hex + "  " + name + " " + uwp + " " + bases + " " + rem );

            i++;
        }

/*        ScriptEngine engine = new ScriptEngineManager().getEngineByName( "JS" );
        Object o = engine.eval( String.format( "JSON.parse('%s')", json ));
        Map<String,Object> map = (Map<String,Object>) o;
        System.out.println( Arrays.toString( map.entrySet().toArray()));*/

    }
}
