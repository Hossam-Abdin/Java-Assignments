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
public class YogiCharacter {
    private double xCord;
    private double yCord;
    final private Color color;
    private final Image img;
    
    
    public YogiCharacter() throws IOException {
        this.xCord = 0;
        this.yCord = 0;
        color = Color.BLUE;
        img = ImageIO.read(new File("yogi.png"));

    }
    
    double getXCord(){return xCord;}
    double getYCord(){return yCord;}
    
    public void draw(Graphics2D g2) {
        g2.drawImage(img, (int)xCord, (int)yCord, null);

    }
    
    public void movePosition(int x, int y) {
        this.xCord += x;
        this.yCord += y;
    }
    
    public void setMove(int x, int y){
        this.xCord = x;
        this.yCord = y;
    }
    
    public void move(int width, int height) {
        if (xCord >= width) {
            xCord = 0;
        }
        if (xCord < 0) {
            xCord = width;
        }
        if (yCord >= height) {
            yCord = 0;
        }
        if (yCord < 0) {
            yCord = height;
        }
    }
}
