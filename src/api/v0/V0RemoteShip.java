package api.v0;

import api.ApiCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Remote ship retriever, 11/29/2017.
 */
public class V0RemoteShip implements ApiCommand
{
    public String name() { return "remoteShip"; }

    public String handle(String[] path, Map<String,Object> parameters, HashMap<String,Object> jsonMap  )
    {
        return "not implemented";
    }
}
