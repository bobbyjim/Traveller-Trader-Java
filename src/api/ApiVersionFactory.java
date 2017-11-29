package api;

public class ApiVersionFactory
{
    private static API v0factory = new APIv0CommandFactory();

    public static API apiV0factory()
    {
        return v0factory;
    }
    public static API getApiVersion( String ver )
    {
        switch( ver )
        {
            default:
            case "v0": return new APIv0CommandFactory();
        }
    }
}
