package players;

import java.util.ArrayList;

public interface Playable
{
    String getSectorAbbreviation();
    String getHex();
    int getJumpDistance();
    void showWorlds(ArrayList worlds);
}
