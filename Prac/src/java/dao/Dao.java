package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.Data;

@Data
public class Dao {

    public Connection cn;

    public void Conectar() throws Exception {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=BDVideoClub", "root", "root");
            cn = DriverManager.getConnection("jdbc:sqlserver://192.168.8.114:1433;database=BDVideoClub", "sa", "root");
        } catch (SQLException e) {
            throw e;
        }
    }

    public void Cerrar() throws Exception {
        try {
            if (cn != null) {
                if (cn.isClosed() == false) {
                    cn.close();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}

// try {
//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           //cn=DriverManager.getConnection("jdbc:sqlserver://35.229.54.77:1433;database=GuiaElect", "root", "root");

/* En public void Conectar(), agrerar ClassNotFoundExcection */
//try...
//            System.out.println("Conectado");
//catch... Cambiar SQLException por ClassNotFoundExcection
//            cambiar throw e por System.out.println("No Conectado");

/* Para probar la conexión */
//    public static void main(String[] args) throws SQLException, ClassNotFoundException{
//        try {
//            Dao dao = new Dao();
//            dao.Conectar();
//        } catch (ClassNotFoundException | SQLException e) {
//            throw e;
//        }
//    }