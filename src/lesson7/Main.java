package lesson7;

public class Main {
    public static void main(String[] args) {

        Farm farm = new Farm();
        Forest forest = new Forest();

        forest.fillWild();
        farm.fillHome();
        farm.passDay(forest, 200); // второй аргумент это количество дней

    }
}
