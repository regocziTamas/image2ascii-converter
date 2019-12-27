package com.thomaster.image2ascii.pixelmanipulation;

import java.awt.*;

public class ImagePixelMerger {

    private int xFactor;
    private int yFactor;
    private Color[][] originalImage;
    private Color[][] newImage;

    public ImagePixelMerger(int xFactor, int yFactor, Color[][] originalImage) {
        this.xFactor = xFactor;
        this.yFactor = yFactor;
        this.originalImage = originalImage;
        this.newImage = createNewEmptyImage(originalImage);
    }


    private Color[][] createNewEmptyImage(Color[][] originalImage) {
        double width = originalImage[0].length / (double) xFactor;
        double height = originalImage.length / (double) yFactor;

        double newHeight = Math.ceil(height);
        double newWidth = Math.ceil(width);

        return new Color[(int) newHeight][(int)newWidth];
    }


    public Color[][] merge() {
        int newImageX = 0;
        int newImageY = 0;

        for (int i = 0; i < originalImage.length; i+=yFactor) {
            for (int k = 0; k < originalImage[0].length; k+=xFactor) {

                Color newColor = fillNByNPixelsWithAvgColor(i, k);
                newImage[newImageY][newImageX] = newColor;
                newImageX++;
            }
            newImageX = 0;
            newImageY++;
        }

       return newImage;
    }

    private Color fillNByNPixelsWithAvgColor(int startI, int startK) {
        int r = 0;
        int g = 0;
        int b = 0;
        int avgFactor = 0;

        for (int i = 0; i < yFactor; i++) {
            for (int k = 0; k < xFactor; k++) {
                if(startI + i < originalImage.length && startK + k < originalImage[0].length) {

                    Color color = originalImage[startI + i][startK + k];
                    r += color.getRed();
                    g += color.getGreen();
                    b += color.getBlue();
                    avgFactor++;
                }
            }

        }

        return new Color(r / avgFactor, g / avgFactor, b / avgFactor);
    }

}
