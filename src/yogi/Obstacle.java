/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yogi;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

/**
 *
 * @author hossameldin
 */
public class Obstacle extends StableObjects {

    public Obstacle(double xCord, double yCord) throws IOException {
        super(xCord, yCord, Color.RED,"obstacle.png");
    }
    
    @Override
    public void draw(Graphics2D g2){
         g2.drawImage(img, (int)xCord, (int)yCord, null);
    }
    
}
