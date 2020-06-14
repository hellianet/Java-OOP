package Details;

public class Engine implements Detail{
    private static int countObject = 0;
    private final int id;
    private final String type = "engine";

    public Engine(){
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
