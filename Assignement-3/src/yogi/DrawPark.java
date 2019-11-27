/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yogi;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author hossameldin
 */
public class DrawPark extends JPanel{
    private ArrayList<Ranger> rangers;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Basket> baskets;
    private YogiCharacter yogi;
    private final Image backgroundImage;
    private int score;
    private int lives;


    public DrawPark(ArrayList<Ranger> rangers, ArrayList<Obstacle> obstacles, YogiCharacter yogi, ArrayList<Basket> baskets, String fileName) throws IOException {
        this.rangers = rangers;
        this.obstacles = obstacles;
        this.baskets = baskets;
        this.yogi = yogi;
        this.score = 0;
        this.lives = 3;
        backgroundImage = ImageIO.read(new File(fileName));
        this.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                int c=ke.getKeyCode();
                if(c == KeyEvent.VK_W){
                    yogi.movePosition(0, -20);
//                    System.out.println(yogi.getXCord()+" "+ yogi.getYCord());
                }else if(c == KeyEvent.VK_S){
                    yogi.movePosition(0, 20);
//                    System.out.println(yogi.getXCord()+" "+ yogi.getYCord());
                }else if(c == KeyEvent.VK_A){
                    yogi.movePosition(-20, 0);
//                    System.out.println(yogi.getXCord()+" "+ yogi.getYCord());
                }else if(c == KeyEvent.VK_D){
                    yogi.movePosition(20, 0);
//                    System.out.println(yogi.getXCord()+" "+ yogi.getYCord());

                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        ArrayList<Basket> removeBasket = new ArrayList<>();
        super.paintComponent(grphcs);
        grphcs.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        Graphics2D g2 = (Graphics2D) grphcs;
        yogi.draw(g2);
        for (int i = 0; i < rangers.size(); i++) {
            if(i % 2 == 0){
                rangers.get(i).movePosition(rangers.get(i).getSpeed(), 0);
                rangers.get(i).draw(g2);
            }else{
                rangers.get(i).movePosition(0,rangers.get(i).getSpeed());
                rangers.get(i).draw(g2);                
            }
            boolean diff = Math.abs(yogi.getXCord() - rangers.get(i).getXCord()) <= 35 && Math.abs(yogi.getYCord() - rangers.get(i).getYCord()) <= 35;
            if(diff){
                lives--;
                System.out.println("ranger cords " + rangers.get(i).getXCord() + " " + rangers.get(i).getYCord() );
            }
        }
        for(Obstacle obstacle : obstacles){
            obstacle.draw(g2);
        }
        for(Basket basket : baskets){
            if((Math.abs(yogi.getXCord() - basket.getXCord()) >= 25) || Math.abs(yogi.getYCord() - basket.getYCord()) >= 25){
                basket.draw(g2);                
            }else{
                score++;
                removeBasket.add(basket);
            }
        }
        for(Basket basket : removeBasket){
            baskets.remove(basket);
        }
    
    }
    

    public int getScore() {return score;}
    public int getLives() {return lives;}

  
    
    
}
