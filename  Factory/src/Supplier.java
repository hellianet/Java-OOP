
public class Supplier<T> extends Thread{
    private long time;
    private Storage<T> storage;
    private Class<T> maker;

    public Supplier(Storage<T> storage, Class<T> maker, long time){
        this.storage = storage;
        this.maker = maker;
        this.time = time;
    }

    @Override
    public void run(){
        while (!isInterrupted()){
            try {
                storage.add(maker.getDeclaredConstructor().newInstance());
                Thread.sleep(time);
            } catch (InterruptedException e) {
               break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
