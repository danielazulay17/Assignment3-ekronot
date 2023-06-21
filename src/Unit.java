public class Unit {

    private String name;
    private Health health;
    private int attackPoints;
    private int defensePoints;


    public Unit (String name, Health health, int attackPoints, int defensePoints)
    {
        this.name = name;
        this.health = health;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
    }
}