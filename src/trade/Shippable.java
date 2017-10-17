package trade;

import players.Playable;
import ships.Interstellar;
import worlds.World;

public interface Shippable
{
    int getCount();
    int pricing(Interstellar ship, World world);
    void unload( World world );
    void load( Playable player );
}
