package ru.gb.Bootcamp.Algorithms.Armstrong;

public class ArrayAlgorithm {
    private final Logger logger = new Logger();

    public void arrayCalculateWithMatrix(int max){
        int[] array = new int[Util.length(max)];

        do{
            // ---------- 1:14:00 ---------------
        } while ((array = increment(array, array.length - 1)) != null);

    }

    private int[] increment(int[] array, int index){
        int value = array[index];
        if(value<9){
            array[index] = value + 1;
            return array;
        } else {
            if(index > 0){
                int[] result = increment(array, index - 1);
                if(result != null){
                    result[index] = result[index - 1];
                }
                return result;
            } else {
                return null;
            }
        }
    }
}
