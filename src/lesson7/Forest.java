package lesson7;

import lesson7.wildani.Bear;
import lesson7.wildani.Fox;
import lesson7.wildani.Wolf;

public class Forest {
    public Wild[] wildAnimals = new Wild[10];

    public void setWildAnimals(Wild[] wildAnimals) {
        this.wildAnimals = wildAnimals;
    }

    public Wild[] getWildAnimals() {
        return wildAnimals;
    }
}
