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
public class ModelTabelDataPegawai extends AbstractTableModel{
    List<DataPegawai> dp;
     public ModelTabelDataPegawai(List<DataPegawai> dp) {
        this.dp = dp;
    }
     
    @Override
    public int getRowCount() {
        return dp.size();
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
                return "Email";
            case 3:
                return "Role";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dp.get(row).getId();
            case 1:
                return dp.get(row).getNama();
            case 2:
                return dp.get(row).getEmail();
            case 3:
                return dp.get(row).getRole();
            default:
                return null;
        }
    
    }
    
}
