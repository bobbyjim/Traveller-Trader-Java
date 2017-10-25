package api.v0;

import api.ApiCommand;
import org.json.simple.util.Mapper;

import java.io.BufferedReader;
import java.util.HashMap;

public class V0JumpShip implements ApiCommand
{
    /*
     * Signature:
     *
     * PATCH /v0/ship/<playerid>
     *
     * Body is of the form:
     *
     * {
     *    'destination': {...}
     * }
     *
     */
    public String handle(String[] path, BufferedReader reader )
    {
        HashMap<String,Object> dat = Mapper.decode( reader );
        return "Not yet implemented";
    }
}
