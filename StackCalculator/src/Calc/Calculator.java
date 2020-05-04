package Calc;

import MyException.NotEnoughItemsException;
import MyException.StackIsEmptyException;
import MyException.WrongArgumentAmountException;
import MyException.WrongCommandNameException;
import commands.ICommand;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Calculator{
    
    static final Logger LOGGER = Logger.getLogger(Calculator.class.getName());

    private Parser pr;
    private StackMap sm;

    public Calculator(InputStream file) throws WrongCommandNameException {
        pr = new Parser(file);
        sm = new StackMap();
    }

    public void calculate() throws IOException, IllegalAccessException, WrongCommandNameException, InstantiationException, StackIsEmptyException, NotEnoughItemsException, WrongArgumentAmountException {
        Factory f;
        try {
           f = Factory.getInstance();
       } catch (IOException e) {
           LOGGER.log(Level.SEVERE, "IOException in calculate");
           throw e;
       }
        while(pr.hasLine()){
            String[] str = pr.parseStr();
            String command = str[0];
            ICommand com;
            try {
                com = f.getCommand(command);
            } catch (WrongCommandNameException | IllegalAccessException | InstantiationException e) {
                LOGGER.log(Level.SEVERE, "WrongCommandNameException, IllegalAccessException, InstantiationException in calculate");
                throw e;
            }
            ArrayList<String> arguments = new ArrayList<>();
            for(int i = 1; i < str.length; ++i) {
                arguments.add(str[i]);
            }
            try {
                com.command(arguments, sm);
            } catch (StackIsEmptyException | NotEnoughItemsException | WrongArgumentAmountException e) {
                LOGGER.log(Level.SEVERE, "StackIsEmptyException, NotEnoughItemsException, WrongArgumentAmountException in calculate");
                throw e;
            }

        }
    }

}
