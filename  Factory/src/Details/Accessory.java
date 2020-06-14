package Details;

public class Accessory implements Detail {
    private static int countObject = 0;
    private final int id;
    private final String type = "accessory";

    public Accessory(){
        countObject++;
        id = countObject;
    }

    public String getType() {
        return type;
    }

    @Override
    public int getID() {
        return id;
    }
}
