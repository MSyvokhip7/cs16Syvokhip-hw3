package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    MyPredicate myPred;
    private int size;

    public FilterDecorator(SmartArray smartArray, MyPredicate pred) {
        super(smartArray);
        this.myPred = pred;
    }

    @Override
    public Object[] toArray() {
        Object[] myArr = smartArray.toArray();
        Object[] outArr = new Object[myArr.length];
        int index = 0;
        for (int i = 0; i < myArr.length; ++i) {
            if (myPred.test(myArr[i])) {
                outArr[index] = myArr[i];
                index++;
            }
        }
        size = outArr.length;
        return Arrays.copyOf(outArr, index);

    }

    @Override
    public String operationDescription() {
        return "FilterDecorator...";
    }

    @Override
    public int size() {
        return size;
    }
}