import Details.Accessory;
import Details.Body;
import Details.Engine;

public class Worker implements Runnable {
    private CarFactory factory;
    private final int time;

    public Worker(CarFactory carFactory, int time){
        factory = carFactory;
        this.time = time;
    }

    @Override
    public void run(){
        try {
            Engine engine = factory.getEngineStorage().get();
            Body body = factory.getBodyStorage().get();
            Accessory accessory = factory.getAccessoryStorage().get();
            Thread.sleep(this.time);
            Car newCar = new Car(engine, body, accessory);
            factory.addCar(newCar);
        } catch (InterruptedException ignored){
        }

    }
}
