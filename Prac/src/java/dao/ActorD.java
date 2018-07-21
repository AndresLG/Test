package dao;

import interfaces.ActorI;
import java.sql.PreparedStatement;
import java.util.List;
import model.ActorM;

public class ActorD extends Dao implements ActorI{

    @Override
    public void agregar(ActorM actor) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into Actor(idAct, nomAct, apeAct) values(?,?,?)");
            st.setInt(1, actor.getIdAct());
            st.setString(2, actor.getNomAct());
            st.setString(3, actor.getApeAct());
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
            PreparedStatement st = this.getCn().prepareStatement("");
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public List<ActorM> listar() throws Exception {
        try {
            this.Conectar();
            
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }
    
}
