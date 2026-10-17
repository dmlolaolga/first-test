package homework.tusk4;

public class Visitor {
    private static int totalVisitors = 0;

    public Visitor() {
        totalVisitors++;
    }

    public static int getTotalVisitors() {

        return totalVisitors;
    }

    public static void main(String[] args) {

        Visitor visitor1 = new Visitor();
        System.out.println("Создан посетитель 1. Всего посетителей:" + visitor1.getTotalVisitors());

        Visitor visitor2 = new Visitor();
        System.out.println("Создан посетитель 2. Всего посетителей:" + visitor2.getTotalVisitors());

        Visitor visitor3 = new Visitor();
        System.out.println("Создан посетитель 3. Всего посетителей:" + visitor3.getTotalVisitors());

        Visitor visitor4 = new Visitor();
        System.out.println("Создан посетитель 4. Всего посетителей:" + visitor4.getTotalVisitors());

        Visitor visitor5 = new Visitor();
        System.out.println("Создан посетитель 5. Всего посетителей:" + visitor5.getTotalVisitors());
    }
}
