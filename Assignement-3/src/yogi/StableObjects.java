/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yogi;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author hossameldin
 */
public class StableObjects {
    protected double xCord;
    protected double yCord;
    protected Color color;
    protected final Image img;

    
    public StableObjects(double xCord, double yCord, Color color, String imgName) throws IOException {
        this.xCord = xCord;
        this.yCord = yCord;
        this.color = color;
        this.img = ImageIO.read(new File(imgName));
    }


    
    double getXCord(){return xCord;}
    double getYCord(){return yCord;}
    
    public void draw(Graphics2D g2){};
}
