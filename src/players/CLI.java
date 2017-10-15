package players;

import java.util.ArrayList;
import java.util.HashMap;

public class CLI extends Player implements Playable
{
    public void showWorlds(ArrayList worlds)
    {
        if ( worlds == null )
        {
            System.out.println( "No data." );
            return;
        }

        int i = 1;
        for (Object o1 : worlds)
        {
            HashMap h1 = (HashMap) o1;
            String index = pad(i + "", 2);
            String sec = h1.get("SectorAbbreviation").toString();
            String bases = pad(h1.get("Bases").toString(), 2);
            String name = pad(h1.get("Name").toString(), 15);
            String uwp = h1.get("UWP").toString();
            String rem = h1.get("Remarks").toString();
            //String dist  = h1.get( "Distance" ).toString();
            System.out.println(index + ": " + sec + " " + getHex() + "  " + name + " " + uwp + " " + bases + " " + rem);
            i++;
        }
    }

    private String pad( String in, int length )
    {
        while( in.length() < length )
            in = in.concat(" ");
        return in;
    }
}
