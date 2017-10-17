package worlds;

import java.util.HashMap;

/**
 * Created by eagro02 on 10/17/2017.
 */
public class WorldBuilder
{
    World world;

    // This is the factory method for creating a world.
    public static World build( HashMap hash )
    {
        return WorldBuilder.create()
                .hex( hash.get( "Hex" ).toString() )
                .sectorShortname( hash.get("SectorAbbreviation").toString() )
                .bases( hash.get("Bases").toString() )
                .name( hash.get("Name").toString() )
                .uwp( hash.get("UWP").toString() )
                .remarks( hash.get("Remarks").toString() )
                .worldX( Integer.parseInt( hash.get( "WorldX" ).toString() ) )
                .worldY( Integer.parseInt( hash.get( "WorldY" ).toString() ) )
                .build();
    }

    public static World BuildRegina()
    {
        return  WorldBuilder.create()
                .name( "Regina" )
                .hex( "1910" )
                .sectorShortname( "spin" )
                .remarks( "Ri Pa Ph An Cp" )
                .uwp( "A788899-C" )
                .build();
    }

    public static WorldBuilder create()
    {
        WorldBuilder builder = new WorldBuilder();
        builder.world = new World();
        return builder;
    }

    public World build()
    {
        return world;
    }

    public WorldBuilder name( String name )
    {
        world.name = name;
        return this;
    }

    public WorldBuilder hex( String hex )
    {
        world.hex = hex;
        return this;
    }

    public WorldBuilder sectorShortname( String sec )
    {
        world.sectorAbbreviation = sec;
        return this;
    }

    public WorldBuilder uwp( String uwp )
    {
        world.uwp = uwp;
        return this;
    }

    public WorldBuilder remarks( String rem )
    {
        world.remarks = rem;
        return this;
    }

    public WorldBuilder bases( String bases )
    {
        world.bases = bases;
        return this;
    }

    public WorldBuilder worldX( int worldx )
    {
        world.worldX = worldx;
        return this;
    }

    public WorldBuilder worldY( int worldy )
    {
        world.worldY = worldy;
        return this;
    }
}
