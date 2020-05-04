package commands;

import Calc.StackMap;
import MyException.NotEnoughItemsException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PushTest {

    @Test
    void command() throws NotEnoughItemsException {
        StackMap sm = new StackMap();
        Push cmd = new Push();
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("5.4");
        cmd.command(arguments, sm);
        assertEquals(5.4, sm.pop());

        ArrayList<String> a = new ArrayList<>();
        assertThrows(NotEnoughItemsException.class, () -> {
            cmd.command(a, sm);
        });
    }
}