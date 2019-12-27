package com.thomaster.image2ascii;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        char[][] result = new Image2ASCIIConverter()
                .setHorizontalMergeFactor(8)
                .setVerticalMergeFactor(18)
                .convert(new File("shrek.jpg"));

        printCharArray(result);
    }

    private static void printCharArray(char[][] charArray)
    {
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[0].length; j++) {
                System.out.print(charArray[i][j]);
            }
            System.out.println();
        }
    }

    private static void printColorArray(Color[][] colorArray)
    {
        for (int i = 0; i < colorArray.length; i++) {
            for (int j = 0; j < colorArray[0].length; j++) {
                System.out.print(colorArray[i][j]);
            }
            System.out.println();
        }
    }
}
