import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CarFactoryConfig config = new CarFactoryConfig("config.cfg");
        CarFactory factory = new CarFactory(config);
        factory.run();
        System.in.read();
        factory.stop();
    }
}
