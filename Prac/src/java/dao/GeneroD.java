package dao;

import interfaces.GeneroI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.GeneroM;

public class GeneroD extends Dao implements GeneroI{

    @Override
    public void agregar(GeneroM genero) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into Genero(nomGen) values(?)");
            st.setString(1, genero.getNomGen());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public void modificar(GeneroM genero) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("update Genero set nomGen=? where idGen=?");
            st.setString(1, genero.getNomGen());
            st.setInt(2, genero.getIdGen());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public void eliminar(GeneroM genero) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from Genero where idGen=?");
            st.setInt(1, genero.getIdGen());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public List<GeneroM> listar() throws Exception {
        List<GeneroM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "select * from Genero";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs= st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                GeneroM genero= new GeneroM();
                genero.setIdGen(rs.getInt("IdGen"));
                genero.setNomGen(rs.getString("NomGen"));
                lista.add(genero);
            }
            return lista;
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }
    
}
