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

    private void printDestinations( World[] worlds )
    {
        // return worlds in JSON?

        /*System.out.println( "Destinations in range:" );
        for (int i=0; i<worlds.length; i++)
        {
            String index = pad(i + "", 2);
            System.out.println(index + ": " + worlds[i].toString());
        }*/
    }

}
