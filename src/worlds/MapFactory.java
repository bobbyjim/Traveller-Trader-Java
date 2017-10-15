package worlds;

public class MapFactory
{
    public static MapAccessible getMapEngine( String name )
    {
        switch( name )
        {
            case "worlds.TravellerMap": return new TravellerMap();
        }
        return new TravellerMap();
    }
}
