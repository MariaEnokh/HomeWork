package HomeWork2;

public class Main {
    public static void main(String[] args) {

    }


        static boolean do3 ( int a, int b){
            int sum = a + b;
            if (sum > 10 && sum < 20) return true;
            else return false;
        }

        static void do4 ( int a){
            if (a >= 0) System.out.println(a + "положительное");
            else System.out.println(a + "отрицательное");
        }

        static boolean do5 ( int a){
            if (a < 0) return true;
            return false;
        }

        static boolean doYear ( int year){
            return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        }

}







