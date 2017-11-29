package api.v0;

import api.ApiCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Xmail retriever, 11/29/2017.
 */
public class V0Xmail implements ApiCommand
{
    public String name() { return "xmail"; }

    public String handle(String[] path, Map<String,Object> parameters, HashMap<String,Object> jsonMap  )
    {
        return "not implemented";
    }
}
