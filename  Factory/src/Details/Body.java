package Details;


public class Body implements Detail{

    private static int countObjects = 0;
    private final int id;
    private final String type = "body";

    public Body(){
        countObjects++;
        id = countObjects;
    }

    public String getType() {
        return type;
    }

    @Override
    public int getID() {
        return id;
    }
}
