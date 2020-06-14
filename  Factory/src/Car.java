import Details.Accessory;
import Details.Body;
import Details.Engine;

public class Car {
    private static int carNumbers = 0;
    private Engine engine;
    private Body body;
    private Accessory accessory;
    private final int id;

    public Car(Engine engine, Body body, Accessory accessory){
        carNumbers++;
        this.engine = engine;
        this.body = body;
        this.accessory = accessory;
        this.id = carNumbers;

    }

    public int getEngineId(){
        return engine.getID();
    }

    public int getBodyId(){
        return body.getID();
    }

    public int getId() {
        return id;
    }

    public int getAccessoryId(){ return accessory.getID(); }
}
