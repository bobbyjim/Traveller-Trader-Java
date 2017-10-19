package api;

import api.v1.*;

public class APIv1 implements API
{
    ApiCommand unknownCommand = new V1UnknownCommand();
    ApiCommand createPlayer   = new V1CreatePlayer();
    ApiCommand getPlayer      = new V1GetPlayer();
    ApiCommand getMap         = new V1GetMap();
    ApiCommand putShip        = new V1PutShip();
    ApiCommand createPassengers = new V1CreatePassengers();
    ApiCommand putPassengers  = new V1PutPassengers();
    ApiCommand deletePassengers = new V1DeletePassengers();
    ApiCommand createCargo    = new V1CreateCargo();
    ApiCommand putCargo       = new V1PutCargo();
    ApiCommand deleteCargo    = new V1DeleteCargo();

    public ApiCommand getCommand( String verb, String stemNoun )
    {
        String cmd = verb + "." + stemNoun;
        switch( cmd )
        {
            case "CREATE player":
                return createPlayer;
            case "GET player":
                return getPlayer;
            case "GET map":
                return getMap;
            case "PUT ship":
                return putShip;
            case "CREATE passengers":
                return createPassengers;
            case "PUT passengers":
                return putPassengers;
            case "DELETE passengers":
                return deletePassengers;
            case "CREATE cargo":
                return createCargo;
            case "PUT cargo":
                return putCargo;
            case "DELETE cargo":
                return deleteCargo;
            default:
                break;
        }
        return unknownCommand;
    }
}

