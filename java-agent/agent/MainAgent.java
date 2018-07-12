import java.lang.instrument.Instrumentation;

public class MainAgent {
    public static void premain(String args, Instrumentation inst) {
        System.out.println("Hello from agent.");
    }
}
