package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private final MyComparator myComp;

    public SortDecorator(SmartArray smartArray, MyComparator comp){
        super(smartArray);
        this.myComp = comp;
    }

    @Override
    public Object[] toArray() {
        Object[] outArr = smartArray.toArray();
        Arrays.sort(outArr, myComp);
        return outArr;
    }

    @Override
    public String operationDescription() {
        return "SortDecorator...";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
