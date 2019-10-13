package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
        args = new String[2];
        args[0] = "why why why";
        args[1] = "err no no";

        System.out.println(args[0]);
        System.out.println(args[1]);
    }
}