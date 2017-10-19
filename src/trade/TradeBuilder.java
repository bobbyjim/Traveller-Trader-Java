package trade;

import worlds.World;

import java.util.ArrayList;

public class TradeBuilder
{
    private Trade trade;

    public static Trade buildTrade(Cargo cargo, World market)
    {
        TradeBuilder builder = new TradeBuilder( cargo, market );
        return builder.trade;
    }

    private TradeBuilder( Cargo cargo, World market )
    {
        trade = new Trade();
        trade.cargo = cargo;
        trade.marketTL = market.TL();
        Object[] tradeCodes = market.tradeCodes();

        for( Object tc : tradeCodes )
        {
            if ( "Ag".equals( tc ) ) add( cargo, TradeCode.Ag );
            if ( "As".equals( tc ) ) add( cargo, TradeCode.As );
            if ( "De".equals( tc ) ) add( cargo, TradeCode.De );
            if ( "Fl".equals( tc ) ) add( cargo, TradeCode.Fl );
            if ( "Hi".equals( tc ) ) add( cargo, TradeCode.Hi );
            if ( "In".equals( tc ) ) add( cargo, TradeCode.In );
            if ( "Ri".equals( tc ) ) add( cargo, TradeCode.Ri );
            if ( "Va".equals( tc ) ) add( cargo, TradeCode.Va );
        }
    }

    private void add( Cargo cargo, TradeCode tc )
    {
        if ( cargo != null && cargo.hasTradeCode( tc ) )
            trade.tradeCodes.add( tc );
    }
}
