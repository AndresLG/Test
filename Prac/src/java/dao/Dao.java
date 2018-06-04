package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
    private Connection cn;

    public Connection getCn() {
        //si está abierta la conexión
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public void Conectar() throws SQLException, ClassNotFoundException{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://192.168.8.169:1433;database=GAE", "sa", "vallegrande2018");
            System.out.println("Conectado");
        } catch (ClassNotFoundException e) {
            System.out.println("No conectado");
        }
    }
    
    public void Desconectar() throws Exception{
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
    
    //public static void main(String[] args) throws SQLException, ClassNotFoundException {}
}
