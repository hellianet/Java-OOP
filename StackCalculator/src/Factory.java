import MyException.WrongCommandNameException;
import commands.ICommand;

import java.io.IOException;
import java.util.Properties;

public class Factory {

    private static volatile Factory instance;
    private Properties p;

    private Factory() throws IOException {
        Properties prop = new Properties();
        prop.load(Factory.class.getResourceAsStream("resources/commands"));
        p = prop;
    }

    public ICommand getCommand(String cmdName) throws WrongCommandNameException, IllegalAccessException, InstantiationException {
        if(!p.containsKey(cmdName)){
            throw new WrongCommandNameException("Wrong name: " + cmdName);
        }
        Class com;
        try {
            com = Class.forName(p.getProperty(cmdName));
        } catch (ClassNotFoundException e) {
            throw new WrongCommandNameException("Wrong name: " + cmdName);
        }
        return (ICommand) com.newInstance();


    }

    public static Factory getInstance() throws IOException {
        Factory localInstance = instance;
        if (localInstance == null) {
            synchronized (Factory.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Factory();
                }
            }
        }
        return localInstance;
    }


}
