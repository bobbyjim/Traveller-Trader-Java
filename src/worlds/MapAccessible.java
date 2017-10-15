package worlds;

import java.util.ArrayList;
import java.util.HashMap;

public interface MapAccessible
{
    HashMap<String,Object> getWorld(String sector, String hex );
    ArrayList getJumpMap(String sector, String hex, int jumpnum );
}
