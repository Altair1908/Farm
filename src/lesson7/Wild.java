package lesson7;

public class Wild extends Animals{
    private int power;

    public Wild(String name, int weight, int moveSpeed, int power) {
        super(name, weight, moveSpeed);
        setPower(power);
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void attack(Home[] hAA,int hA, Farmer f, int[] uW, int uWI){
        if (f.shooWild() == false) {
            //System.out.println(hA + " ДЖ: \n" + hAA[0] + "\n" + hAA[1] + "\n" + hAA[2] + "\n" + hAA[3] + "\n" + hAA[4] + "\n" + hAA[5] + "\n" + hAA[6] + "\n" + hAA[7] + "\n" + hAA[8] + "\n" + hAA[9]);
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
            uW[uWI] = uW[uWI] + 1;
        }
    }
}
