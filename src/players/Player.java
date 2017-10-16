package players;

import worlds.World;

import java.util.ArrayList;

public class Player implements Playable
{
    public World currentWorld;
    private int jumpno = 2;

    public Player()
    {
        currentWorld = new World();
        currentWorld.name = "Regina";
        currentWorld.sectorAbbreviation = "spin";
        currentWorld.hex = "1910";
    }

    public World getCurrentWorld() { return currentWorld; }
    public int getJumpDistance() { return jumpno; }
    public void visitWorld() {}
    public void jump(World[] worlds) {}
}
