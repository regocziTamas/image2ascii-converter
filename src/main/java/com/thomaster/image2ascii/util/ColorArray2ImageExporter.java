package com.thomaster.image2ascii.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ColorArray2ImageExporter {

    private Color[][] colorArray;
    private String path;

    public ColorArray2ImageExporter(Color[][] colorArray, String path) {
        this.colorArray = colorArray;
        this.path = path;
    }


    public void export(String format) throws IOException {
        BufferedImage image = new BufferedImage(colorArray[0].length, colorArray.length, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < colorArray[0].length; y++) {
            for (int x = 0; x < colorArray.length; x++) {
                image.setRGB(y, x, colorArray[x][y].getRGB());
            }
        }
        
        ImageIO.write(image, format,  new File(path));
    }
}
