package com.thomaster.image2ascii.asciiconverter;

import java.awt.*;

public class DefaultASCIIConverter implements ASCIIConverter
{
    private char[] charaterSet;

    public DefaultASCIIConverter(char[] charaterSet) {
        this.charaterSet = charaterSet;
    }

    public char[][] convert(Color[][] originalImage) {
        char[][] resultImage = new char[originalImage.length][originalImage[0].length];

        double conversionFactor = 255 / (charaterSet.length - 1);

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                int color = originalImage[i][j].getRed();
                int charNum = (int) (color / conversionFactor);
                resultImage[i][j] = charaterSet[charNum];
            }
        }
        return resultImage;
    }
}
