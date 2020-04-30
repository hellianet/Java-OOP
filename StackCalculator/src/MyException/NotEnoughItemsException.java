package MyException;

public class NotEnoughItemsException extends Exception{

    public NotEnoughItemsException(String message){
        super(message);
    }
}
