package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    MyFunction myFunc;
    private int size;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.myFunc = func;
    }
    @Override
    public Object[] toArray() {
        Object[] arr = smartArray.toArray();
        for (int i = 0; i < arr.length; ++ i) {
            arr[i] = myFunc.apply(arr[i]);
        }
        size = arr.length;
        return arr;
    }

    @Override
    public String operationDescription() {
        return "MapDecorator...";
    }

    @Override
    public int size() {
        return size;
    }
}
