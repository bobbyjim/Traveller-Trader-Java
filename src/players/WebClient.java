package players;

import worlds.World;

public class WebClient extends Player implements Playable
{

    public void jump(World[] worlds)
    {

    }

    private void selectDestination( World[] worlds )
    {

    }

    public String printDestinations( World[] worlds )
    {
        String out = "\nDestinations in range:";
        for (int i=0; i<worlds.length; i++)
        {
            out += "\n<a href='/v0/jump/" + this.playerID + "/" + i + "'>" + i + "</a>" + worlds[i].toString();
        }
        return out;
    }

}
