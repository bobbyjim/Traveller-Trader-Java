package ships;

import trade.Shippable;

public interface Interstellar
{
    int getJumpRange();
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
