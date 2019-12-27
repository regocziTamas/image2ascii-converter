package com.thomaster.image2ascii.grayscale;

import com.thomaster.image2ascii.grayscale.GrayscaleMethod;

import java.awt.*;

public class SimpleGrayscale implements GrayscaleMethod {

    public Color calculate(Color originalColor) {
        int avgOfColors = (originalColor.getRed() + originalColor.getBlue() + originalColor.getGreen()) / 3;
        return new Color(avgOfColors, avgOfColors, avgOfColors);
    }
}
