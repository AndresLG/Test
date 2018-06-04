package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.EstudianteM;

public class EstudianteDaoImpl extends Dao implements IEstudiante{

    @Override
    public void guardar(EstudianteM estudiante) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into Estudiante (nomEst, apeEst, dniEst, emailEst, telfEst, dirEst) values (?, ?, ?, ?, ?, ?)");
            st.setString(1, estudiante.getNombre());
            st.setString(2, estudiante.getApellido());
            st.setInt(3, estudiante.getDni());
            st.setString(4, estudiante.getEmail());
            st.setInt(5, estudiante.getTelefono());
            st.setString(6, estudiante.getDireccion());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.Desconectar();
        }
    }

    @Override
    public void modificar(EstudianteM estudiante) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("update Estudiante set nomEst = ?, apeEst = ?, dniEst = ?, emailEst = ?, telfEst = ?, dirEst = ? where idEst = ?");
            st.setString(1, estudiante.getNombre());
            st.setString(2, estudiante.getApellido());
            st.setInt(3, estudiante.getDni());
            st.setString(4, estudiante.getEmail());
            st.setInt(5, estudiante.getTelefono());
            st.setString(6, estudiante.getDireccion());
            st.setInt(7, estudiante.getCodigo());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.Desconectar();
        }
    }

    @Override
    public void eliminar(int estudianteId) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from Estudiante where idEst = ?");
            st.setInt(1, estudianteId);
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.Desconectar();
        }
    }

    @Override
    public List<EstudianteM> listarEstudiante() throws Exception {
        List<EstudianteM> estudiantes = new ArrayList<>();
        try {
            this.Conectar();
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery("select * from Estudiante");
            while (rs.next()) {
                EstudianteM estudiante = new EstudianteM();
                estudiante.setCodigo(rs.getInt("idEst"));
                estudiante.setNombre(rs.getString("nomEst"));
                estudiante.setApellido(rs.getString("apeEst"));
                estudiante.setDni(rs.getInt("dniEst"));
                estudiante.setEmail(rs.getString("emailEst"));
                estudiante.setTelefono(rs.getInt("telfEst"));
                estudiante.setDireccion(rs.getString("dirEst"));
                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            throw e;
        }finally{
        this.Desconectar();
    }
        return estudiantes;
    }

    @Override
    public EstudianteM listarxId(int codigo) throws Exception {
        EstudianteM estudiante = new EstudianteM();
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("select * from Estudiante where idEst = ?");
            st.setInt(1, codigo);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                estudiante.setCodigo(rs.getInt("idEst"));
                estudiante.setNombre(rs.getString("nomEst"));
                estudiante.setApellido(rs.getString("apeEst"));
                estudiante.setDni(rs.getInt("dniEst"));
                estudiante.setEmail(rs.getString("emailEst"));
                estudiante.setTelefono(rs.getInt("telfEst"));
                estudiante.setDireccion(rs.getString("dirEst"));
            }
        } catch (SQLException e) {
            throw e;
        }finally{
            this.Desconectar();
        }
        return estudiante;
    }
    
}
