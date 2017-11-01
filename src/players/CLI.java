package players;

import trade.*;
import worlds.*;

import java.io.Console;

public class CLI extends Player implements Playable
{
   public void jump(World[] worlds)
    {
        if ( worlds == null )
        {
            System.out.println( "No data." );
            return;
        }

        printDestinations( worlds );
        selectDestination( worlds );

        System.out.println( loadShip() );
    }

    private void selectDestination( World[] worlds )
    {
        Console console = System.console();
        int selection = -1;
        while(selection == -1)
        {
            System.out.println("Enter destination # (q = quit): ");
            try
            {
                String input = console.readLine();

                if ( "q".equals(input) )
                    System.exit(0);

                selection = Integer.parseInt( input );
                if ( selection < 0 || selection >= worlds.length )
                    selection = -1;
            }
            catch( Exception e )
            {
                System.err.println( "ERROR: process does not have a console for CLI input!  Quitting.");
                System.exit(0);
            }
        }

        this.world = worlds[selection];
    }

    private void printDestinations( World[] worlds )
    {
        System.out.println( "Destinations in range:" );
        for (int i=0; i<worlds.length; i++)
        {
            String index = pad(i + "", 2);
            System.out.println(index + ": " + worlds[i].toString());
        }
    }

    private String pad( String in, int length )
    {
        while( in.length() < length )
            in = in.concat(" ");
        return in;
    }
}
