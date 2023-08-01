/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jv2assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuanv
 */
public class XFile {
    public static final String FILE_NAME = "listEP.dat";
    
    public static void writeobj(Object data){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(data);
            oos.close();
        } catch (Exception ex) {
           ex.getMessage();
        }
    }
    public static Object readobj() throws FileNotFoundException, IOException, ClassNotFoundException{
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));) {
           return ois.readObject();
        }
    }
}
