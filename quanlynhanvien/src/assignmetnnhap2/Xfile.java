/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignmetnnhap2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tuanv
 */
public class Xfile {
    public static final String TABLE_NAME = "listnhanvien.dat";
    public static void writeobj(Object obj){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TABLE_NAME));
            oos.writeObject(obj);
            oos.close();
        } catch (Exception ex) {
            System.out.println("loi ghi file");
        }
    }
    public static Object readobj(){
        Object obj = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TABLE_NAME));
            obj = ois.readObject();
        } catch (Exception ex) {
            System.out.println("loi doc file");
        }
        return obj;
    }
    public static void writeString(String str){
        try {
            FileOutputStream fos = new FileOutputStream("van.txt");
            byte[] data = str.getBytes();
            fos.write(data);
            JOptionPane.showMessageDialog(null, "Ghi thanh cong");
            fos.close();
        } catch (Exception ex) {
            System.out.println("loi ghi file");
        }
    }
    public static String readfile() throws FileNotFoundException, IOException{
        FileInputStream fis = new FileInputStream("van.txt");
        int lenght = fis.available();
        byte[] data = new byte[lenght];
        fis.read(data);
        String str = new String(data, "utf-8");
        return str;
    }
}
