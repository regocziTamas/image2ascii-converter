package com.thomaster.image2ascii.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image2PixelArray {

    private File imageFile;

    public Image2PixelArray(File imageFile) {
        this.imageFile = imageFile;
    }

    public Color[][] convert() throws IOException {
        BufferedImage bufferedImage = ImageIO.read(imageFile);

        Color[][] array = new Color[bufferedImage.getHeight()][bufferedImage.getWidth()];

        for (int i = 0; i < bufferedImage.getHeight(); i++)
        {
            for (int k = 0; k < bufferedImage.getWidth(); k++)
            {
                array[i][k] = new Color(bufferedImage.getRGB(k,i));
            }
        }

        return array;
    }
}
