import Details.Accessory;
import Details.Body;
import Details.Engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarFactory {
    private final CarFactoryConfig config;
    private ExecutorService controller;
    private ExecutorService workers;
    private Storage<Engine> engineSg;
    private Storage<Body> bodySg;
    private Storage<Accessory> accessorySg;
    private Storage<Car> carSg;
    private ArrayList<Dealer> dealers;
    private ArrayList<Supplier<Accessory>> accessorySuppliers;
    private Supplier<Engine> engineSupplier;
    private Supplier<Body> bodySupplier;



    public CarFactory(CarFactoryConfig config) throws IOException {
        this.config = config;
        this.engineSg = new Storage<>(config.getEngineStorageCapacity());
        this.bodySg = new Storage<>(config.getBodyStorageCapacity());
        this.accessorySg = new Storage<>(config.getAccessoryStorageCapacity());
        this.carSg = new Storage<>(config.getCarStorageCapacity());
        this.engineSupplier = new Supplier<>(engineSg, Engine.class, config.getTimeToProductEngine());
        this.bodySupplier = new Supplier<>(bodySg, Body.class, config.getTimeToProductBody());
        accessorySuppliers = new ArrayList<>();
        for (int i = 0; i < config.getAccessorySuppliersNumber(); ++i){
            accessorySuppliers.add(new Supplier<>(accessorySg, Accessory.class, config.getTimeToProductAccessory()));
        }
        workers = Executors.newFixedThreadPool(config.getWorkersNumber());
        dealers = new ArrayList<>();
        for (int i = 0; i < config.getDealersNumber(); ++i){
            dealers.add(new Dealer(this, config.getDealerTime()));
        }
        controller = Executors.newSingleThreadExecutor();
    }

    public void run(){
        for (Dealer dealer: dealers){
            dealer.start();
        }
        for (Supplier<Accessory> supplier: accessorySuppliers){
            supplier.start();
        }
        engineSupplier.start();
        bodySupplier.start();
        controller.execute(new Controller(this));
    }

    public void stop(){
        for (Dealer dealer: dealers){
            dealer.interrupt();
        }
        for (Supplier<Accessory> supplier: accessorySuppliers){
            supplier.interrupt();
        }
        engineSupplier.interrupt();
        bodySupplier.interrupt();
        controller.shutdownNow();
        workers.shutdownNow();
    }

    public void makeNewCar(){
        workers.submit(new Worker(this, config.getWorkersTime()));
    }

    public void addCar(Car newCar) throws InterruptedException {
        carSg.add(newCar);
    }

    public Car getCar() throws InterruptedException {
        controller.execute(new Controller(this));
        return carSg.get();
    }

    public int getCarStorageCapacity(){
        return carSg.getCapacity();
    }

    public int getCarStorageSize(){
        return carSg.getSize();
    }

    public Storage<Accessory> getAccessoryStorage() {
        return accessorySg;
    }

    public Storage<Engine> getEngineStorage() {
        return engineSg;
    }

    public Storage<Body> getBodyStorage() {
        return bodySg;
    }
}
