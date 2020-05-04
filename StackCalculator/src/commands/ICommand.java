package commands;

import Calc.StackMap;
import MyException.NotEnoughItemsException;
import MyException.StackIsEmptyException;
import MyException.WrongArgumentAmountException;

import java.util.ArrayList;

public interface ICommand {
    void command(ArrayList<String> argument, StackMap sm) throws StackIsEmptyException, NotEnoughItemsException, WrongArgumentAmountException;
}
