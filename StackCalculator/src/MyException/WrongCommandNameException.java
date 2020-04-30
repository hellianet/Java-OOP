package MyException;

public class WrongCommandNameException extends Exception{

    public WrongCommandNameException(String message){
        super(message);
    }
}
