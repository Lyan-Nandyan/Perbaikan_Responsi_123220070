/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOdata.DataHewanDAO;
import DAOImplement.DataHewanImplement;
import model.*;
import view.PageHewan;

/**
 *
 * @author lenovo
 */
public class DataHewanController {
    PageHewan frame;
    DataHewanImplement impldatahewan;
    List<DataHewan> dh;
    
    public DataHewanController(PageHewan frame){
        this.frame = frame;
        impldatahewan = new DataHewanDAO();
        dh = impldatahewan.getAll();
    }
    
    public void isitabel(){
        dh = impldatahewan.getAll();
        ModelTabelDataHewan mh = new ModelTabelDataHewan(dh);
        frame.getTabelHewan().setModel(mh);
    }
    
    public void insert(){
        DataHewan dh = new DataHewan();
        dh.setNama(frame.getjTextNama().getText());
        dh.setKelas(frame.getjTextKelas().getText());
        dh.setJenis_makanan(frame.getjTextMakanan().getText());
        impldatahewan.insert(dh);
    }
    
     public void update(){
        DataHewan dh = new DataHewan();
        dh.setNama(frame.getjTextNama().getText());
        dh.setKelas(frame.getjTextKelas().getText());
        dh.setJenis_makanan(frame.getjTextMakanan().getText());
        dh.setId(Integer.parseInt(frame.getjTextId().getText()));
        impldatahewan.update(dh);
    }
     
     public void delete(){
         int id = Integer.parseInt(frame.getjTextId().getText());
         impldatahewan.delete(id);
     }
     
}
