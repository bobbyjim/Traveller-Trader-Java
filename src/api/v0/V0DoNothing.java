package api.v0;

import api.ApiCommand;

import java.util.HashMap;
import java.util.Map;

public class V0DoNothing implements ApiCommand
{
    public String handle(String[] path, Map<String,Object> parameters, HashMap<String,Object> jsonMap )
    {
        return "V0Ship waits.";
    }
}
