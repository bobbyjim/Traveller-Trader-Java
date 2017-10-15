package players;

import java.util.ArrayList;

public class Player implements Playable
{
    private String sector = "spin";
    private String hex = "1910";
    private int jumpno = 2;

    public String getSectorAbbreviation() {
        return sector;
    }

    public String getHex() {
        return hex;
    }

    public int getJumpDistance() {
        return jumpno;
    }

    public void showWorlds(ArrayList worlds) {}
}
