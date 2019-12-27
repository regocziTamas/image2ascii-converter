package com.thomaster.image2ascii.util;

public class ArrayPrinter {

    public static void printCharArray(char[][] charArray) {
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[0].length; j++) {
                System.out.print(charArray[i][j]);
            }
            System.out.println();
        }
    }

    public static <T> void printGenericArray(T[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
