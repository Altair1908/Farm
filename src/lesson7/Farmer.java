package lesson7;

public class Farmer {
    private int resFarmer; //текущее кол-во ресурсов фермера
    public Farmer(int resFarmer) {
        this.resFarmer = resFarmer;
    }
    public int getResFarmer() {
        return resFarmer;
    }
    public void spendRes(){ // Трата ресурса
        this.resFarmer -= 15;
        System.out.println("Фермер израсходовал часть ресурсов.");
    }
    public void eatRes(Home[] hAA, int allHome){ // Накопление ресурса
        int resCount = 0;
        int resNotEn;
        for (int i = 0; i < allHome; i++) {
            resCount = resCount + hAA[i].getResource();
        }
        if (resCount >= 15){ // То есть если ресурсов собрано больше, чем потребляет фермер (15), то он есть свою норму, а остальное выкидывает (допустим, что любит только свежее :) )
                this.resFarmer += 15;
                System.out.println("Фермер накопил ресурс.");
        } else { // В случае, если собранных за этот день ресов не хвататет, чтобы поесть, здесь мы смотрим остаток,
                // который фермер отъедает от веса имеющихся животных пока не съест каждое следующее до конца
            System.out.println("Фермеру не хватило ресов, смотрим животных...");
            resNotEn = 15 - resCount;
            int counter1 = 0;
            while (true) {
                if (hAA[counter1].isEatable()) {
                    if (hAA[counter1].weight > resNotEn) {
                        hAA[counter1].weight = hAA[counter1].weight - resNotEn;
                        this.resFarmer += 15;
                        System.out.println("Фермер отъел у " + hAA[counter1].name + " и у него осталось " + hAA[counter1].weight + " кг веса.");
                        break;
                    } else if (hAA[counter1].weight == resNotEn) {
                        System.arraycopy(hAA, 1 + counter1, hAA, counter1, allHome - 1 - counter1);
                        this.resFarmer += 15;
                        hAA[allHome - 1] = null;
                        allHome = allHome - 1;
                        if (allHome == 0) {
                            System.out.println("На ферме не осталось животных! Вы проиграли!");
                        }
                        break;
                    } else {
                        resNotEn = resNotEn - hAA[counter1].weight;
                        System.arraycopy(hAA, 1 + counter1, hAA, counter1, allHome - 1 - counter1);
                        hAA[allHome - 1] = null;
                        allHome = allHome - 1;
                        if ((allHome == 0) || (hAA[counter1] == null)) {
                            System.out.println("На ферме не осталось животных! Вы проиграли!");
                            break;
                        }
                    }
                } else {
                    counter1 = counter1 + 1;
                    if (hAA[counter1] == null) {
                        System.out.println("На ферме не осталось съедобных животных! Вы проиграли!");
                        break;
                    }
                }
            }
        }
    }
    public void feedHome(Home[] hAA, int hAN){ // Кормление дом. животных
        for (int i = 0; i < hAN; i++) {
            if (hAA[i].name.equals("Корова")) {
                if (hAA[i].getHealth() <= 40) {
                    hAA[i].setHealth(hAA[i].getHealth() + 10);
                } else {
                    hAA[i].setHealth(50);
                }
            }
            if (hAA[i].name.equals("Курица")) {
                if (hAA[i].getHealth() <= 12) {
                    hAA[i].setHealth(hAA[i].getHealth() + 3);
                } else {
                    hAA[i].setHealth(15);
                }
            }
            if (hAA[i].name.equals("Кролик")) {
                if (hAA[i].getHealth() <= 12) {
                    hAA[i].setHealth(hAA[i].getHealth() + 3);
                } else {
                    hAA[i].setHealth(15);
                }
            }
            if (hAA[i].name.equals("Кот")) {
                if (hAA[i].getHealth() <= 8) {
                    hAA[i].setHealth(hAA[i].getHealth() + 2);
                } else {
                    hAA[i].setHealth(10);
                }
            }
        }
    }
    public boolean shooWild(){ // Прогнать дикое. Это делаю функцией с возвратом булевого значения (либо прогнал, либо не прогнал)
        // Реализовываю таким образом потому что в дальнейшем можно регулировать вероятности меняя цифру 30
        boolean shooProb;
        int temp1;
        temp1 = (int) (Math.random() * 100);
        //System.out.println("Цифра рандома для шанс прогнать дикое животное: " + temp1 + ".");
        if (temp1 < 30) {
            shooProb = true;
            System.out.println("Фермер прогнал хищника!");
        }
        else {
            shooProb = false;
            System.out.println("Фермер не прогнал хищника...");
        }
        return shooProb;
    }
}
