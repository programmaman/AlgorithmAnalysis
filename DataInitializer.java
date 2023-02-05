package com.usf.compeng;


import java.util.Random;

public class DataInitializer {

    public DataInitializer() {
    }

    private static int[] initializeSortedData(int n) {
        int[] sortedArray = new int[n];

        for (int i = 0; i < n; i++) {
            sortedArray[i] = i;
        }
        return sortedArray;
    }

    private static int[] initializeConstantData(int n) {
        int[] constantArray = new int[n];
        return constantArray;
    }

    private static int[] initializeRandomData(int n) {
        int[] randomArray = new int[n];
        Random randomNum = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = randomNum.nextInt();
        }
        return randomArray;
    }

    public static int[] initializeArray(int n, String c) throws IllegalArgumentException {
        if (c.equals("c")) {
            return initializeConstantData(n);
        }
        if (c.equals("r")) {
            return initializeRandomData(n);
        }
        if (c.equals("s")) {
            return initializeSortedData(n);
        }
        throw new IllegalArgumentException("Please enter c, r or s in argument #3 for constant, random or sorted array respectively.\n" + "Entered '" + c + "'");
    }


}
