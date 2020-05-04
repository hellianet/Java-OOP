package commands;

import Calc.StackMap;
import MyException.NotEnoughItemsException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefineTest {

    @Test
    void command() throws NotEnoughItemsException {
        ArrayList<String> argument = new ArrayList<>();
        Define cmd = new Define();
        StackMap sm = new StackMap();
        argument.add("a");
        argument.add("4.0");
        cmd.command(argument,sm);
        assertEquals(4.0,sm.getValue(argument.get(0)));
        ArrayList<String> a = new ArrayList<>();
        assertThrows(NotEnoughItemsException.class, () -> {
            cmd.command(a, sm);
        });

    }
}