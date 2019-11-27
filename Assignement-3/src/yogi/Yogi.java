/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yogi;

import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 *
 * @author hossameldin
 */
public class Yogi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        GUI gui = new GUI("test1.txt");
//        while(i <= 10){
////            System.out.println("---------" + gui.isWin);
//            if(gui.isWin){
//                i++;
//                System.out.println(i);
//                //gui.getFrame().dispatchEvent(new WindowEvent(gui.getFrame(), WindowEvent.WINDOW_DEACTIVATED));
//                //gui.getFrame().dispose();
//                gui = new GUI("test"+Integer.toString(i)+".txt");
//                System.out.println("new!");
//            }
//        }
    }
    
}
