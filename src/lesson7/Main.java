package lesson7;

import lesson7.homeani.Cat;
import lesson7.homeani.Chicken;
import lesson7.homeani.Cow;
import lesson7.homeani.Rabbit;
import lesson7.wildani.Bear;
import lesson7.wildani.Fox;
import lesson7.wildani.Wolf;

public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm();
        Forest forest = new Forest();
        int[] unluckyWild = new int[forest.wildAnimals.length];
// Заполнение массива диких животных //////////////////////////////////////////////
        int wildAniIden;
        Wild newWildAni;
        for (int i = 0; i < forest.wildAnimals.length; i++) {
            wildAniIden = (int) ((Math.random() * 2) + 1);
            switch (wildAniIden) {
                case 1:
                    newWildAni = new Bear("Медведь",70, 15,20);
                    forest.wildAnimals[i] = newWildAni;
                    break;
                case 2:
                    newWildAni = new Fox("Лисица",20, 35,10);
                    forest.wildAnimals[i] = newWildAni;
                    break;
                case 3:
                    newWildAni = new Wolf("Волк",30, 35,10);
                    forest.wildAnimals[i] = newWildAni;
                    break;
            }
        }
// Заполнение массива домашних животных //////////////////////////////////////////////
        int homeAniIden;
        Home newHomeAni;
        for (int i = 0; i < farm.homeAnimals.length; i++) {
            homeAniIden = (int) ((Math.random() * 4) + 1);
            switch (homeAniIden) {
                case 1:
                    newHomeAni = new Cow("Корова", 50, 10, 50, 3, true);
                    farm.homeAnimals[i] = newHomeAni;
                    break;
                case 2:
                    newHomeAni = new Chicken("Курица", 10, 20, 15, 2, true);
                    farm.homeAnimals[i] = newHomeAni;
                    break;
                case 3:
                    newHomeAni = new Rabbit("Кролик", 10, 30, 15, 0, true);
                    farm.homeAnimals[i] = newHomeAni;
                    break;
                case 4:
                    newHomeAni = new Cat("Кот", 7, 40, 10, 0, false);
                    farm.homeAnimals[i] = newHomeAni;
                    break;
            }
        }
        // Циклим дни фермы
        int newInd2 = forest.wildAnimals.length;
        for (int y = 0; y < 200; y++) {
            System.out.println("День " + (y + 1));
            // Фермер расходует ресурс
            farm.farmer1.spendRes();
            if (farm.farmer1.getResFarmer() <= 0) {
                System.out.println("Фермер израсходовал весь свой ресурс! Вы проиграли!");
                break;
            }
            // Случайное дикое животное нападает на случайное домашнее животное
            // Проверка на появление null массива homeAnimals
                int newInd = farm.homeAnimals.length - 1;
                for (int i = 0; i < farm.homeAnimals.length; i++) {
                    if (farm.homeAnimals[i] == null) {
                        newInd = i - 1;
                        break;
                    }
                }
                // Проверка на появление 3 массива wildAnimals
                for (int t = 0; t < unluckyWild.length; t++) {
                    if (unluckyWild[t] == 3) {
                        System.out.println("Один из хищников (" + forest.wildAnimals[t].name + ") больше не прийдёт!");
                        System.arraycopy(unluckyWild, t + 1, unluckyWild, t, unluckyWild.length - (t + 1));
                        System.arraycopy(forest.wildAnimals, t + 1, forest.wildAnimals, t, forest.wildAnimals.length - (t + 1));
                        newInd2 = newInd2 - 1;
                        System.out.println("Количество оставшихся хищников: " + newInd2 + ".");
                        break;
                    }
                }
                if (newInd2 == 0) {
                    System.out.println("Больше не осталось хищников, которые осмелятся прийти на ферму! Вы выиграли!");
                    break;
                } else {
                    if (newInd == -1) {
                        System.out.println("На ферме не осталось животных! Вы проиграли!"); // Условный вариант поражения. Скорее всего в таком случае фермер проиграет раньше от недостатка ресов
                        break;
                    } else {
                        int randWild = (int) (Math.random() * newInd2); // Выбираем дикое животное, которое нападёт
                        int randHome = (int) (Math.random() * (newInd + 1)); // Выбираем домашнее животное для нападения
                        forest.wildAnimals[randWild].attack(farm.homeAnimals, randHome, farm.farmer1, unluckyWild, randWild); // Вызываем метод атаки
                    }
                }
            // Фермер кормит животных
            for (int i = 0; i < farm.homeAnimals.length; i++) { // Определям заново newInd на случай, если дикое убьёт домашнее
                if (farm.homeAnimals[i] == null) {
                    newInd = i - 1;
                    break;
                }
            }
            farm.farmer1.feedHome(farm.homeAnimals, newInd + 1);
            // Фермер собирает ресурс и поплняет его
            farm.farmer1.eatRes(farm.homeAnimals, newInd + 1);
            //System.out.println("ДЖ: \n" + farm.homeAnimals[0] + "\n" + farm.homeAnimals[1] + "\n" + farm.homeAnimals[2] + "\n" + farm.homeAnimals[3] + "\n" + farm.homeAnimals[4] + "\n" + farm.homeAnimals[5] + "\n" + farm.homeAnimals[6] + "\n" + farm.homeAnimals[7] + "\n" + farm.homeAnimals[8] + "\n" + farm.homeAnimals[9]);
        }
    }
}
