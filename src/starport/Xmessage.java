package starport;

import players.Playable;
import worlds.World;

import java.util.Date;

public class Xmessage
{
    Playable sender;
    Playable receiver;
    World    originWorld;
    Date     created;
    String   message;
    boolean  active;
}
