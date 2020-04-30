package Calc;

import java.util.HashMap;
import java.util.Stack;

public class StackMap{
    private Stack<Double> st;
    private HashMap<String,Double> myMap;
    public StackMap(){
        st = new Stack<>();
        myMap = new HashMap<>();
    }

    public void putInMap(String key,Double value){
        myMap.put(key, value);
    }

    public double getValue(String key){
        return myMap.get(key);
    }

    public boolean keyIsRight(String key){
        return myMap.containsKey(key);
    }

    public double peek(){
        return st.peek();
    }

    public void push(double x){
        st.push(x);
    }

    public double pop(){
        return st.pop();
    }

    public boolean isEmpty(){
        return st.isEmpty();
    }

    public int sizeStack(){
        return st.size();
    }

}
