/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOImplement.DataPegawaiImplement;
import DAOdata.DataPegawaiDAO;
import model.*;
import view.PagePegawai;

/**
 *
 * @author lenovo
 */
public class DataPegawaiController {
    PagePegawai frame;
    DataPegawaiImplement impldatapegawai;
    List<DataPegawai> dp;
    
    public DataPegawaiController(PagePegawai frame){
        this.frame = frame;
        impldatapegawai = new DataPegawaiDAO();
        dp = impldatapegawai.getAll();
    }
    
    public void isitabel(){
        dp = impldatapegawai.getAll();
        ModelTabelDataPegawai mp = new ModelTabelDataPegawai(dp);
        frame.getTabelPegawai().setModel(mp);
    }
}
