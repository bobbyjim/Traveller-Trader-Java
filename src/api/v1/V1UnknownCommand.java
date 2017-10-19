package api.v1;

import api.ApiCommand;

public class V1UnknownCommand implements ApiCommand {
    public String handle( String[] path )
    {
        return ApiCommand.unknownCommand;
    }
}
