/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lenovo
 */
public class ModelTabelDataHewan extends AbstractTableModel {
    
    List<DataHewan> dh;
     public ModelTabelDataHewan(List<DataHewan> dh) {
        this.dh = dh;
    }
    
    @Override
    public int getRowCount() {
        return dh.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

     @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "Kelas";
            case 3:
                return "Jenis Makanan";
            default:
                return null;
        }
    }
    
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dh.get(row).getId();
            case 1:
                return dh.get(row).getNama();
            case 2:
                return dh.get(row).getKelas();
            case 3:
                return dh.get(row).getJenis_makanan();
            default:
                return null;
        }
    }
    
}
