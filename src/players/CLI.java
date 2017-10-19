package players;

import trade.*;
import worlds.*;

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

        System.out.println( "Unloading Speculative Cargo:");
        Trade trade = TradeBuilder.buildTrade( ship.getCargo(), world );
        System.out.println( "   Sale price per ton: Cr" + trade.getSalePrice() );
        int net = trade.getSalePrice() - ship.getCargo().buyPrice;
        System.out.println( "     net per ton: Cr" + net );

        System.out.println( "\nYour ship is equipped with Jump-" + ship.getJumpRange() + "\n" );
    }

    public void jump(World[] worlds)
    {
        if ( worlds == null )
        {
            System.out.println( "No data." );
            return;
        }

        printDestinations( worlds );
        selectDestination( worlds );

        loadShip();
    }

    private void loadShip()
    {
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

        System.out.println( "Loading Speculative Cargo..." );
        ship.setCargo( CargoBuilder.buildCargo( world ) );
        System.out.println( "   Buy price per ton: " + ship.getCargo().buyPrice );
    }

    private void selectDestination( World[] worlds )
    {
        Console console = System.console();
        int selection = -1;
        while(selection == -1)
        {
            System.out.println("Enter destination #: ");
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
