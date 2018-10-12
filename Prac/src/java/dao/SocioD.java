package dao;

import interfaces.SocioI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SocioM;

public class SocioD extends Dao implements SocioI{

    @Override
    public void agregar(SocioM socio) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into Socio(nomSoc,apeSoc,direccion,telefono,Director_idDirect,Actor_idAct,Genero_idGen) values(?,?,?,?,?,?,?)");
            st.setString(1, socio.getNomSoc());
            st.setString(2, socio.getApeSoc());
            st.setString(3, socio.getDireccion());
            st.setString(4, socio.getTelefono());
            st.setString(5, socio.getDirector_idDirect());
            st.setString(6, socio.getActor_idAct());
            st.setString(7, socio.getGenero_idGen());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public void modificar(SocioM socio) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("update Socio set nomSoc=?,apeSoc=?,direccion=?,telefono=?,Director_idDirect=?,Actor_idAct=?,Genero_idGen=? where idSoc=?");
            st.setString(1, socio.getNomSoc());
            st.setString(2, socio.getApeSoc());
            st.setString(3, socio.getDireccion());
            st.setString(4, socio.getTelefono());
            st.setString(5, socio.getDirector_idDirect());
            st.setString(6, socio.getActor_idAct());
            st.setString(7, socio.getGenero_idGen());
            st.setInt(8, socio.getIdSoc());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public void eliminar(SocioM socio) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from Socio where idSoc=?");
            st.setInt(1, socio.getIdSoc());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public List<SocioM> listar() throws Exception {
        List<SocioM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "select * from vw_Socio";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs= st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                SocioM socio= new SocioM();
                socio.setIdSoc(rs.getInt("IdSoc"));
                socio.setNomSoc(rs.getString("NomSoc"));
                socio.setApeSoc(rs.getString("ApeSoc"));
                socio.setDireccion(rs.getString("Direccion"));
                socio.setTelefono(rs.getString("Telefono"));
                socio.setDirector_idDirect(rs.getString("Director"));
                socio.setActor_idAct(rs.getString("Actor"));
                socio.setGenero_idGen(rs.getString("Genero"));
                lista.add(socio);
            }
            return lista;
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }
    
}
