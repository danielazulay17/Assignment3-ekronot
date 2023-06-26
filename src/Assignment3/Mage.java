package Assignment3;
public class Mage extends Player{

    private int manaPool;
    private int currentMana;
    private int manaCost;
    private int spellPower;
    private int hitsCount;
    private int abilityRange;

    public Mage(char tile, Position position, String name, Health health, int attackPoints,
                int defensePoints, int experience, int playerLevel, int manaPool,
                int manaCost, int spellPower, int hitsCount, int abilityRange) {
        super(tile, position, name, health, attackPoints, defensePoints, experience, playerLevel);
        this.manaPool = manaPool;
        this.currentMana = manaPool/4;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitsCount = hitsCount;
        this.abilityRange = abilityRange;
    }

    public void castBlizzard() {
        if (currentMana >= manaCost) {
            // gameFlow ??
        } else {
            // Display a message (cant use mana)
        }
    }

    public int getManaPool() {
        return manaPool;
    }

    public void setManaPool(int manaPool) {
        this.manaPool = manaPool;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getSpellPower() {
        return spellPower;
    }

    public void setSpellPower(int spellPower) {
        this.spellPower = spellPower;
    }

    public int getHitsCount() {
        return hitsCount;
    }

    public void setHitsCount(int hitsCount) {
        this.hitsCount = hitsCount;
    }

    public int getAbilityRange() {
        return abilityRange;
    }

    public void setAbilityRange(int abilityRange) {
        this.abilityRange = abilityRange;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        setManaPool(getManaPool() + (25 * getPlayerLevel()));
        setCurrentMana(Math.min(getCurrentMana() + (getManaPool()/4), getManaPool()));
        setSpellPower(getSpellPower() + (10 * getPlayerLevel()));
    }

    @Override
    public void gameTick() {
        setCurrentMana(Math.min(getManaPool(), getCurrentMana() + (1 * getPlayerLevel())));
    }

    @Override
    public void abilityCast() {
        if(getCurrentMana() >= getManaCost()) {
            setCurrentMana(getCurrentMana() - getManaCost());
            int hits = 0;
            while (hits < getHitsCount() && enemyAlive E.tile.range(Enemy, Player) < getAbilityRange()) do
                //Select random enemy within getAbilityRange(); לגשת לליסט אנמיס בבורד
                    - Deal damage(reduce health value) to the chosen enemy for an amount equal to spell power
            (each enemy may try to defend itself);
            hits++;

        }
    }

    @Override
    public void accept(Unit unit) {
    }

    @Override
    public void processStep() {

    }

    @Override
    public void onDeath() {
        super.onDeath();

    }

    @Override
    public void visit(Player p) {

    }

    @Override
    public void visit(Enemy e) {

    }
}
