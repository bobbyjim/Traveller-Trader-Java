package api;

import api.v0.*;

public class APIv0CommandFactory implements API
{
    ApiCommand ship = new V0Ship();
    ApiCommand doNothing = new V0DoNothing();

    public ApiCommand getCommand( String stemNoun )
    {
        String cmd = stemNoun.toLowerCase();
        switch( cmd )
        {
            case "ship":
                return ship;
            default:
                return doNothing;
        }
    }
}
