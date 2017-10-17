package maps;

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
