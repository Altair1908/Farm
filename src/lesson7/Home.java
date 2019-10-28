package lesson7;

public class Home extends Animals{
    protected String name;
    protected int health;
    protected int resource;
    protected boolean eatable;

    public Home(int weight, int moveSpeed, String name, int health, int resource, boolean eatable) {
        super(weight, moveSpeed);
        this.name = name;
        this.health = health;
        this.resource = resource;
        this.eatable = eatable;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getName() {
        return name;
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
