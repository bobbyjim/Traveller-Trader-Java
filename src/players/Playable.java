package players;

import ships.Interstellar;
import worlds.World;

public interface Playable
{
    World getWorld();
    Interstellar getShip();
    void visitWorld();
    void jump(World[] worlds);
    int getSkillLevel( String skill );
}
