package com.thomaster.image2ascii.grayscale;

import java.awt.*;

public class ImageGrayscaler
{
    private Color[][] originalImage;
    private Color[][] grayscaledImage;
    private GrayscaleMethod method;

    public ImageGrayscaler(Color[][] originalImage, GrayscaleMethod method) {
        this.originalImage = originalImage;
        this.grayscaledImage = new Color[originalImage.length][originalImage[0].length];
        this.method = method;
    }


    public Color[][] apply() {
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                Color originalColor = originalImage[i][j];
                grayscaledImage[i][j] = method.calculate(originalColor);
            }
        }

        return grayscaledImage;
    }
}
