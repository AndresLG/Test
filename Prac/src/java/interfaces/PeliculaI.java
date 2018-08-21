package interfaces;

import java.util.List;
import model.PeliculaM;

public interface PeliculaI {
    public void agregar(PeliculaM pelicula) throws Exception;
    public void modificar(PeliculaM pelicula) throws Exception;
    public void eliminar(PeliculaM pelicula) throws Exception;
    public List<PeliculaM> listar() throws Exception;
}
