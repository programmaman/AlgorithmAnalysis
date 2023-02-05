package com.usf.compeng;

public class Sorter {


    public Sorter() {}

    private void selectionSort(int[] integerArray) {
        int minIndex;

        for (int i = 0; i < integerArray.length; i++) {
            minIndex = i;

            //Update minimum value Index
            for (int j = i + 1; j < integerArray.length; j++) {
                if (integerArray[j] < integerArray[minIndex]) {
                    minIndex = j;
                }
            }
            //Swap Min Value to the Index i
            if (minIndex != i) {
                swap(integerArray, i, minIndex);
            }
        }
    }

    private void insertionSort(int[] integerArray) {
        int key;

        //Update Key (n)
        for (int i = 1; i < integerArray.length; i++) {
            key = integerArray[i];
            int j = i - 1;

            //Compare and Sort
            while (j >= 0 && integerArray[j] > key) {
                integerArray[j + 1] = integerArray[j];
                j = j - 1;
            }
            integerArray[j + 1] = key;
        }
    }

    private int quickSortMedianPivot(int[] integerArray, int low, int high) {

        int middle = ((low + high) / 2);

        if (integerArray[middle] < integerArray[low]) {
            swap(integerArray, middle, low);
        }
        if (integerArray[high] < integerArray[low]) {
            swap(integerArray, high, low);
        }
        if (integerArray[middle] < integerArray[high])
            swap(integerArray, high, middle);

        return integerArray[high];
    }

    private int partition(int[] integerArray, int low, int high) {
        int pivot = quickSortMedianPivot(integerArray, low, high);
        int index = (low - 1);

        //Compare to pivot and sort
        for (int j = low; j <= high - 1; j++) {
            if (integerArray[j] <= pivot) {
                index++;
                swap(integerArray, index, j);
            }
        }

        swap(integerArray, index + 1, high);
        return (index + 1);
    }

    private void quickSort(int[] array, int low, int high) {
//        !This was causing stack overflow errors on constant array sorting.!//
//        !Updated the code to recurse smaller splits first.!//

//        if (low < high) {
//            int pivotIndex = partition(array, low, high);
//            quickSort(array, low, pivotIndex - 1);
//            quickSort(array, pivotIndex + 1, high);
//        }

        while(low < high)
        {
            int pivotIndex = partition(array, low, high);

            //Sort the smallest split recursively
            if(pivotIndex - low < high - pivotIndex){
               quickSort(array, low, pivotIndex - 1);
               low = pivotIndex + 1;
            }
            else
            {
                quickSort(array, pivotIndex + 1, high);
                high = pivotIndex - 1;
            }
        }


    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public void sort(String sortCode, int[] array) throws IllegalArgumentException {

        if (sortCode.equals("i")) {
            long startTime = System.nanoTime();
            System.out.println("Called Insertion Sort: ");

            insertionSort(array);

            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            System.out.println("Execution Time: " + executionTime + " ns");
            return;

        }
        if (sortCode.equals("s")) {
            long startTime = System.nanoTime();
            System.out.println("Called Selection Sort: ");

            selectionSort(array);

            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            System.out.println("Execution Time: " + executionTime + " ns");
            return;
        }
        if (sortCode.equals("q")) {
            long startTime = System.nanoTime();
            System.out.println("Called Quick Sort: ");

            quickSort(array, 0, array.length - 1);

            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            System.out.println("Execution Time: " + executionTime + " ns");
            return;
        }
            throw new IllegalArgumentException("Please make sure to enter a sorting algorithm code i, s or q for Insertion, Selection and Quick Sort respectively.\n" + "Entered '" + sortCode + "'");
    }

    public static boolean checkSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]) {
                System.out.println("Array not sorted properly.");
                return false;
            }
        }
        System.out.println("Array sorted correctly.");
        return true;
    }

}


