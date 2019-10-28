package lesson7;

public class Wild extends Animals{
    protected int power;

    public Wild(int weight, int moveSpeed, int power) {
        super(weight, moveSpeed);
        this.power = power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
