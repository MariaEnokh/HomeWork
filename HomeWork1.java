sepackage ru.geekbrains.lesson1;

public class HomeWork1 {
    public static void main(String[] args) {
        checkSumSign();
        printThreeWords();
        printColor();
        compareNumbers();
    }

    static void printThreeWords() {
        System.out.print("_Orange\n" +
                "_ Banana\n" +
                "_ Apple\n");
    }

    static void checkSumSign() {
        int a = 5;
        int b = 6;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("число положительное");

        } else {
            System.out.println("число отрицательное");
        }
    }

    static void printColor() {
        int value = 45;
        if (value <= 0) {
            System.out.println("Красный");
        }
        else if (value <= 100) {
            System.out.println("Желтый");
        }
        else if (value > 100) {
            System.out.println("Зеленый");
        }

    }

    static void compareNumbers() {
        int a = 23;
        int b = 16;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");


        }

    }
}



