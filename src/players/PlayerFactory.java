package players;

public class PlayerFactory
{
    public static Playable createPlayer( String playerType )
    {
        switch( playerType )
        {
            case "CLI":
            default: return new CLI();
        }
    }
}
