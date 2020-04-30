package commands;

import Calc.StackMap;

public class Define implements ICommand {
    @Override
    public void command(String key, double value, StackMap sm) {
        sm.putInMap(key,value);
    }
}
