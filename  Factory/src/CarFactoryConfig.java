import java.io.IOException;
import java.util.Properties;

public class CarFactoryConfig {
    private final String path;
    private int engineStorageCapacity;
    private int bodyStorageCapacity;
    private int accessoryStorageCapacity;
    private int carStorageCapacity;
    private int timeToProductEngine;
    private int timeToProductBody;
    private int accessorySuppliersNumber;
    private int timeToProductAccessory;
    private int workersNumber;
    private int workersTime;
    private int dealersNumber;
    private int dealerTime;

    public CarFactoryConfig(String path) throws IOException {
        this.path = path;
        config();
    }

    private void config() throws IOException {
        Properties properties = new Properties();
        properties.load(CarFactory.class.getResourceAsStream(path));
        this.engineStorageCapacity = Integer.parseInt(properties.getProperty("SgEngineSize"));
        this.bodyStorageCapacity = Integer.parseInt(properties.getProperty("SgBodySize"));
        this.accessoryStorageCapacity = Integer.parseInt(properties.getProperty("SgAccessorySize"));
        this.carStorageCapacity = Integer.parseInt(properties.getProperty("SgCarSize"));
        this.timeToProductEngine = Integer.parseInt(properties.getProperty("EngineProductTime"));
        this.timeToProductBody = Integer.parseInt(properties.getProperty("BodyProductTime"));
        this.accessorySuppliersNumber = Integer.parseInt(properties.getProperty("AccessSuppliers"));
        this.timeToProductAccessory = Integer.parseInt(properties.getProperty("AccessProductTime"));
        this.workersNumber = Integer.parseInt(properties.getProperty("Workers"));
        this.workersTime = Integer.parseInt(properties.getProperty( "WorkersTime"));
        this.dealersNumber = Integer.parseInt(properties.getProperty("Dealers"));
        this.dealerTime = Integer.parseInt(properties.getProperty("DealerTime"));
    }

    public int getAccessoryStorageCapacity() {
        return accessoryStorageCapacity;
    }

    public int getBodyStorageCapacity() {
        return bodyStorageCapacity;
    }

    public int getEngineStorageCapacity() {
        return engineStorageCapacity;
    }

    public int getAccessorySuppliersNumber() {
        return accessorySuppliersNumber;
    }

    public int getCarStorageCapacity() {
        return carStorageCapacity;
    }

    public int getTimeToProductAccessory() {
        return timeToProductAccessory;
    }

    public int getTimeToProductBody() {
        return timeToProductBody;
    }

    public int getTimeToProductEngine() {
        return timeToProductEngine;
    }

    public int getDealersNumber() {
        return dealersNumber;
    }

    public int getDealerTime() {
        return dealerTime;
    }

    public int getWorkersNumber() {
        return workersNumber;
    }

    public int getWorkersTime() {
        return workersTime;
    }
}
