package starport;

import players.Playable;
import worlds.World;

import java.util.Date;

/**
 * A way to communicate with your buddies.
 */
public class Xmessage
{
    Playable sender;
    Playable receiver;
    World    originWorld;
    Date     created;
    String   message;
    boolean  active;
}
