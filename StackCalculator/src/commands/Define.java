package commands;

import Calc.StackMap;
import MyException.NotEnoughItemsException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Define implements ICommand {
    static final Logger LOGGER = Logger.getLogger(Define.class.getName());
    @Override
    public void command(ArrayList<String> argument, StackMap sm) throws NotEnoughItemsException {
        if(argument.size() < 2) {
            LOGGER.log(Level.SEVERE, "NotEnoughItemsException in Define. Insufficient number of elements: " + argument.size());
            throw new NotEnoughItemsException("Insufficient number of elements");
        }
        String key = argument.get(0);
        String strV = argument.get(1);
        double value = Double.parseDouble(strV);
        sm.putInMap(key, value);

    }
}
