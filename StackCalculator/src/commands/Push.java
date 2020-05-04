package commands;

import Calc.StackMap;
import MyException.NotEnoughItemsException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Push implements ICommand {
    static final Logger LOGGER = Logger.getLogger(Push.class.getName());
    @Override
    public void command(ArrayList<String> argument, StackMap sm) throws NotEnoughItemsException {
        if(argument.size() == 1) {
            if (sm.keyIsRight(argument.get(0))) {
                sm.push(sm.getValue(argument.get(0)));
            } else sm.push(Double.parseDouble(argument.get(0)));
        }
        else{
            LOGGER.log(Level.SEVERE, "NotEnoughItemsException in Push. Insufficient number of elements: " + argument.size());
            throw new NotEnoughItemsException("Insufficient number of elements");
        }
    }
}
