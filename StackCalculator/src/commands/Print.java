package commands;

import Calc.StackMap;
import MyException.StackIsEmptyException;

public class Print implements ICommand {
    @Override
    public void command(String key, double value, StackMap sm) throws StackIsEmptyException {
        if(!sm.isEmpty()){
            double tmp = sm.peek();
            System.out.println(tmp);
        }
        else{
            throw new StackIsEmptyException("Stack is empty");
        }
    }
}
