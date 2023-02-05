package com.usf.compeng;

public class Main {

    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("Please enter arguments: sort algorithm, number of elements, and array format. \n i.e 'i 10000 r' ");
        }

        String sort = args[0];
        int n = parseIntArg(args[1]);
        String arrayFormat = args[2];

        Sorter sorter = new Sorter();
        int[] array = DataInitializer.initializeArray(n, arrayFormat);
        sorter.sort(sort, array);
        Sorter.checkSort(array);
    }

    private static int parseIntArg(String argument){
        try {
            int arg = Integer.parseInt(argument);
            return arg;
        }
        catch(NumberFormatException e) {
            System.err.println("Argument" + argument + " must be an integer.");
            System.exit(1);
            return -1;
        }
    }
}
