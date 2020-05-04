package commands;

import Calc.StackMap;
import MyException.StackIsEmptyException;
import MyException.WrongArgumentAmountException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pop implements ICommand {
    static final Logger LOGGER = Logger.getLogger(Pop.class.getName());
    @Override
    public void command(ArrayList<String> argument, StackMap sm) throws StackIsEmptyException, WrongArgumentAmountException {
        if (argument != null && argument.size() != 0){
            LOGGER.log(Level.SEVERE, "WrongArgumentAmountException in Pop. Wrong argument amount: " + argument.size());
            throw new WrongArgumentAmountException("Wrong argument amount");
        }
        if(sm.isEmpty()){
            LOGGER.log(Level.SEVERE, "StackIsEmptyException in Pop. Stack is empty: " + sm.isEmpty());
            throw new StackIsEmptyException("Stack is empty");
        }
        sm.pop();
    }
}
