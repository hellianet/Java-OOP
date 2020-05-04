package commands;

import Calc.StackMap;
import MyException.NotEnoughItemsException;
import MyException.WrongArgumentAmountException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Div implements ICommand {
    static final Logger LOGGER = Logger.getLogger(Div.class.getName());
    @Override
    public void command(ArrayList<String> argument, StackMap sm) throws NotEnoughItemsException, WrongArgumentAmountException {
        if (argument != null && argument.size() != 0){
            LOGGER.log(Level.SEVERE, "NotEnoughItemsException in Div, Wrong argument amount: " + argument.size());
            throw new WrongArgumentAmountException(" Wrong argument amount");
        }
        if(sm.sizeStack() < 2){
            LOGGER.log(Level.SEVERE, "NotEnoughItemsException Div, Insufficient number of elements: " + sm.sizeStack());
            throw new NotEnoughItemsException("Insufficient number of elements");
        }
        double b = sm.pop();
        double a = sm.pop();
        double tmp = a / b;
        sm.push(tmp);

    }
}
