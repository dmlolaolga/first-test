package package1;

public class Example {
    public String publicField;          // Доступен всем
    protected String protectedField;    // Доступен наследникам и классам в том же пакете
    String defaultField;                // Доступен в том же пакете (без кдючевого слова)
    private String privateField;        // Доступен только в этом классе
}
