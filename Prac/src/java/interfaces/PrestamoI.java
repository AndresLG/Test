package interfaces;

import java.util.List;
import model.PrestamoM;

public interface PrestamoI {
    public void agregar(PrestamoM prestamo) throws Exception;
    public void modificar(PrestamoM prestamo) throws Exception;
    public void eliminar(PrestamoM prestamo) throws Exception;
    public List<PrestamoM> listar() throws Exception;
}
