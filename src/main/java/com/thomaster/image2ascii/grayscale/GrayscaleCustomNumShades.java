package com.thomaster.image2ascii.grayscale;

import java.awt.*;

public class GrayscaleCustomNumShades implements GrayscaleMethod {

    private int conversionFactor;

    public GrayscaleCustomNumShades(int numberOfGrayShades) {

        if(numberOfGrayShades > 256 || numberOfGrayShades < 2)
            throw new IllegalArgumentException("Number of gray shades should be between 2 and 256");

        this.conversionFactor = 255 / (numberOfGrayShades - 1);
    }

    public Color calculate(Color originalColor) {
        int avgOfColors = (originalColor.getRed() + originalColor.getBlue() + originalColor.getGreen()) / 3;
        int x = avgOfColors / conversionFactor;
        int gray = x * conversionFactor;
        return new Color(gray, gray, gray);
    }
}
