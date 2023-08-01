/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jv2assignment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author tuanv
 */
public class Clock implements Runnable{
    JLabel lbl;

    public Clock(JLabel lbl) {
        this.lbl = lbl;
    }
    
    @Override
    public void run() {
        while (true) {            
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm aa");
            lbl.setText(simpleDateFormat.format(date));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
