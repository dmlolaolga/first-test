package package2;

import package1.Example;

public class GetExampleAnotherPackage extends Example {
    void test() {
        Example example = new Example();
        System.out.println(protectedField);
    }
}
