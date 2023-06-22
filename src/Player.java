public abstract class Player extends Unit {

    private int experience;
    private int playerLevel;

    public Player(String name, Health health, int attackPoints, int defensePoints, int experience, int playerLevel)
    {
        super(name, health, attackPoints, defensePoints);
        this.experience = 0;
        this.playerLevel = 1;
    }

    public int getExperience() {
        return experience;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public void levelUp()
    {
        if(this.experience % 50 == 0){
            setPlayerLevel(this.playerLevel + 1);
            setExperience(this.experience- 50);

        }
    }


}
