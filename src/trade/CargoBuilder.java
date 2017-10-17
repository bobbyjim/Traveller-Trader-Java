package trade;

import worlds.World;

/**
 * Created by eagro02 on 10/17/2017.
 */
public class CargoBuilder
{
    Cargo cargo;
    public CargoBuilder create(World sourceWorld)
    {
        cargo = new Cargo();
        Object[] tradeCodes = sourceWorld.tradeCodes();

        for( Object tc : tradeCodes )
        {
            if ( "Na".equals( tc ) ) isNa( cargo );
            if ( "Ag".equals( tc ) ) isAg( cargo );
        }
        return this;
    }

    public Cargo build()
    {
        return cargo;
    }

    private void isNa( Cargo cargo )
    {

    }

    private void isAg( Cargo cargo )
    {

    }
}
