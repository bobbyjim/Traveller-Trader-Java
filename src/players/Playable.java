package players;

import worlds.World;

import java.util.ArrayList;

public interface Playable
{
    World getCurrentWorld();
    int getJumpDistance();
    void visitWorld();
    void jump(World[] worlds);
}
