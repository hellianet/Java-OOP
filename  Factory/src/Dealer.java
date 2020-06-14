
public class Dealer extends Thread {
    private final int time;
    private final CarFactory factory;

    public Dealer(CarFactory factory, int time){
        this.time = time;
        this.factory = factory;
    }


    @Override
    public void run(){
        while (!isInterrupted()){
            try {
                Car car = factory.getCar();
                System.out.println("Car №" + car.getId() + " (Engine=" + car.getEngineId() + ", Body=" + car.getBodyId()+ ", Accessory=" + car.getAccessoryId() +")");
                Thread.sleep(time);
            } catch (InterruptedException e) {
                break;
            }

        }
    }
}
