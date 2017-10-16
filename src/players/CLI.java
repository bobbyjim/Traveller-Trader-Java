package players;

import worlds.World;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;

public class CLI extends Player implements Playable
{
    public void visitWorld()
    {
        System.out.println( "Welcome to " + currentWorld.name + " (" + currentWorld.hex + "/" + currentWorld.sectorAbbreviation + ")" );
        System.out.println( "Your ship is equipped with Jump-" + this.getJumpDistance() );
        System.out.println();
    }

    public void jump(World[] worlds)
    {
        Console console = System.console();

        if ( worlds == null )
        {
            System.out.println( "No data." );
            return;
        }

        System.out.println( "Destinations in range:" );
        for (int i=0; i<worlds.length; i++)
        {
            String index = pad(i + "", 2);
            System.out.println(index + ": " + worlds[i].toString());
        }

        int selection = 0;
        while(selection == 0)
        {
            System.out.println("Enter destination #: ");
            try
            {
                String input = console.readLine();
                selection = Integer.parseInt( input );
                if ( selection < 0 || selection >= worlds.length )
                    selection = 0;
            }
            catch( Exception e )
            {
                System.err.println( "ERROR: process does not have a console for CLI input!  Quitting.");
                System.exit(0);
            }
        }

        this.currentWorld = worlds[selection];
    }

    private String pad( String in, int length )
    {
        while( in.length() < length )
            in = in.concat(" ");
        return in;
    }
}
