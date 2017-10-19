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

    public void unload( World world )
    {

    }

    public void load( Playable player )
    {

    }
}
