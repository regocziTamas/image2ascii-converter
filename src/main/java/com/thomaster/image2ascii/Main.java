package com.thomaster.image2ascii;

import com.thomaster.image2ascii.util.ArrayPrinter;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        char[][] result = new Image2ASCIIConverter()
                .setHorizontalMergeFactor(8)
                .setVerticalMergeFactor(18)
                .convert(new File("shrek.jpg"));

        ArrayPrinter.printCharArray(result);
    }
}
