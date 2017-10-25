package api.v0;

import api.ApiCommand;

import java.io.BufferedReader;

public class V0DoNothing implements ApiCommand
{
    public String handle(String[] path, BufferedReader reader)
    {
        return "Ship waits.";
    }
}
