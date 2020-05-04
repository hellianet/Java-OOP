package commands;

import Calc.StackMap;
import MyException.StackIsEmptyException;
import MyException.WrongArgumentAmountException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PrintTest {

    @Test
    void command() throws StackIsEmptyException, WrongArgumentAmountException {
        StackMap sm = new StackMap();
        Print cmd = new Print();
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("a");
        for (double i = 0; i < 20; i += 0.1){
            sm.push(i);
            cmd.command(null, sm);
            assertEquals(i, sm.pop(), 0.001);
        }
        assertThrows(WrongArgumentAmountException.class, () -> {
            cmd.command(arguments, sm);
        } );
        assertThrows(StackIsEmptyException.class, () -> {
            cmd.command(null, sm);
        });
    }
}