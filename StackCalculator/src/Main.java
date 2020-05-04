import Calc.Calculator;
import MyException.NotEnoughItemsException;
import MyException.StackIsEmptyException;
import MyException.WrongArgumentAmountException;
import MyException.WrongCommandNameException;

import java.io.*;
import java.util.logging.LogManager;

public class Main {

    public static void main(String[] args) throws WrongCommandNameException, IOException, StackIsEmptyException, InstantiationException, IllegalAccessException, NotEnoughItemsException, WrongArgumentAmountException {
        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("ConfigLogger.txt"));
        InputStream  a =  System.in;
        if(args.length == 1){
            a = Main.class.getResourceAsStream(args[0]);
        }
        Calculator cl = new Calculator(a);
        cl.calculate();
    }
}
