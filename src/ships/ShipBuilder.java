package ships;

/**
 * Created by eagro02 on 10/17/2017.
 * A handy way to build a ship.
 */
public class ShipBuilder
{
    Ship newship;

    public static ShipBuilder create()
    {
        ShipBuilder builder = new ShipBuilder();
        builder.newship = new Ship();
        return builder;
    }

    public Ship build()
    {
        return newship;
    }

    public ShipBuilder shipClass( String name )
    {
        newship.shipClass = name;
        return this;
    }

    public ShipBuilder sizeCode( String size )
    {
        newship.sizeCode = size;
        return this;
    }

    public ShipBuilder mission( String mission )
    {
        newship.mission = mission;
        return this;
    }

    public ShipBuilder config( String config )
    {
        newship.config = config;
        return this;
    }

    public ShipBuilder passageDemand( int demand )
    {
        newship.passageDemand = demand;
        return this;
    }

    public ShipBuilder crewComfort( int comfort )
    {
        newship.crewComfort = comfort;
        return this;
    }

    public ShipBuilder hasVault()
    {
        newship.hasVault = true;
        return this;
    }

    public ShipBuilder fuel( int fuel )
    {
        newship.fuel = fuel;
        return this;
    }

    public ShipBuilder jump( int jump )
    {
        newship.jump = jump;
        return this;
    }

    public ShipBuilder maneuver( int maneuver )
    {
        newship.maneuver = maneuver;
        return this;
    }

    public ShipBuilder hold( int hold )
    {
        newship.hold = hold;
        return this;
    }

    public ShipBuilder high( int high )
    {
        newship.high = high;
        return this;
    }

    public ShipBuilder mid( int mid )
    {
        newship.mid = mid;
        return this;
    }

    public ShipBuilder low( int low )
    {
        newship.low = low;
        return this;
    }
}