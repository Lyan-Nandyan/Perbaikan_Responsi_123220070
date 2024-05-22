/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdata;
import java.sql.*;
import koneksi.Connector;
import DAOImplement.DataLoginImplement;


/**
 *
 * @author lenovo
 */
public class DataLoginDAO implements DataLoginImplement{
    Connection connection;
    
    final String login = "SELECT * FROM pegawai WHERE nama = ? AND password = ?";
    private static String nama;
    
    public DataLoginDAO() {
        connection = Connector.connection();
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        DataLoginDAO.nama = nama;
    }
    
        public static void clear() {
        DataLoginDAO.nama = null;
    }
        
    @Override
    public boolean validasiLogin(String nama, String password) {
        try {
                PreparedStatement statement = connection.prepareStatement(login);
                statement.setString(1, nama);
                statement.setString(2, password);
                ResultSet rs = statement.executeQuery();

                return rs.next();
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
    }
    
}
