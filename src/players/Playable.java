package players;

import java.util.ArrayList;

public interface Playable
{
    String getSectorAbbreviation();
    String getHex();
    void setHex( String hex );
    int getJumpDistance();
    void jump(ArrayList worlds);
}
