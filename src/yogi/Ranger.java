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
public class Ranger {
    private double xCord;
    private double yCord;
    private final Image img;
    private final int speed;
            
    public Ranger(double xCord, double yCord, int speed) throws IOException {
        this.xCord = xCord;
        this.yCord = yCord;
        this.speed = speed;
        this.img = ImageIO.read(new File("ranger.png"));

    }


    
    double getXCord(){return xCord;}
    double getYCord(){return yCord;}
    int getSpeed(){return speed;}
    
    public void draw(Graphics2D g2) {
        g2.drawImage(img, (int)xCord, (int)yCord, null);

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
    
    public void movePosition(int x, int y) {
        this.xCord += x;
        this.yCord += y;
    }
    
}
