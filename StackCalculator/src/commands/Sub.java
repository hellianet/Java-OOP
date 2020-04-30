package commands;

import Calc.StackMap;
import MyException.NotEnoughItemsException;

public class Sub implements ICommand {
    @Override
    public void command(String key, double value, StackMap sm) throws NotEnoughItemsException {
        if(sm.sizeStack() >= 2){
            double b = sm.pop();
            double a = sm.pop();
            double tmp = a - b;
            sm.push(tmp);
        }
        else{
            throw new NotEnoughItemsException("Insufficient number of elements");
        }

    }
}
