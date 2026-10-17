package package1;

public class CountTest {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        counter1.incremrnt();
        counter1.incremrnt();
        counter1.incremrnt();
        counter1.incremrnt();
        counter1.incremrnt();
        counter1.incremrnt();

        System.out.println(counter1.getCount());

        Counter counter2 = new Counter();
        counter2.incremrnt();
        counter2.incremrnt();


        System.out.println(counter2.getCount());

    }
}
