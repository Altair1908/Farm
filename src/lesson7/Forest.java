package lesson7;

import lesson7.wildani.Bear;
import lesson7.wildani.Fox;
import lesson7.wildani.Wolf;

public class Forest {
    public Wild[] wildAnimals = new Wild[20];

    public void fillWild() {
        int wildAniIden;
        Wild newWildAni;
        for (int i = 0; i < wildAnimals.length; i++) {
            wildAniIden = (int) ((Math.random() * 2) + 1);
            switch (wildAniIden) {
                case 1:
                    newWildAni = new Bear("Медведь", 70, 15, 20, (byte) 0);
                    wildAnimals[i] = newWildAni;
                    break;
                case 2:
                    newWildAni = new Fox("Лисица", 20, 35, 10, (byte) 0);
                    wildAnimals[i] = newWildAni;
                    break;
                case 3:
                    newWildAni = new Wolf("Волк", 30, 35, 10, (byte) 0);
                    wildAnimals[i] = newWildAni;
                    break;
            }
        }
    }
}
