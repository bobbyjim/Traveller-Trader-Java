package ships;

/**
 * Created by eagro02 on 10/17/2017.
 */
public class ShipFactory
{
    public static Ship createShip( String type )
    {
        switch( type )
        {
            case "A":
            case "Trader":
            case "Free Trader":
            case "Beowulf":
            default:
                return ShipBuilder.create()
                        .shipClass( "Beowulf" )
                        .mission("A")
                        .sizeCode( "B" )
                        .config("U")
                        .fuel(21)
                        .mid(8)
                        .low(10)
                        .hold(82)
                        .jump(1)
                        .maneuver(1)
                        .build();

            case "A2":
            case "Far Trader":
            case "Marava":
                return ShipBuilder.create()
                        .shipClass( "Marava" )
                        .mission("A2")
                        .sizeCode( "B" )
                        .config("S")
                        .fuel(41)
                        .mid(6)
                        .low(4)
                        .hold(64)
                        .jump(2)
                        .maneuver(1)
                        .build();

        }
    }

    /**
     * An *ideal* QSP looks like this:
     *
     *              Marava A2-BS11 fuel hold vault h/m/l
     *                |    |  ||||
     * Class name -----    |  ||||
     * Mission -------------  ||||
     * Size -------------------|||
     * Hull Configuration ------||
     * Jump rating --------------|
     * Maneuver rating -----------
     *
     */
    public static Ship createShipFromQSP( String extendedQSP )
    {
        String[] elements = extendedQSP.split( " " );
        String   className  = elements[0];
        String[] qsp        = elements[1].split( "-" );
        String   mission    = qsp[0];
        int      fuel       = Integer.parseInt( elements[2] );
        int      hold       = Integer.parseInt( elements[3] );
        boolean  vault      = Boolean.parseBoolean( elements[4] );
        String[] pass       = elements[5].split( "/" );

        String size = qsp[1].substring(0,1);
        String config = qsp[1].substring(1,2);
        int jump = Integer.parseInt( qsp[1].substring(2,3) );
        int manu = Integer.parseInt( qsp[1].substring(3,4) );

        Ship ship = ShipBuilder.create()
                .shipClass( className )
                .sizeCode( size )
                .mission( mission )
                .hold( hold )
                .fuel( fuel )
                .jump( jump )
                .config( config )
                .maneuver( manu )
                .high( Integer.parseInt( pass[0] ))
                .mid( Integer.parseInt( pass[1] ))
                .low( Integer.parseInt( pass[2] ))
                .build();

        ship.hasVault = vault;
        return ship;
    }
}
