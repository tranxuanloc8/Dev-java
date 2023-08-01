/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jv2assignment;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author tuanv
 */
public class EmployeeDAO implements itfEmployee {

    public static List<Employee> ls = new ArrayList<>();
    public static final String PATTERN = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";

    public static boolean isEmty(JTextField txt, StringBuilder sb, String msg) {
        if (txt.getText().trim().isEmpty()) {
            sb.append(msg + "\n");
            txt.setBackground(Color.red);
            return false;
        }
        txt.setBackground(Color.white);
        return true;
    }

    public static boolean isEmtyNumber(JTextField txt, StringBuilder sb, String msg, int type) {
        if (isEmty(txt, sb, msg)) {
            try {
                switch (type) {
                    case 0:
                        int numint = Integer.parseInt(txt.getText());
                        if (numint < 16 || numint > 55) {
                            txt.setBackground(Color.red);
                            sb.append(msg + "\n");
                            return false;
                        }
                        txt.setBackground(Color.white);
                        break;
                    case 1:
                        double numdb = Double.parseDouble(txt.getText());
                        if (numdb < 5000) {
                            txt.setBackground(Color.red);
                            sb.append(msg + "\n");
                            return false;
                        }
                        break;
                }
            } catch (Exception e) {
                txt.setBackground(Color.red);
                return false;
            }
            txt.setBackground(Color.white);
            return true;
        }
        txt.setBackground(Color.red);
        return false;
    }

    public static boolean isEmtyEmail(JTextField txt, StringBuilder sb, String msg) {
        if (isEmty(txt, sb, msg)) {
            try {
//                Pattern pattern = Pattern.compile(PATTERN);
//                Matcher matcher = pattern.matcher(txt.getText().toString());
                if (Pattern.matches(PATTERN, txt.getText())) {
                    txt.setBackground(Color.white);
                    return true;
                }
                txt.setBackground(Color.red);
                sb.append(msg + "\n");
                return false;
            } catch (Exception e) {
                sb.append(msg + "\n");
                txt.setBackground(Color.red);
                return false;
            }
        }
        return false;
    }

    @Override
    public int save(Employee e) {
        int pos = findbyid(e.getId());
        if (pos < 0) {
            ls.add(e);
        } else {
            ls.set(pos, e);
        }
        return 1;
    }

    @Override
    public int del(String id) {
        int pos = findbyid(id);
        if (pos >= 0) {
            ls.remove(pos);
            saveFile();
        }
        return pos;
    }

    @Override
    public int findbyid(String id) {
        openfile();
        int pos = -1;
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getId().equalsIgnoreCase(id)) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    @Override
    public Employee getEmployeePos(int index) {
        if (index >= 0 && index < ls.size()) {
            return ls.get(index);
        }
        return null;
    }

    @Override
    public List<Employee> openfile() {
        try {
            ls = (List<Employee>) XFile.readobj();
        } catch (Exception ex) {
        }
        return ls;
    }

    @Override
    public void saveFile() {
        XFile.writeobj(ls);
    }

    @Override
    public List<Employee> getAll() {
        return ls;
    }

    @Override
    public int count() {
        return ls.size();
    }

}
