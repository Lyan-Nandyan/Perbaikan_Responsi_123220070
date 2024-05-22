/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAOImplement.DataLoginImplement;
import DAOdata.DataLoginDAO;
import javax.swing.JOptionPane;
import view.LoginPage;
import view.MenuPage;

/**
 *
 * @author lenovo
 */
public class DataLoginController {
    LoginPage frame;
    MenuPage menu;
    DataLoginImplement impldatalogin;
    
    
    public DataLoginController(LoginPage frame) {
        this.frame = frame;
        this.impldatalogin = new DataLoginDAO();
    }
    
    public void login(){
        String nama = frame.getjTextUser().getText();
        String password = frame.getjTextPassword().getText();
        if(nama.isBlank() || password.isBlank()){
            JOptionPane.showMessageDialog(frame, "Username atau Password Tidak boleh Kosong");
        }else if (impldatalogin.validasiLogin(nama, password)) {
                System.out.println("Login berhasil!");
                DataLoginDAO.setNama(nama);
                menu = new MenuPage();
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
                frame.dispose();
        } else {
            JOptionPane.showMessageDialog(frame, "Nama atau password salah.");
        }
    }
    
}
