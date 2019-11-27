/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yogi;

import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author hossameldin
 */
public class Score extends JPanel{
    private int score;
    private int lives;
    private JLabel scoreLabel;
    private JLabel livesLabel;

    public Score(int score, int lives) {
        this.score = score;
        this.lives = lives;
        this.scoreLabel = new JLabel(Integer.toString(score),SwingConstants.CENTER);
        this.livesLabel = new JLabel(Integer.toString(lives),SwingConstants.CENTER);
    }
    
    public void increaseScore(int score){this.score = score;}
    public void decreaseLives(int lives){this.lives = lives;}
    public int getLives() {return lives;}
    
    @Override
    protected void paintComponent(Graphics grphcs){
        scoreLabel.setText("score : " + Integer.toString(score) + "   ");
        livesLabel.setText("lives : " + Integer.toString(lives));
        this.add(scoreLabel);
        this.add(livesLabel);
    }
}
