package trade;

import players.Playable;
import ships.Interstellar;
import worlds.World;

import java.util.ArrayList;

public class Cargo implements Shippable
{
    public int tons = 0;
    public int sourceTL = 0;
    public int buyPrice = 0;

    private ArrayList<TradeCode> tradeCodes = new ArrayList<>();

/*    public TradeCode Ag = TradeCode.Ag;
    public TradeCode As = TradeCode.As;
    public TradeCode Ba = TradeCode.Ba;
    public TradeCode De = TradeCode.De;
    public TradeCode Fl = TradeCode.Fl;
    public TradeCode Hi = TradeCode.Hi;
//    public TradeCode Ic = TradeCode.Ic;
    public TradeCode In = TradeCode.In;
    public TradeCode Lo = TradeCode.Lo;
    public TradeCode Na = TradeCode.Na;
    public TradeCode Ni = TradeCode.Ni;
    public TradeCode Po = TradeCode.Po;
    public TradeCode Ri = TradeCode.Ri;
    public TradeCode Va = TradeCode.Va;*/

    public ArrayList<TradeCode> getTradeCodes()
    {
        return tradeCodes;
    }

    public void addTradeCode(TradeCode tc )
    {
        tradeCodes.add( tc );
    }

    public boolean hasTradeCode( TradeCode tc )
    {
        return tradeCodes.contains( tc );
    }

    public int getCount() { return tons; }
    public int buyPrice( Interstellar ship, World sourceWorld )
    {
        return buyPrice;
    }

/*    public int sellPrice( Interstellar ship, World marketWorld )
    {
        int value = 5000
                + Ag.getSellModifier()
                + As.getSellModifier()
                + Ba.getSellModifier()
                + De.getSellModifier()
                + Fl.getSellModifier()
                + Hi.getSellModifier()
//                + Ic.getSellModifier()
                + In.getSellModifier()
                + Lo.getSellModifier()
                + Na.getSellModifier()
                + Ni.getSellModifier()
                + Po.getSellModifier()
                + Ri.getSellModifier()
                + Va.getSellModifier()
                + (int)( 0.1 * (sourceTL - marketWorld.TL()));

        return value;
    }*/


    public void unload( World world )
    {

    }

    public void load( Playable player )
    {

    }
}
