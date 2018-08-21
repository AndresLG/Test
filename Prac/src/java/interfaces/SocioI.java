package interfaces;

import java.util.List;
import model.SocioM;

public interface SocioI {
    public void agregar(SocioM socio) throws Exception;
    public void modificar(SocioM socio) throws Exception;
    public void eliminar(SocioM socio) throws Exception;
    public List<SocioM> listar() throws Exception;
}
