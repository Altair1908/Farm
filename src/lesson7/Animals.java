package lesson7;

abstract public class Animals {
    protected int weight;
    protected int moveSpeed;

    public Animals(int weight, int moveSpeed) {
        this.weight = weight;
        this.moveSpeed = moveSpeed;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }




    public int getWeight() {
        return weight;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }
}
