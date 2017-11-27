package players;

import ships.Interstellar;
import worlds.World;

import java.io.Serializable;

public interface Playable extends Serializable
{
    String getID();
    void setID( String id );
    World getWorld();
    void setWorld( World w );
    Interstellar getShip();
    String loadShip();
    String unloadShip();
    String visitWorld();
    String printDestinations( World[] worlds );
    void jump(World[] worlds);
    int getSkillLevel( String skill );
}
