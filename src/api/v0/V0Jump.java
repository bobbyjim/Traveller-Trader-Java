package api.v0;

import api.ApiCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * "Jump" command 11/29/2017.
 */
public class V0Jump implements ApiCommand
{
    public String name() { return "jump"; }

    public String handle(String[] path, Map<String,Object> parameters, HashMap<String,Object> jsonMap  )
    {
        return "not implemented";
    }
}
