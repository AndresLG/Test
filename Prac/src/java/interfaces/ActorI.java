package interfaces;

import java.util.List;
import model.ActorM;

public interface ActorI {
    public void agregar(ActorM actor) throws Exception;
    public void modificar(ActorM actor) throws Exception;
    public void eliminar(ActorM actor) throws Exception;
    public List<ActorM> listar() throws Exception;
}
