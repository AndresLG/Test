package interfaces;

import java.util.List;
import model.DirectorM;

public interface DirectorI {
    public void agregar(DirectorM director) throws Exception;
    public void modificar(DirectorM director) throws Exception;
    public void eliminar(DirectorM director) throws Exception;
    public List<DirectorM> listar() throws Exception;
}
