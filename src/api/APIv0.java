package api;

import api.v0.V0DoNothing;
import api.v0.V0JumpShip;

public class APIv0 implements API
{
    ApiCommand jump = new V0JumpShip();
    ApiCommand doNothing = new V0DoNothing();

    public ApiCommand getCommand( String verb, String stemNoun )
    {
        String cmd = (verb + " " + stemNoun).toLowerCase();
        switch( cmd )
        {
            case "patch ship":
                return jump;
            default:
                return doNothing;
        }
    }
}
