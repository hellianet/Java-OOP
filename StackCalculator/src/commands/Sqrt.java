package commands;

import Calc.StackMap;
import MyException.StackIsEmptyException;
import MyException.WrongArgumentAmountException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sqrt implements ICommand {
    static final Logger LOGGER = Logger.getLogger(Sqrt.class.getName());
    @Override
    public void command(ArrayList<String> argument, StackMap sm) throws StackIsEmptyException, WrongArgumentAmountException {
        if (argument != null && argument.size() != 0){
            LOGGER.log(Level.SEVERE, "WrongArgumentAmountException in Sqrt. Wrong argument amount: " + argument.size());
            throw new WrongArgumentAmountException(" Wrong argument amount");
        }
        if(sm.isEmpty()){
            LOGGER.log(Level.SEVERE, "StackIsEmptyException in Sqrt. Stack is empty: " + sm.isEmpty());
            throw new StackIsEmptyException("Stack is empty");
        }
        double tmp = sm.pop();
        tmp = Math.sqrt(tmp);
        sm.push(tmp);
    }
}
