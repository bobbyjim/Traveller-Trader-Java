package trade;

import players.Playable;
import ships.Interstellar;
import worlds.World;

public class Freight implements Shippable
{
    public int tons = 0;

    public int getCount() { return tons; }

    private int flux()
    {
        int a = (int)(Math.random() * 6);
        int b = (int)(Math.random() * 6);
        return a - b;
    }

    public int pricing( Interstellar ship, World world )
    {
        return ship.getPassageDemand() * 1000 + 8000;
    }

    public void unload( World world ) {}

    public void load( Playable player )
    {
        Object[] tradeCodes = player.getWorld().tradeCodes();
        int tcCount = tradeCodes.length + 1;

        tons = (flux() + player.getWorld().popDigit()) * tcCount
                + player.getSkillLevel( "liaison" )
                + player.getShip().getPassageDemand();

        if ( tons < 0 ) tons = 0;

    }
}
