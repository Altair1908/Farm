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
            if (this.moveSpeed > hAA[hA].moveSpeed) {
                hAA[hA].setHealth(hAA[hA].getHealth() - this.power);
                if (hAA[hA].getHealth() <= 0){
                    System.out.println(this.name + " убил " + hAA[hA].name + ".");
                    //Чтобы не возникло проблем с выбором нового домашнего животного для атаки, если кто-то погибнет, придётся переформировать существующий массив.....
                    //Я сделал, что элементы после null просто смещаются на 1 ячейку влево, соот-но при рандоме нового животного диапазон рандома будет менбше на 1 (это в Main проверяется)
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
