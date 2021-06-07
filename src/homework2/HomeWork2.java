package homework2;

public class HomeWork2 {
    public static void main(String[] args) {
        System.out.println(checkSum(5, 7));
        checkValue(-5);
        System.out.println(checkValue2(3));
        printCount("Hello!!!", 3);
        System.out.println(highYears(1916));

    }

    public static boolean checkSum(int a, int b) {

        int c = a + b;
        if (c < 10) {
            return false;
        } else return c < 20;
    }

    public static void checkValue(int a) {

        if (a < 0) {
            System.out.println("Отрицательное число");
        } else {
            System.out.println("Положительное число");
        }
    }

    public  static boolean checkValue2(int a) {
        return a < 0;
    }

    public static void printCount(String newLine, int counter) {
        for (int i = 0; i < counter; i++) System.out.println(newLine);

    }

    public static boolean highYears(int year) {

        if (year % 400 == 0) {
            return true;
        } else return (year % 100 != 0) && (year % 4 == 0);
    }


}

