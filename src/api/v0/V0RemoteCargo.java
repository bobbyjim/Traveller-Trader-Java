package api.v0;

import api.ApiCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Remote cargo retriever, 11/29/2017.
 */
public class V0RemoteCargo implements ApiCommand
{
    public String name() { return "remoteCargo"; }

    public String handle(String[] path, Map<String,Object> parameters, HashMap<String,Object> jsonMap  )
    {
        return "not implemented";
    }
}
