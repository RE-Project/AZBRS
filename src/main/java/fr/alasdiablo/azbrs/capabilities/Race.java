package fr.alasdiablo.azbrs.capabilities;

public class Race implements IRace {

    private int raceId = -1;

    @Override
    public void setRace(int id) {
        this.raceId = id;
    }

    @Override
    public int getRace() {
        return this.raceId;
    }
}
