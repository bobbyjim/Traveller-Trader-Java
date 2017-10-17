package ships;

import trade.*;

public class Ship implements Interstellar
{
    public int fuel = 0;
    public int jump = 2;
    public int maneuver = 1;
    public int hold = 82;
    public int high = 0;
    public int mid  = 6;
    public int low  = 10;

    public Shippable freight = new Freight();
    public Shippable highPassage = new HighPassengers();
    public Shippable midPassage = new MidPassengers();
    public Shippable lowPassage = new LowPassengers();
    public Shippable cargo = new Cargo();

    public int getJumpRange() {
        return jump;
    }

    public int getPassageDemand() {
        return 0;
    }

    public int getCrewComfort() {
        return 0;
    }

    public boolean hasVault() {
        return false;
    }

    public int freeCargoSpace() {
        return 0;
    }

    public Shippable getFreight() {
        return freight;
    }

    public Shippable getCargo() {
        return cargo;
    }

    public Shippable getHighPassengers() {
        return highPassage;
    }

    public Shippable getMidPassengers() {
        return midPassage;
    }

    public Shippable getLowPassengers() {
        return lowPassage;
    }
}
