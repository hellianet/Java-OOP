import java.util.LinkedList;

public class Storage<T>{
    private final int capacity;
    private LinkedList<T> data;

    public Storage(int capacity){
        this.data = new LinkedList<>();
        this.capacity = capacity;
    }

    public T get() throws InterruptedException {
        synchronized (this){
            while (data.size() <= 0){
                this.wait();
            }
            T detail = data.pop();
            notify();
            return detail;
        }
    }

    public void add(T object) throws InterruptedException {
        synchronized (this){
            if (data.size() >= capacity){
                this.wait();
            }
            data.add(object);
            notify();
        }
    }


    public  int getCapacity() {
        return capacity;
    }

    public synchronized int getSize(){
        return data.size();
    }

}
