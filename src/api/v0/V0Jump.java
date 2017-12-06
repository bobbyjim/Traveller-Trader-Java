package api.v0;

import api.ApiCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * "Jump" command 11/29/2017.
 * This command jumps a ship from one star system to the other.
 */
public class V0Jump extends V0Ship implements ApiCommand
{
    public String name() { return "jump"; }

//    public String handle(String[] path, Map<String,Object> parameters, HashMap<String,Object> jsonMap  )
//    {
//        return "not implemented";
//    }
}
