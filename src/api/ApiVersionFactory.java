package api;

public class ApiVersionFactory
{
    public static API getApiVersion( String ver )
    {
        switch( ver )
        {
            default:
            case "v1": return new APIv1();
        }
    }
}
