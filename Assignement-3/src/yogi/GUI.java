/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yogi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author hossameldin
 */
public class GUI {
    private JFrame frame;
    private DrawPark drawPark;
    private Score score;
    private ArrayList<Ranger> rangers;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Basket> baskets;
    private YogiCharacter yogi;
    private final Timer timer;
    public boolean isWin = false;


    public GUI(String fileName) throws IOException{
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        rangers = new ArrayList<>();
        obstacles = new ArrayList<>();
        baskets = new ArrayList<>();
        int countRangers = sc.nextInt();
//        System.out.println(countRangers);
        for(int i = 0; i < countRangers; i++){
            rangers.add(new Ranger(sc.nextInt(),sc.nextInt(),sc.nextInt()));            
        }
        int countObstacles = sc.nextInt();
//        System.out.println(countObstacles);   
        for(int i = 0; i < countObstacles; i++){
//            System.out.println("!");
            obstacles.add(new Obstacle(sc.nextInt(),sc.nextInt()));            
        }
                    
        int countBaskets = sc.nextInt();
        System.out.println(countBaskets);
        for(int i = 0; i < countBaskets; i++){
//            System.out.println("!!!");
            baskets.add(new Basket(sc.nextInt(),sc.nextInt()));            
        }
                
        yogi = new YogiCharacter();
        drawPark = new DrawPark(rangers,obstacles,yogi,baskets,"park.png");
        drawPark.setPreferredSize(new Dimension(400, 400));
        score = new Score(drawPark.getScore(),drawPark.getLives());
        score.setPreferredSize(new Dimension(20,20));

        //frame.getContentPane().add(new JPanelWithBackground("park.png"));
        frame.getContentPane().add(BorderLayout.CENTER, drawPark);
        frame.getContentPane().add(BorderLayout.SOUTH, score);

//        frame.setSize(10000, 10000);
        frame.setPreferredSize(new Dimension(1500,1500));
        frame.pack();
        frame.setVisible(true);
        drawPark.setFocusable(true);
        drawPark.requestFocusInWindow();
        timer = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Dimension d = drawPark.getSize();
                if(drawPark.getLives() < score.getLives()){
                    score.decreaseLives(drawPark.getLives());
//                    System.out.println("yogi cords " + yogi.getXCord() + " " + yogi.getYCord());
                    yogi.setMove(0, 0);
                    JOptionPane.showMessageDialog(null, "You lost a life! Lives remain : " + score.getLives());
                }else {
                    boolean canMove = true;
                    for(Obstacle obstacle : obstacles){
//                        System.out.println("yogi cords " + yogi.getXCord() + " " + yogi.getYCord());
//                        System.out.println("obstacle cords" + obstacle.getXCord() + " " + obstacle.getYCord());
                        if(Math.abs(obstacle.getXCord()-yogi.getXCord()) <= 50 && Math.abs(obstacle.getYCord()-yogi.getYCord()) <= 50 ){
                            canMove = false;
                        }
                    }
                    if(canMove){
                        yogi.move(d.width, d.height);
                    }else{
                        yogi.setMove((int)yogi.getXCord()-20,(int)yogi.getYCord()-20);
                    }
                }
                if(score.getLives() == 0){
                    JOptionPane.showMessageDialog(null, "I beated you ;)");
                    System.exit(0);
                    
                }
                if(baskets.isEmpty()){
                    isWin = true;
                    System.out.println(isWin);
                    if(fileName.length() < 10){
                        JOptionPane.showMessageDialog(null, "You are awesome! You won level " + Character.getNumericValue(fileName.charAt(4)));
                    }else{
                        JOptionPane.showMessageDialog(null, "You are awesome! You won the level 10, so yeah I admit it I am a loser!");                        
                        System.exit(0);
                    }
//                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    frame.dispose();
                    timer.removeActionListener(this);
                    try {
                        if(fileName.length() < 10){
                            new GUI("test"+ Integer.toString(Character.getNumericValue(fileName.charAt(4)) + 1) +".txt");                            
                        }
//                        if(Character.getNumericValue(fileName.charAt(4)) < 10){
                            
//                        }else{
//                        }
                    } catch (IOException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                for(Ranger ranger : rangers){
                    ranger.move(d.width,d.height);
                }
                score.increaseScore(drawPark.getScore());
                
                if(!baskets.isEmpty()){
                    frame.repaint();                    
                }
            }
        });
        
        timer.start();

    }
    
    public JFrame getFrame(){return frame;}
    


}
