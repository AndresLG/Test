package dao;

import java.util.List;
import model.EstudianteM;

public interface IEstudiante {
    void guardar(EstudianteM estudiante) throws Exception;
    public void modificar(EstudianteM estudiante) throws Exception;
    public void eliminar(int estudianteId) throws Exception;
    public List<EstudianteM> listarEstudiante() throws Exception;
    public EstudianteM listarxId(int codigo) throws Exception;
}
