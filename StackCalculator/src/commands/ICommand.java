package commands;

import Calc.StackMap;
import MyException.NotEnoughItemsException;
import MyException.StackIsEmptyException;

public interface ICommand {
    void command(String key, double value, StackMap sm) throws StackIsEmptyException, NotEnoughItemsException;
}
