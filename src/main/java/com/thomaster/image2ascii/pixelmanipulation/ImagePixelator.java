package com.thomaster.image2ascii.pixelmanipulation;

import java.awt.Color;

public class ImagePixelator {

    private int factor;
    private int avgFactor;
    private Color[][] originalImage;
    private Color[][] newImage;

    public ImagePixelator(int factor, Color[][] originalImage) {
        this.factor = factor;
        this.avgFactor = factor * factor;
        this.originalImage = originalImage;
        this.newImage = new Color[originalImage.length][originalImage[0].length];
    }


    public Color[][] pixelate() {
        for (int i = 0; i < originalImage.length; i+=factor) {
            for (int k = 0; k < originalImage[0].length; k+=factor) {

                fillNByNPixelsWithAvgColor(i, k);
            }
        }

       return newImage;
    }


    private void fillNByNPixelsWithAvgColor(int startI, int startK) {
        int r = 0;
        int g = 0;
        int b = 0;

        for (int i = 0; i < factor; i++) {
            for (int k = 0; k < factor; k++) {
                if(startI + i < originalImage.length && startK + k < originalImage[0].length) {

                    Color color = originalImage[startI + i][startK + k];
                    r += color.getRed();
                    g += color.getGreen();
                    b += color.getBlue();
                }
            }
        }

        Color newColor = new Color(r / avgFactor, g / avgFactor, b / avgFactor);

        for (int i = 0; i < factor; i++) {
            for (int k = 0; k < factor; k++) {
                if(startI + i < newImage.length && startK + k < newImage[0].length) {
                   newImage[startI + i][startK + k] = newColor;
                }
            }
        }
    }
}
