package commands;

import Calc.StackMap;
import MyException.NotEnoughItemsException;
import MyException.WrongArgumentAmountException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SubTest {

    @Test
    void command() throws NotEnoughItemsException, WrongArgumentAmountException {
        StackMap sm = new StackMap();
        Sub cmd = new Sub();
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("a");
        for (double i = 0; i < 100; i += 0.1){
            for (double j = 0; j < 100; j += 0.1) {
                sm.push(i);
                sm.push(j);
                cmd.command(null, sm);
                assertEquals(i - j, sm.pop(), 0.001);
            }
        }

        assertThrows(NotEnoughItemsException.class, () -> {
            cmd.command(null, sm);
        });
        assertThrows(WrongArgumentAmountException.class, () -> {
            cmd.command(arguments, sm);
        } );
    }
}