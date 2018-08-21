package dao;

import interfaces.DirectorI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DirectorM;

public class DirectorD extends Dao implements DirectorI{

    @Override
    public void agregar(DirectorM director) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into Director(nomDirect, apeDirect) values(?,?)");
            st.setString(1, director.getNomDirect());
            st.setString(2, director.getApeDirect());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public void modificar(DirectorM director) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("update Director set nomDirect=?,apeDirect=? where idDirect=?");
            st.setString(1, director.getNomDirect());
            st.setString(2, director.getApeDirect());
            st.setInt(3, director.getIdDirect());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public void eliminar(DirectorM director) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from Director where idDirect=?");
            st.setInt(1, director.getIdDirect());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public List<DirectorM> listar() throws Exception {
        List<DirectorM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "select * from Director";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs= st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                DirectorM director= new DirectorM();
                director.setIdDirect(rs.getInt("IdDirect"));
                director.setNomDirect(rs.getString("NomDirect"));
                director.setApeDirect(rs.getString("ApeDirect"));
                lista.add(director);
            }
            return lista;
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }
    
}
