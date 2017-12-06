package maps;

/**
 * While TravellerMap is the main resource for map data, this factory allows us to
 * route to other map sources, including any data we might want to cache.
 */
public class MapFactory
{
    public static MapAccessible getMapEngine( String name )
    {
        switch( name )
        {
            case "maps.TravellerMap": return new TravellerMap();
        }
        return new TravellerMap();
    }
}
