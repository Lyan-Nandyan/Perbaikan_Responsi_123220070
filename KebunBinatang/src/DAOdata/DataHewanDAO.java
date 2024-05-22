/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdata;
import java.sql.*;
import java.util.*;
import koneksi.Connector;
import DAOImplement.DataHewanImplement;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class DataHewanDAO implements DataHewanImplement{
    Connection connection;
    
    final String select = "SELECT * FROM `hewan`";
    final String insert = "INSERT INTO hewan (nama, kelas, jenis_makanan) VALUES (?, ?, ?);";
    final String update = "update hewan set nama=?, kelas=?, jenis_makanan=? where id=?";
    final String delete = "delete from hewan where id=?";

    public DataHewanDAO() {
        connection = Connector.connection();
    }
    
    @Override
    public void insert(DataHewan p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getNama());
            statement.setString(2, p.getKelas());
            statement.setString(3, p.getJenis_makanan());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                p.setId(rs.getInt(1));
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(DataHewan p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getNama());
            statement.setString(2, p.getKelas());
            statement.setString(3, p.getJenis_makanan());
            statement.setInt(4, p.getId());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<DataHewan> getAll() {
         List<DataHewan> dh = null;
        try{
            dh = new ArrayList<DataHewan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                DataHewan hewan = new DataHewan();
                hewan.setId(rs.getInt("id"));
                hewan.setNama(rs.getString("nama"));
                hewan.setKelas(rs.getString("kelas"));
                hewan.setJenis_makanan(rs.getString("jenis_makanan"));
                dh.add(hewan);
            }
        }catch(SQLException ex){
            Logger.getLogger(DataHewanDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        return dh;
    }
    
}
