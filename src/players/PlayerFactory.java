package players;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PlayerFactory
{
    public static Playable createPlayer( String playerType )
    {
        switch( playerType )
        {
            case "HTTP":
                return new WebClient();
            case "CLI":
            default:
                return new CLI();
        }
    }

    public static Playable getPlayer( String playerID )
    {
        return getPlayer( playerID, "CLI" );
    }

    public static Playable getPlayer( String playerID, String playerType )
    {
        String filename = playerID + ".ser";
        try
        {
            ObjectInputStream ois = new ObjectInputStream( new FileInputStream( filename ));
            Playable player = (Playable) ois.readObject();
            ois.close();
            System.err.println( "Player object " + playerID + " read." );
            return player;
        }
        catch (Exception e )
        {
            System.err.println( "Error reading player " + playerID + ": " + e.getMessage() );
            // e.printStackTrace();
        }
        System.err.println( "Creating new player " + playerID );
        Playable player = createPlayer( playerType );
        player.setID( playerID );
        return player;
    }

    public static void savePlayer( Playable player )
    {
        String filename = player.getID() + ".ser";
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( filename ));
            oos.writeObject( player );
            oos.flush();
            oos.close();
        }
        catch( Exception e )
        {
            System.err.println( "Error writing player " + player.getID() + ": " + e.getMessage() );
        }
    }
}
