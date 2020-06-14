
public class Controller implements Runnable {
    private CarFactory factory;

    public Controller(CarFactory factory) {
        this.factory = factory;
    }


    @Override
    public void run() {
        int cars = factory.getCarStorageSize();
        int storageCapacity = factory.getCarStorageCapacity();
        while ((double)cars / storageCapacity < 0.9){
            factory.makeNewCar();
            ++cars;
        }
    }
}
