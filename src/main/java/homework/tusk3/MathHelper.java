package homework.tusk3;

public class MathHelper {

    // Статичный метод - возвращает сумму
    public static int sum(int a, int b) {
        return a + b;
    }

    // Статичный метод  - возвращает максимум из двух
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    //Статичный метод - возвращает true, если число четное
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {

        // Вызываем три метода через имя класса (не создавая объект)
        int resultSum = MathHelper.sum(10, 5);
        System.out.println("Сумма 10 и 5: " + resultSum);

        int resultMax = MathHelper.max(10, 5);
        System.out.println("Максимум из 10 и 5: " + resultMax);

        boolean rusultEven = MathHelper.isEven(10);
        System.out.println("Число 10 чётное? " + rusultEven);

        boolean rusultEven2 = MathHelper.isEven(5);
        System.out.println("Число 5 чётное? " + rusultEven2);

    }
}

