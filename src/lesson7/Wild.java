package lesson7;

public class Wild extends Animals{
    private int power;
    private byte feared;

    public Wild(String name, int weight, int moveSpeed, int power, byte feared) {
        super(name, weight, moveSpeed);
        setPower(power);
        setFeared(feared);
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setFeared(byte feared) {
        this.feared = feared;
    }

    public int getFeared() {
        return feared;
    }

    public void attack(Home[] hAA, int hA, Farmer f){
        if (f.shooWild() == false) {
            if (this.moveSpeed > hAA[hA].moveSpeed) {
                hAA[hA].setHealth(hAA[hA].getHealth() - this.power);
                if (hAA[hA].getHealth() <= 0){
                    System.out.println(this.name + " убил " + hAA[hA].name + ".");
                    System.arraycopy(hAA, hA + 1, hAA, hA, hAA.length - (hA + 1));
                    hAA[hAA.length - 1] = null;
                } else {
                    System.out.println(this.name + " поранил " + hAA[hA].name + ".");
                }
            } else {
                System.out.println(this.name + " не догнал " + hAA[hA].name + ".");
            }
        } else {
            this.feared += 1;
        }
    }
}
