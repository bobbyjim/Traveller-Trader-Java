package players;

import ships.*;
import trade.CargoBuilder;
import trade.Trade;
import trade.TradeBuilder;
import worlds.*;

import java.util.HashMap;

public class Player implements Playable
{
    public String playerID = "Jameson";

    HashMap<String,Integer> skills = new HashMap<>();
    public World world;
    public Interstellar ship = ShipFactory.createShip( "Far Trader" );
    public double mcr = 1.0;

    public Player()
    {
        world = WorldBuilder.BuildRegina();

        skills.put( "admin", 1 );
        skills.put( "liaison", 1 );
        skills.put( "steward", 1 );
        skills.put( "streetwise", 1 );
    }

    public String getID() { return playerID; }
    public void setID( String id ) { this.playerID = id; }
    public World getWorld() { return world; }
    public Interstellar getShip() { return ship; }

    public String loadShip()
    {
        String out = "\nLoading freight...";
        ship.getFreight().load( this );
        out += "   " + ship.getFreight().getCount() + " tons.";

        out += "\nLoading passengers...";
        ship.getLowPassengers().load( this );
        out += "\n   " + ship.getLowPassengers().getCount() + " low";
        ship.getMidPassengers().load( this );
        out += "\n   " + ship.getMidPassengers().getCount() + " mid";
        ship.getHighPassengers().load( this );
        out += "\n   " + ship.getHighPassengers().getCount() + " high";

        out += "\nLoading Speculative Cargo...";
        ship.setCargo( CargoBuilder.buildCargo( world ) );
        out += "\n   Buy price per ton: " + ship.getCargo().buyPrice ;
        return out;
    }

    public String unloadShip()
    {
        String out = "\nUnloading passengers...";
        ship.getHighPassengers().unload( world );
        ship.getMidPassengers().unload( world );
        ship.getLowPassengers().unload( world );
        out += "done.";

        out += "\nUnloading freight...";
        ship.getFreight().unload( world );
        out += "done.";

        out += "\nUnloading Speculative Cargo:";
        Trade trade = TradeBuilder.buildTrade( ship.getCargo(), world );
        out += "\nSpec Cargo sale price:   " + trade.getSalePrice();
        out += "\nSpec Cargo origin price: " + ship.getCargo().buyPrice;
        int net = trade.getSalePrice() - ship.getCargo().buyPrice;
        if ( net < (int)(Math.random() * 1000) ) // simulate the time value of money, Monte Carlo style.
            out += "\n   Will not sell cargo.";
        else
            out += "\n   Net profit: Cr " + net + " per ton.";

        return out;
    }

    public String visitWorld()
    {
        String out = "\nWelcome to " + world.name + " (" + world.uwp + "/" + world.sectorAbbreviation + " " + world.hex + ")";
        out += unloadShip();
        return out;
    }

    public String printDestinations( World[] worlds )
    {
        String out = "\nDestinations in range:";
        for (int i=0; i<worlds.length; i++)
        {
            String index = pad(i + "", 2);
            out += "\n " + index + ": " + worlds[i].toString();
        }
        return out;
    }

    private String pad( String in, int length )
    {
        while( in.length() < length )
            in = in.concat(" ");
        return in;
    }

    public void jump(World[] worlds)
    {

    }

    public int getSkillLevel( String skill )
    {
        if ( skills.containsKey( skill.toLowerCase() ) )
            return skills.get( skill.toLowerCase() );
        else
            return 0; // default
    }
}
