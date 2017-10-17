package worlds;

import com.sun.org.apache.xalan.internal.lib.ExsltStrings;

import java.util.ArrayList;
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

    private final String[] tcList = { "Ag", "As", "Ba", "De", "Fl", "Hi", "Ic", "In", "Lo", "Na", "Ni", "Po", "Ri", "Va" };

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

    public String[] splitRemarks()
    {
        return remarks.split( "\\s+" );
    }

    public Object[] tradeCodes()
    {
        ArrayList<String> list = new ArrayList<>();
        for( String tc : tcList )
        {
            if ( remarks.contains( tc ) ) list.add( tc );
        }
        return list.toArray();
    }

    public int popDigit()
    {
        String pop = uwp.substring(4,5);
        switch( pop )
        {
            default:
            case "0": return 0;
            case "1": return 1;
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "A": return 10;
            case "B": return 11;
            case "C": return 12;
            case "D": return 13;
            case "E": return 14;
            case "F": return 15;
        }
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
