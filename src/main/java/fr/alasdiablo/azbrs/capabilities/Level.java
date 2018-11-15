package fr.alasdiablo.azbrs.capabilities;

public class Level implements ILevel {

    private int level = 1;
    private int subLevel = 0;

    private int endurance = 0;
    private int strength = 0;
    private int crafts = 0;

    @Override
    public void addLevel() {

    }

    @Override
    public void setLevel(int[] level) {
        this.level = level[0];
        this.subLevel = level[1];
        this.endurance = level[2];
        this.strength = level[3];
        this.crafts = level[4];
    }

    @Override
    public int[] getLevel() {
        return new int[] {
                this.level,
                this.subLevel,
                this.endurance,
                this.strength,
                this.crafts
        };
    }
}
