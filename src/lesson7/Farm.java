package lesson7;

import lesson7.homeani.Cow;
import lesson7.homeani.Chicken;
import lesson7.homeani.Rabbit;
import lesson7.homeani.Cat;

public class Farm {
    public Home[] homeAnimals = new Home[10];
    public Farmer farmer1 = new Farmer(100);

    public void setHomeAnimals(Home[] homeAnimals) {
        this.homeAnimals = homeAnimals;
    }

    public void setFarmer1(Farmer farmer1) {
        this.farmer1 = farmer1;
    }

    public Home[] getHomeAnimals() {
        return homeAnimals;
    }

    public Farmer getFarmer1() {
        return farmer1;
    }
}
