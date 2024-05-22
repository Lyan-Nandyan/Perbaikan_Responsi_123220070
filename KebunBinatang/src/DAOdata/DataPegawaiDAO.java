/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdata;
import java.sql.*;
import java.util.*;
import koneksi.Connector;
import DAOImplement.DataPegawaiImplement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author lenovo
 */
public class DataPegawaiDAO implements DataPegawaiImplement{
    Connection connection;
    
    final String select = "SELECT * FROM `pegawai`";

    public DataPegawaiDAO() {
        connection = Connector.connection();
    }
    
    @Override
    public List<DataPegawai> getAll() {
        List<DataPegawai> dp = null;
        try{
            dp = new ArrayList<DataPegawai>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                DataPegawai pegawai = new DataPegawai();
                pegawai.setId(rs.getInt("id"));
                pegawai.setNama(rs.getString("nama"));
                pegawai.setEmail(rs.getString("email"));
                pegawai.setRole(rs.getString("role"));
                dp.add(pegawai);
            }
        }catch(SQLException ex){
            Logger.getLogger(DataPegawaiDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        return dp;
    }
}
