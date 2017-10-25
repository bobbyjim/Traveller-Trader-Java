package api;

import java.io.BufferedReader;

public interface ApiCommand {
    String handle(String[] path, BufferedReader reader );

    String notImplemented = "not implemented";
    String unknownCommand = "unknown command";

}
