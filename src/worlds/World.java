package worlds;

import java.util.HashMap;

/**
 * A plain old Data Object.
 *
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

    public int distanceTo( World otherWorld )
    {
        int row1 = Integer.parseInt( worldy );
        int row2 = Integer.parseInt( otherWorld.worldy );
        int col1 = Integer.parseInt( worldx );
        int col2 = Integer.parseInt( otherWorld.worldx );

        int a1 = row1 + ( col1 / 2 );
        int a2 = row2 + ( col2 / 2 );

        int d1 = Math.abs( a1 - a2 );
        int d2 = Math.abs( col1 - col2 );
        int d3 = Math.abs( (a1 - col1) - (a2 - col2) );

        // return the largest value from among d1, d2, d3.

        if ( d1 > d2 && d2 > d3 ) return d1;
        if ( d2 > d1 && d1 > d3 ) return d2;
        return d3; // last man standing
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
