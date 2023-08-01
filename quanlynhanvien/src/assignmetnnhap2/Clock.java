/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignmetnnhap2;

import java.awt.Label;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author tuanv
 */
public class Clock extends Thread{
    JLabel lbl;

    public Clock(JLabel lbl) {
        this.lbl = lbl;
    }

    @Override
    public void run() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
                String clock = sdf.format(date);
                lbl.setText(clock);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();
    }
 
}
