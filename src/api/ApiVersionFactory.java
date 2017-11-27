package api;

public class ApiVersionFactory
{
    public static API getApiVersion( String ver )
    {
        switch( ver )
        {
            default:
            case "v0": return new APIv0CommandFactory();
        }
    }
}
