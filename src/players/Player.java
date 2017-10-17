package players;

import ships.Interstellar;
import ships.Ship;
import worlds.World;

import java.util.HashMap;

public class Player implements Playable
{
    HashMap<String,Integer> skills = new HashMap<>();
    public World world;
    public Interstellar ship = new Ship();
    public double mcr = 1.0;

    public Player()
    {
        world = new World();
        world.name = "Regina";
        world.sectorAbbreviation = "spin";
        world.hex = "1910";
        world.remarks = "Ri Pa Ph An Cp";
        world.uwp = "A788899-C";

        skills.put( "admin", 1 );
        skills.put( "liaison", 1 );
        skills.put( "steward", 1 );
        skills.put( "streetwise", 1 );
    }

    public World getWorld() { return world; }
    public Interstellar getShip() { return ship; }

    public void visitWorld() {}
    public void jump(World[] worlds) {}
    public int getSkillLevel( String skill )
    {
        if ( skills.containsKey( skill.toLowerCase() ) )
            return skills.get( skill.toLowerCase() );
        else
            return 0; // default
    }
}
