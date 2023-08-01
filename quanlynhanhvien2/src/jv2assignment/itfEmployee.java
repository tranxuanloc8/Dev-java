/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jv2assignment;

import java.util.List;

/**
 *
 * @author tuanv
 */
public interface itfEmployee {
    int save(Employee e);
    int del(String id);
    int findbyid(String id);
    Employee getEmployeePos(int index);
    List<Employee> openfile();
    void saveFile();
    List<Employee> getAll();
    int count();
}
