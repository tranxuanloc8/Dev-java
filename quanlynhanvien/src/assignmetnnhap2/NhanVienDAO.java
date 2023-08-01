/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignmetnnhap2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author tuanv
 */
public class NhanVienDAO {

    ArrayList<NhanVien> ls = new ArrayList<>();

    public boolean isemty(JTextField jt, StringBuilder sb, String msg) {
        if (jt.getText().toString().trim().isEmpty()) {
            sb.append(msg);
            jt.setBackground(Color.red);
            return false;
        }
        return true;
    }

    public boolean isemtyage(JTextField jt, StringBuilder sb, String msg) {
        if (isemty(jt, sb, msg)) {
            try {
                int age = Integer.parseInt(jt.getText().toString().trim());
                return true;
            } catch (Exception e) {
                sb.append(msg);
                jt.setBackground(Color.red);
                return false;
            }
        }
        return false;
    }
    public boolean isemtysalary(JTextField jt, StringBuilder sb, String msg) {
        if (isemty(jt, sb, msg)) {
            try {
                double age = Double.parseDouble(jt.getText().toString().trim());
                return true;
            } catch (Exception e) {
                sb.append(msg);
                jt.setBackground(Color.red);
                return false;
            }
        }
        return false;
    }
    public void saveFile(){
        Xfile.writeobj(ls);
    }
    public List<NhanVien> openfile(){
        ls = (ArrayList<NhanVien>) Xfile.readobj();
        return ls;
    }
    public int find(String id){
        int pos = -1;
        openfile();
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getId().equalsIgnoreCase(id)) {
                pos =i;
            }
        }
        return pos;
    }
    public int add(NhanVien nv){
//        int pos = find(nv.getId());
//        if (pos>=0) {
//            ls.set(pos, nv);
//            JOptionPane.showMessageDialog(null, "Update thanhcong");
//            saveFile();
//        }else{
            ls.add(nv);
            JOptionPane.showMessageDialog(null, "Save thanhcong");
            saveFile();
//        }
        return 1;
    }
    public int del(String id){
        int pos = find(id);
        if (pos>=0) {
            ls.remove(pos);
            JOptionPane.showMessageDialog(null, "Da xoa thanh cong");
        }else JOptionPane.showMessageDialog(null, "Khong tim thay");
        return pos;
    }
    
    public void getSortByName() {
        openfile();
        for (int i = 0; i < ls.size()-1; i++) {
            for (int j = i+1; j < ls.size(); j++) {
                if (splitName(ls.get(i).getName().trim()).compareToIgnoreCase(ls.get(j).getName().trim())>0) {
                    Collections.swap(ls, i, j);
                }
            }
        }
        saveFile();
    }
    

    public String splitName(String fullName) {
        String name = fullName.substring(fullName.trim().lastIndexOf(" ") + 1);
        return name;
    }
    
}
