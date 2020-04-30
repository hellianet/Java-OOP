package commands;

import Calc.StackMap;

public class Push implements ICommand {
    @Override
    public void command(String key, double value, StackMap sm) {

        if(sm.keyIsRight(key)){
            sm.push(sm.getValue(key));
        }
        else sm.push(value);
    }
}
