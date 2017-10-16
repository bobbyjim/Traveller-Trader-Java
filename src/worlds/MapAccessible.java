package worlds;

import java.util.HashMap;

public interface MapAccessible
{
    HashMap<String,Object> getWorld(String sector, String hex );
    World[] getJumpMap(String sector, String hex, int jumpnum );
}
