package dao;

import interfaces.PeliculaI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.PeliculaM;

public class PeliculaD extends Dao implements PeliculaI{

    @Override
    public void agregar(PeliculaM pelicula) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into Pelicula(titulo,estado,Genero_idGen,Director_idDirect,Actor_idAct) values(?,?,?,?,?)");
            st.setString(1, pelicula.getTitulo());
            st.setString(2, pelicula.getEstado());
            st.setString(3, pelicula.getGenero_idGen());
            st.setString(4, pelicula.getDirector_idDirect());
            st.setString(5, pelicula.getActor_idAct());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public void modificar(PeliculaM pelicula) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("update Pelicula set titulo=?,estado=?,Genero_idGen=?,Director_idDirect=?,Actor_idAct=? where idPel=?");
            st.setString(1, pelicula.getTitulo());
            st.setString(2, pelicula.getEstado());
            st.setString(3, pelicula.getGenero_idGen());
            st.setString(4, pelicula.getDirector_idDirect());
            st.setString(5, pelicula.getActor_idAct());
            st.setInt(6, pelicula.getIdPel());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public void eliminar(PeliculaM pelicula) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from Pelicula where idPel=?");
            st.setInt(1, pelicula.getIdPel());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public List<PeliculaM> listar() throws Exception {
        List<PeliculaM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "select * from vw_Pelicula";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs= st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                PeliculaM pelicula= new PeliculaM();
                pelicula.setIdPel(rs.getInt("IdPel"));
                pelicula.setTitulo(rs.getString("Titulo"));
                pelicula.setEstado(rs.getString("Estado"));
                pelicula.setGenero_idGen(rs.getString("Genero"));
                pelicula.setDirector_idDirect(rs.getString("Director"));
                pelicula.setActor_idAct(rs.getString("Actor"));
                lista.add(pelicula);
            }
            return lista;
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }
    
}
