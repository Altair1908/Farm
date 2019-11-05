package lesson7;

import lesson7.homeani.Cow;
import lesson7.homeani.Chicken;
import lesson7.homeani.Rabbit;
import lesson7.homeani.Cat;

public class Farm {
    public Home[] homeAnimals = new Home[30];
    public Farmer farmer1 = new Farmer(100);

    public void fillHome() {
        int homeAniIden;
        Home newHomeAni;
        for (int i = 0; i < homeAnimals.length; i++) {
            homeAniIden = (int) ((Math.random() * 4) + 1);
            switch (homeAniIden) {
                case 1:
                    newHomeAni = new Cow("Корова", 50, 10, 50, 3, true);
                    homeAnimals[i] = newHomeAni;
                    break;
                case 2:
                    newHomeAni = new Chicken("Курица", 10, 20, 15, 2, true);
                    homeAnimals[i] = newHomeAni;
                    break;
                case 3:
                    newHomeAni = new Rabbit("Кролик", 10, 30, 15, 0, true);
                    homeAnimals[i] = newHomeAni;
                    break;
                case 4:
                    newHomeAni = new Cat("Кот", 7, 40, 10, 0, false);
                    homeAnimals[i] = newHomeAni;
                    break;
            }
        }
    }
    public void passDay(Forest forestObj, int numDays) {
        int newInd2 = forestObj.wildAnimals.length;
        for (int y = 0; y < numDays; y++) {
            System.out.println("День " + (y + 1));
            // Фермер расходует ресурс
            farmer1.spendRes();
            if (farmer1.getResFarmer() <= 0) {
                System.out.println("Фермер израсходовал весь свой ресурс! Вы проиграли!");
                break;
            }
            // Случайное дикое животное нападает на случайное домашнее животное
            // Проверка на появление null массива homeAnimals
            int newInd = homeAnimals.length - 1;
            for (int i = 0; i < homeAnimals.length; i++) {
                if (homeAnimals[i] == null) {
                    newInd = i - 1;
                    break;
                }
            }
            // Проверка на появление 3 массива wildAnimals
            for (int t = 0; t < forestObj.wildAnimals.length; t++) {
                if (forestObj.wildAnimals[t].getFeared() == 3) {
                    System.out.println("Один из хищников (" + forestObj.wildAnimals[t].getName() + ") больше не прийдёт!");
                    System.arraycopy(forestObj.wildAnimals, t + 1, forestObj.wildAnimals, t, forestObj.wildAnimals.length - (t + 1));
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
                    forestObj.wildAnimals[randWild].attack(homeAnimals, randHome, farmer1); // Вызываем метод атаки
                }
            }
            // Фермер кормит животных
            for (int i = 0; i < homeAnimals.length; i++) { // Определям заново newInd на случай, если дикое убьёт домашнее
                if (homeAnimals[i] == null) {
                    newInd = i - 1;
                    break;
                }
            }
            farmer1.feedHome(homeAnimals, newInd + 1);
            // Фермер собирает ресурс и поплняет его
            farmer1.eatRes(homeAnimals, newInd + 1);
        }
    }
}
