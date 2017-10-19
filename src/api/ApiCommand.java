package api;

public interface ApiCommand {
    String handle( String[] path );

    String notImplemented = "not implemented";
    String unknownCommand = "unknown command";

}
