/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignmetnnhap2;

import java.io.Serializable;

/**
 *
 * @author tuanv
 */
public class NhanVien implements Serializable{
    private String id, name, email;
    private int age;
    private double salary;

    public NhanVien(String id, String name, String email, int age, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.salary = salary;
    }

    public NhanVien() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
}
