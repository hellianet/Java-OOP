package commands;

import java.util.Stack;

public class Sqrt implements ICommand {
    @Override
    public void command(Stack<Double> st, double ... var) {
        if (!st.isEmpty()){
            double tmp = st.pop();
            tmp = Math.sqrt(tmp);
            st.push(tmp);
        }
        else{
            System.out.print("Stack is empty");
        }

    }
}
