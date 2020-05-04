package Calc;

import java.io.InputStream;
import java.util.Scanner;

public class Parser {

    private Scanner scan;
    public Parser(InputStream file) {
        scan = new Scanner(file);
    }


    public boolean hasLine(){
        return scan.hasNextLine();
    }

    public String[] parseStr() {
            String str = scan.nextLine();
            String[] words = str.split(" ");
            return words;

    }
}
