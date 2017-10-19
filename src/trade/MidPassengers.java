package trade;

import players.Playable;
import ships.Interstellar;
import worlds.World;

public class MidPassengers implements Shippable
{
    public int count = 0;

    public int getCount() { return count; }

    private int flux()
    {
        int a = (int)(Math.random() * 6);
        int b = (int)(Math.random() * 6);
        return a - b;
    }

    public int buyPrice( Interstellar ship, World world ) { return 0; }
    public int sellPrice( Interstellar ship, World world )
    {
        return ship.getPassageDemand() * 1000 + 8000;
    }

    public void unload( World world )
    {

    }

    public void load( Playable player )
    {
        count = flux()
                + player.getWorld().popDigit()
                + player.getSkillLevel( "admin" )
                + player.getShip().getPassageDemand();

        if ( count < 0 ) count = 0;
    }
}
