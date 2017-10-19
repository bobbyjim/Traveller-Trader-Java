package trade;

import java.util.ArrayList;

public class Trade
{
    ArrayList<TradeCode> tradeCodes = new ArrayList<>();
    Cargo cargo;
    int marketTL = 0;

    public int getSalePrice()
    {
        int val = (5000 + (tradeCodes.size() * 1000))
                * (int)( 1 + 0.1 * ( cargo.sourceTL - marketTL ));

        return val;
    }
}
