package ships;

import trade.Cargo;
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

    void setCargo(Cargo cargo);

    Shippable getFreight();
    Cargo getCargo();
    Shippable getHighPassengers();
    Shippable getMidPassengers();
    Shippable getLowPassengers();
}
