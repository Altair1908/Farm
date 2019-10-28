package lesson7;

import lesson7.homeani.Cat;
import lesson7.homeani.Chicken;
import lesson7.homeani.Cow;
import lesson7.homeani.Rabbit;

public class Farm {

    private Home[] homeAnimals = new Home[50];
    Farmer farmer1 = new Farmer(100);

    public void generateHome(){
        int homeAniIden;
        //int rand = (int) Math.random() * 5 + 30;
        Home newAni = null;
        for (int i = 0; i < homeAnimals.length; i++) {
            homeAniIden = (int) ((Math.random() * 3) + 1);
            switch (homeAniIden) {
                case 1:
                    newAni = new Cow(100, 10, "Корова", 50, 10, true);
                    homeAnimals[i] = newAni;
                    break;
                case 2:
                    newAni = new Chicken(10, 20, "Курица", 15, 10, true);
                    homeAnimals[i] = newAni;
                    break;
                case 3:
                    newAni = new Rabbit(10, 40, "Кролик", 15, 10, true);
                    homeAnimals[i] = newAni;
                    break;
                case 4:
                    newAni = new Cat(10, 40, "Кот", 10, 0, false);
                    homeAnimals[i] = newAni;
                    break;
            }
        }
    }
    public void day(){
        farmer1.spendRes();
    }
}
