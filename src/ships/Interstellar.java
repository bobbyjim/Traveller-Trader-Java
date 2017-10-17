package ships;

import trade.Shippable;

public interface Interstellar
{
    String getMissionCode();
    String getConfiguration();

    int getJumpRange();
    int getManeuverRating();
    int getFuel();

    int getPassageDemand();
    int getCrewComfort();
    boolean hasVault();
    int freeCargoSpace();

    Shippable getFreight();
    Shippable getCargo();
    Shippable getHighPassengers();
    Shippable getMidPassengers();
    Shippable getLowPassengers();
}
