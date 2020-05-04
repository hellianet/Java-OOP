package MyException;

public class WrongArgumentAmountException extends Exception {

    public WrongArgumentAmountException(String message){
        super(message);
    }
}
