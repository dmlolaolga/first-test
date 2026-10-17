package homework.tusk2;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    // Конструктор с тремя параметрами (новый способ)
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Конструктор без параметров (нужен для старого способа)
    public Person() {
    }

    // Геттеры и сеттеры
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Метод представления (аналог greet() из прошлого задания)
    public void introduce() {
        System.out.println("Меня зовут " + firstName + " " + lastName + ". Мне " + age + " лет.");
    }

    public static void main(String[] args) {

        System.out.println("=== НОВЫЙ СПОСОБ: через конструктор (одна строка) ===");
        // Создаём 3 объекта в одну строку каждый
        Person person1 = new Person("Иван", "Петров", 25);
        Person person2 = new Person("Мария", "Сидорова", 30);
        Person person3 = new Person("Алексей", "Смирнов", 22);

        person1.introduce();
        person2.introduce();
        person3.introduce();


        System.out.println("\n=== СТАРЫЙ СПОСОБ: через new + сеттеры (закомментирован) ===");
        /*
        //  Старый вариант — создаём пустой объект и заполняем по одному полю
        Person oldPerson1 = new Person();
        oldPerson1.setFirstName("Иван");
        oldPerson1.setLastName("Петров");
        oldPerson1.setAge(25);

        Person oldPerson2 = new Person();
        oldPerson2.setFirstName("Мария");
        oldPerson2.setLastName("Сидорова");
        oldPerson2.setAge(30);

        Person oldPerson3 = new Person();
        oldPerson3.setFirstName("Алексей");
        oldPerson3.setLastName("Смирнов");
        oldPerson3.setAge(22);

        oldPerson1.introduce();
        oldPerson2.introduce();
        oldPerson3.introduce();
        */
    }
}
