package commands;

import Calc.StackMap;
import MyException.StackIsEmptyException;

public class Pop implements ICommand {
    @Override
    public void command(String key, double value, StackMap sm) throws StackIsEmptyException {
        if(!sm.isEmpty()){
            sm.pop();
        }
        else {
            throw new StackIsEmptyException("Stack is empty");
        }
    }
}
