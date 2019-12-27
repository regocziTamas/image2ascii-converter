package com.thomaster.image2ascii;

import com.thomaster.image2ascii.asciiconverter.ASCIIConverter;
import com.thomaster.image2ascii.asciiconverter.DefaultASCIIConverter;
import com.thomaster.image2ascii.grayscale.GrayscaleCustomNumShades;
import com.thomaster.image2ascii.grayscale.GrayscaleMethod;
import com.thomaster.image2ascii.grayscale.ImageGrayscaler;
import com.thomaster.image2ascii.pixelmanipulation.ImagePixelMerger;
import com.thomaster.image2ascii.util.Image2PixelArray;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Image2ASCIIConverter {

    private char[] customCharacterSet;
    private int customNumOfGrayShades = 0;
    private ASCIIConverter asciiConverter;
    private GrayscaleMethod grayscaleMethod;
    private int horizontalMergeFactor = 0;
    private int verticalMergeFactor = 0;

    public Image2ASCIIConverter useCustomCharaterSetWithDefaultConverter(char[] customCharacterSet) {
        this.customCharacterSet = customCharacterSet;
        return this;
    }


    public Image2ASCIIConverter useCustomNumOfGrayShadesWithDefaultGrayscaler(int customNumOfGrayShades) {
        this.customNumOfGrayShades = customNumOfGrayShades;
        return this;
    }

    public Image2ASCIIConverter setAsciiConverter(ASCIIConverter asciiConverter) {
        this.asciiConverter = asciiConverter;
        return this;
    }


    public Image2ASCIIConverter setGrayscaleMethod(GrayscaleMethod grayscaleMethod) {
        this.grayscaleMethod = grayscaleMethod;
        return this;
    }


    public Image2ASCIIConverter setHorizontalMergeFactor(int horizontalMergeFactor) {
        this.horizontalMergeFactor = horizontalMergeFactor;
        return this;
    }


    public Image2ASCIIConverter setVerticalMergeFactor(int verticalMergeFactor) {
        this.verticalMergeFactor = verticalMergeFactor;
        return this;
    }


    public char[][] convert(File imageFileToExport) throws IOException {
        Color[][] imageAsArray = new Image2PixelArray(imageFileToExport).convert();

        Color[][] pixelatedImage = new ImagePixelMerger(getHorizontalMergeFactor(), getVerticalMergeFactor(),  imageAsArray).merge();

        Color[][] grayscaledImage = new ImageGrayscaler(pixelatedImage, getGrayscaleMethodOrCreateDefault()).apply();

        if (!isGrayscaleImage(grayscaledImage))
            throw new RuntimeException("Image grayscale did not succeed, image is not grayscale.");

        if (!areMergeFactorsValid())
            throw new RuntimeException("Both merge factors have to be greater than or equal to 1.");

        return getAsciiConverterOrCreateDefault().convert(grayscaledImage);
    }


    private GrayscaleMethod getGrayscaleMethodOrCreateDefault() {
        if (grayscaleMethod != null)
            return grayscaleMethod;

        return new GrayscaleCustomNumShades(customNumOfGrayShades != 0 ? customNumOfGrayShades : 32);
    }


    private ASCIIConverter getAsciiConverterOrCreateDefault() {
        if(asciiConverter != null)
            return asciiConverter;

        return new DefaultASCIIConverter(customCharacterSet != null ? customCharacterSet : new char[]{'W', 'M','@','N', '+', ',', '.', ' '});
    }


    private int getHorizontalMergeFactor() {
        return horizontalMergeFactor != 0 ? horizontalMergeFactor : 2;
    }


    private int getVerticalMergeFactor() {
        return verticalMergeFactor != 0 ? verticalMergeFactor : 4;
    }


    private boolean areMergeFactorsValid() {
        return horizontalMergeFactor > 0 && verticalMergeFactor > 0;
    }


    private boolean isGrayscaleImage(Color[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                Color color = array[i][j];
                if(!(color.getRed() == color.getGreen() && color.getGreen() == color.getBlue()))
                    return false;
            }
        }

        return true;
    }
}
