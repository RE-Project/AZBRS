package fr.alasdiablo.azbrs.capabilities;

public class Gender implements IGender {

    private int isFemale = 0;

    @Override
    public void setGender(int type) {
        this.isFemale = type;
    }

    @Override
    public int getGender() {
        return this.isFemale;
    }
}
