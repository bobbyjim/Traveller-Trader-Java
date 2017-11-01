package players;

import ships.Interstellar;
import worlds.World;

import java.io.Serializable;

public interface Playable extends Serializable
{
    String getID();
    void setID( String id );
    World getWorld();
    Interstellar getShip();
    String loadShip();
    String unloadShip();
    String visitWorld();
    void jump(World[] worlds);
    int getSkillLevel( String skill );
}
