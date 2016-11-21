package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{
    private int size;

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        Object[] myArr = smartArray.toArray();
        Object[] outArr = new Object[myArr.length];
        System.out.println(operationDescription());
        int index = 0;
        for (int i = 0; i < myArr.length; i++) {
            for (int j = i + 1; j < myArr.length; j++) {
                if (myArr[i].toString().equals(myArr[j].toString())) {
                    break;
                }
                if (j == myArr.length - 1) {
                    outArr[index] = myArr[i];
                    index++;
                }
            }
        }
        outArr[index] = myArr[myArr.length - 1];
        index++;
        size = outArr.length;
        return Arrays.copyOf(outArr, index);
    }

    @Override
    public String operationDescription() {
        return "DistinctDecorator...";
    }

    @Override
    public int size() {
        return size;
    }

}
