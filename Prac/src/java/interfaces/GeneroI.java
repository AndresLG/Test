package interfaces;

import java.util.List;
import model.GeneroM;

public interface GeneroI {
    public void agregar(GeneroM genero) throws Exception;
    public void modificar(GeneroM genero) throws Exception;
    public void eliminar(GeneroM genero) throws Exception;
    public List<GeneroM> listar() throws Exception;
}
