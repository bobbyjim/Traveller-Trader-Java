package maps;

import worlds.World;

import java.util.HashMap;

public interface MapAccessible
{
    HashMap<String,Object> getWorld(String sector, String hex );
    World[] getJumpMap(World currentWorld, String sector, String hex, int jumpnum );
}
