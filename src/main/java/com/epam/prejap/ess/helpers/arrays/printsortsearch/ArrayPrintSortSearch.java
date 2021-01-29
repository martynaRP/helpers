package com.epam.prejap.ess.helpers.arrays.printsortsearch;

import java.util.Arrays;

class ArrayPrintSortSearch {
//        How to search and sort and print an array,

    public static void main(String[] args) {
        String[] ultimateQuestion = new String[]{"how", "many", "roads", "must", "a", "man", "walk", "down"};
        int[] ints = new int[]{42, 3, 8, 0, 1, 2};
        String[][] deepQuestion = new String[][]{ultimateQuestion, new String[]{"What", "is", "six", "times", "nine"}};

        //printing
        System.out.println("Values in the ultimate question: " + Arrays.toString(ultimateQuestion));
        //deepPrinting
        System.out.println("Values in the deep question via Arrays.toString: " + Arrays.toString(deepQuestion) +
                "\nValues in the deep question via Arrays.deepToString: " + Arrays.deepToString(deepQuestion));

        //Sort must be called before binarySearch called otherwise it will not return the proper value
        System.out.println("Unsorted int array with search called for 2: " + Arrays.binarySearch(ints, 2));

        //sorting
        Arrays.sort(ints);
        Arrays.sort(ultimateQuestion);
        //printing
        System.out.println("Values in the ultimate question after sort`: " + Arrays.toString(ultimateQuestion));

        //searching
        System.out.println("Objects can be searched through using comparator in binarySearch,e.g. \"man\" in the ultimate question: "
                + Arrays.binarySearch(ultimateQuestion, "man", String::compareTo));
        System.out.println("Location of 2 after sort is: " + Arrays.binarySearch(ints, 2));
        System.out.println("If value searched not in array,e.g. 15, is negative value of the length of the array: " + Arrays.binarySearch(ints, 15));
    }
}
