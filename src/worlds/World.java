package worlds;

import java.util.HashMap;

/**
 * Created by eagro02 on 10/16/2017.
 */
public class World
{
    public String name;
    public String hex;
    public String sectorAbbreviation;
    public String uwp;
    public String bases;
    public String remarks;
    public String worldx;
    public String worldy;

    public void populate( HashMap hash )
    {
        hex     = hash.get( "Hex" ).toString();
        sectorAbbreviation = hash.get("SectorAbbreviation").toString();
        bases   = hash.get("Bases").toString();
        name    = hash.get("Name").toString();
        uwp     = hash.get("UWP").toString();
        remarks = hash.get("Remarks").toString();
        worldx  = hash.get( "WorldX" ).toString();
        worldy  = hash.get( "WorldY" ).toString();
    }

    public String toString()
    {
        return sectorAbbreviation + " "
                + hex + " "
                + String.format( "%15s", name ) + " "
                + uwp + " "
                + String.format( "%2s", bases ) + " "
                + remarks;
    }
}
