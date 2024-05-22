/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;

import java.util.List;
import model.DataHewan;

/**
 *
 * @author lenovo
 */
public interface DataHewanImplement {
    public void insert(DataHewan p);
    public void update(DataHewan p);
    public void delete(int id);
    public List<DataHewan> getAll();
}
