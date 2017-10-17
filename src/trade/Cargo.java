package trade;

import players.Playable;
import ships.Interstellar;
import worlds.World;

public class Cargo implements Shippable
{
    public int tons = 0;

    public int getCount() { return tons; }
    public int pricing( Interstellar ship, World world )
    {
        return 3000;
    }

    public void unload( World world )
    {

    }

    public void load( Playable player )
    {

    }
}
