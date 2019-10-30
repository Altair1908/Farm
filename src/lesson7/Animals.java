package lesson7;

abstract public class Animals {
    protected String name;
    protected int weight;
    protected int moveSpeed;

    public Animals(String name, int weight, int moveSpeed) {
        setName(name);
        setWeight(weight);
        setMoveSpeed(moveSpeed);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }
}
