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
        String out = "Loading freight...";
        ship.getFreight().load( this );
        out += "   " + ship.getFreight().getCount() + " tons.";

        out += "Loading passengers...";
        ship.getLowPassengers().load( this );
        out += "   " + ship.getLowPassengers().getCount() + " low";
        ship.getMidPassengers().load( this );
        out += "   " + ship.getMidPassengers().getCount() + " mid";
        ship.getHighPassengers().load( this );
        out += "   " + ship.getHighPassengers().getCount() + " high";

        out += "Loading Speculative Cargo...";
        ship.setCargo( CargoBuilder.buildCargo( world ) );
        out += "   Buy price per ton: " + ship.getCargo().buyPrice ;
        return out;
    }

    public String unloadShip()
    {
        String out = "Unloading passengers...";
        ship.getHighPassengers().unload( world );
        ship.getMidPassengers().unload( world );
        ship.getLowPassengers().unload( world );
        out += "done.";

        out += "Unloading freight...";
        ship.getFreight().unload( world );
        out += "done.";

        out += "Unloading Speculative Cargo:";
        Trade trade = TradeBuilder.buildTrade( ship.getCargo(), world );
        out += "Spec Cargo sale price:   " + trade.getSalePrice();
        out += "Spec Cargo origin price: " + ship.getCargo().buyPrice;
        int net = trade.getSalePrice() - ship.getCargo().buyPrice;
        if ( net < (int)(Math.random() * 1000) ) // simulate the time value of money, Monte Carlo style.
            out += "   Will not sell cargo.";
        else
            out += "   Net profit: Cr " + net + " per ton.";

        return out;
    }

    public String visitWorld()
    {
        String out = "Welcome to " + world.name + " (" + world.uwp + "/" + world.sectorAbbreviation + " " + world.hex + ")";
        out += unloadShip();
        return out;
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
