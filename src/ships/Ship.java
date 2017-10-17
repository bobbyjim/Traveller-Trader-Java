package ships;

import trade.*;

public class Ship implements Interstellar
{
    public String shipClass = "";
    public String sizeCode;

    public int fuel = 0;
    public int jump = 0;
    public int maneuver = 0;
    public int hold = 0;
    public int high = 0;
    public int mid  = 0;
    public int low  = 0;
    public String mission = "Z";
    public String config = "Z";
    public int passageDemand = 0;
    public int crewComfort = 0;
    public boolean hasVault = false;

    public Shippable freight = new Freight();
    public Shippable highPassage = new HighPassengers();
    public Shippable midPassage = new MidPassengers();
    public Shippable lowPassage = new LowPassengers();
    public Shippable cargo = new Cargo();

    public String getMissionCode()   { return mission; }
    public String getConfiguration() { return config; }
    public int getJumpRange() {
        return jump;
    }
    public int getManeuverRating() { return maneuver; }
    public int getFuel() { return fuel; }
    public int getPassageDemand() {
        return passageDemand;
    }
    public int getCrewComfort() {
        return crewComfort;
    }
    public boolean hasVault() {
        return hasVault;
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
