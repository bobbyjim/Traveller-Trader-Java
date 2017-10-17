package players;

import worlds.World;

import java.io.Console;

public class CLI extends Player implements Playable
{
    public void visitWorld()
    {
        System.out.println( "Welcome to " + world.name + " (" + world.hex + "/" + world.sectorAbbreviation + ")" );

        System.out.print( "Unloading passengers..." );
        ship.getHighPassengers().unload( world );
        ship.getMidPassengers().unload( world );
        ship.getLowPassengers().unload( world );
        System.out.println( "done.");

        System.out.print( "Unloading freight..." );
        ship.getFreight().unload( world );
        System.out.println( "done." );

        System.out.println( "Loading freight..." );
        ship.getFreight().load( this );
        System.out.println( "   " + ship.getFreight().getCount() + " tons." );

        System.out.println( "Loading passengers..." );
        ship.getLowPassengers().load( this );
        System.out.println( "   " + ship.getLowPassengers().getCount() + " low" );
        ship.getMidPassengers().load( this );
        System.out.println( "   " + ship.getMidPassengers().getCount() + " mid" );
        ship.getHighPassengers().load( this );
        System.out.println( "   " + ship.getHighPassengers().getCount() + " high" );

        System.out.println( "\nYour ship is equipped with Jump-" + ship.getJumpRange() + "\n" );
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

        this.world = worlds[selection];
    }

    private String pad( String in, int length )
    {
        while( in.length() < length )
            in = in.concat(" ");
        return in;
    }
}
