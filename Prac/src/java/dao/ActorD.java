package dao;

import interfaces.ActorI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ActorM;

public class ActorD extends Dao implements ActorI{

    @Override
    public void agregar(ActorM actor) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into Actor(nomAct, apeAct) values(?,?)");
            st.setString(1, actor.getNomAct());
            st.setString(2, actor.getApeAct());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public void modificar(ActorM actor) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("update Actor set nomAct=?,apeAct=? where idAct=?");
            st.setString(1, actor.getNomAct());
            st.setString(2, actor.getApeAct());
            st.setInt(3, actor.getIdAct());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public void eliminar(ActorM actor) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from Actor where idAct=?");
            st.setInt(1, actor.getIdAct());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public List<ActorM> listar() throws Exception {
        List<ActorM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "select * from Actor";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs= st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                ActorM actor= new ActorM();
                actor.setIdAct(rs.getInt("IdAct"));
                actor.setNomAct(rs.getString("NomAct"));
                actor.setApeAct(rs.getString("ApeAct"));
                lista.add(actor);
            }
            return lista;
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }
    
}
