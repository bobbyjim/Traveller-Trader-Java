package players;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;

public class CLI extends Player implements Playable
{
    public void jump(ArrayList worlds)
    {
        Console console = System.console();

        if ( worlds == null )
        {
            System.out.println( "No data." );
            return;
        }

        int i = 1;
        String[] hexArray = new String[ worlds.size()+1 ];

        for (Object o1 : worlds)
        {
            HashMap h1 = (HashMap) o1;
            String hex = h1.get( "Hex" ).toString();
            hexArray[i] = hex;
            String index = pad(i + "", 2);
            String sec = h1.get("SectorAbbreviation").toString();
            String bases = pad(h1.get("Bases").toString(), 2);
            String name = pad(h1.get("Name").toString(), 15);
            String uwp = h1.get("UWP").toString();
            String rem = h1.get("Remarks").toString();
            //String dist  = h1.get( "Distance" ).toString();
            System.out.println(index + ": " + sec + " " + hex + "  " + name + " " + uwp + " " + bases + " " + rem);
            i++;
        }

        int selection = 0;
        while(selection == 0)
        {
            System.out.println("Enter destination #: ");
            try
            {
                String input = console.readLine();
                selection = Integer.parseInt( input );
                if ( selection < 0 || selection >= hexArray.length )
                    selection = 0;
            }
            catch( Exception e )
            {
                System.err.println( "ERROR: process does not have a console for CLI input!  Quitting.");
                System.exit(0);
            }
        }

        String selectedHex = hexArray[selection];
        this.setHex( selectedHex );
    }

    private String pad( String in, int length )
    {
        while( in.length() < length )
            in = in.concat(" ");
        return in;
    }
}
