package trade;

import worlds.World;

/**
 * Created by eagro02 on 10/17/2017.
 */
public class CargoBuilder
{
    Cargo cargo;

    public static Cargo buildCargo(World sourceWorld)
    {
        CargoBuilder builder = new CargoBuilder( sourceWorld );
        return builder.build();
    }

    private CargoBuilder(World sourceWorld)
    {
        cargo = new Cargo();
        cargo.sourceTL = sourceWorld.TL();

        Object[] tradeCodes = sourceWorld.tradeCodes();

        for( Object tc : tradeCodes )
        {
            if ( "Ag".equals( tc ) ) isAg();
            if ( "As".equals( tc ) ) isAs();
            if ( "Ba".equals( tc ) ) isBa();
            if ( "De".equals( tc ) ) isDe();
            if ( "Fl".equals( tc ) ) isFl();
            if ( "Hi".equals( tc ) ) isHi();
            if ( "In".equals( tc ) ) isIn();
            if ( "Lo".equals( tc ) ) isLo();
            if ( "Na".equals( tc ) ) isNa();
            if ( "Ni".equals( tc ) ) isNi();
            if ( "Po".equals( tc ) ) isPo();
            if ( "Ri".equals( tc ) ) isRi();
            if ( "Va".equals( tc ) ) isVa();
        }
    }

    public Cargo build()
    {
        int value = 3000
/*                + cargo.Ag.getBuyModifier()
                + cargo.As.getBuyModifier()
                + cargo.Ba.getBuyModifier()
                + cargo.De.getBuyModifier()
                + cargo.Fl.getBuyModifier()
                + cargo.Hi.getBuyModifier()
                + cargo.In.getBuyModifier()
                + cargo.Lo.getBuyModifier()
                + cargo.Na.getBuyModifier()
                + cargo.Ni.getBuyModifier()
                + cargo.Po.getBuyModifier()
                + cargo.Ri.getBuyModifier()
                + cargo.Va.getBuyModifier()*/
                + cargo.sourceTL * 100;

        for( TradeCode tc : cargo.getTradeCodes() )
        {
            value += tc.buyMod;
        }
        cargo.buyPrice = value;
        return cargo;
    }

    private void isAg()
    {
        cargo.addTradeCode( TradeCode.Ag );
    }
    private void isAs()
    {
        cargo.addTradeCode( TradeCode.As );
    }
    private void isBa()
    {
        cargo.addTradeCode( TradeCode.Ba );
    }
    private void isDe()
    {
        cargo.addTradeCode(TradeCode.De);
    }
    private void isFl()
    {
        cargo.addTradeCode( TradeCode.Fl );
    }
    private void isHi()
    {
        cargo.addTradeCode( TradeCode.Hi );
    }
    private void isIn()
    {
        cargo.addTradeCode( TradeCode.In );
    }
    private void isLo()
    {
        cargo.addTradeCode( TradeCode.Lo );
    }
    private void isNa()
    {
        cargo.addTradeCode( TradeCode.Na );
    }
    private void isNi()
    {
        cargo.addTradeCode( TradeCode.Ni );
    }
    private void isPo()
    {
        cargo.addTradeCode( TradeCode.Po );
    }
    private void isRi()
    {
        cargo.addTradeCode( TradeCode.Ri );
    }
    private void isVa()
    {
        cargo.addTradeCode( TradeCode.Va );
    }
}
