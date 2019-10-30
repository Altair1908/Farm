package lesson7;

public class Home extends Animals{
    private int health;
    private int resource;
    private boolean eatable;

    public Home(String name, int weight, int moveSpeed, int health, int resource, boolean eatable) {
        super(name, weight, moveSpeed);
        setHealth(health);
        setResource(resource);
        setEatable(eatable);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public void setEatable(boolean eatable) {
        this.eatable = eatable;
    }

    public int getHealth() {
        return health;
    }

    public int getResource() {
        return resource;
    }

    public boolean isEatable() {
        return eatable;
    }

}
