public class Health {

    public int healthPool;
    public int healthAmount;

    public Health (int healthPool, int healthAmount)
    {
        this.healthPool = healthPool;
        this.healthAmount = healthAmount;
    }

    public int getHealthPool() {
        return healthPool;
    }

    public void setHealthPool(int healthPool) {
        this.healthPool = healthPool;
    }

    public int getHealthAmount() {
        return healthAmount;
    }

    public void setHealthAmount(int healthAmount) {
        this.healthAmount = healthAmount;
    }
}
