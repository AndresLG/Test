package dao;

import interfaces.PrestamoI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.PrestamoM;

public class PrestamoD extends Dao implements PrestamoI{

    @Override
    public void agregar(PrestamoM prestamo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into Prestamo(fechaPrest,Socio_idSoc,telefono2,Identificacion,SSN,ProductKey,Telefono) values(to_date(?,'DD/MM/YYYY'),?,?,?,?,?,?)");
            st.setString(1, prestamo.getFechaPrest());
            st.setString(2, prestamo.getSocio_idSoc());
            st.setString(3, prestamo.getTelefono2());
            st.setString(4, prestamo.getIdentificacion());
            st.setString(5, prestamo.getSSN());
            st.setString(6, prestamo.getProductKey());
            st.setString(7, prestamo.getTelefono());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public void modificar(PrestamoM prestamo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("update Prestamo set fechaPrest=to_date(?,'DD/MM/YYYY'),Socio_idSoc=?,telefono2=?,Identificacion=?,SSN=?,ProductKey=?,Telefono=? where idPrest=?");
            st.setString(1, prestamo.getFechaPrest());
            st.setString(2, prestamo.getSocio_idSoc());
            st.setString(3, prestamo.getTelefono2());
            st.setString(4, prestamo.getIdentificacion());
            st.setString(5, prestamo.getSSN());
            st.setString(6, prestamo.getProductKey());
            st.setString(7, prestamo.getTelefono());
            st.setInt(8, prestamo.getIdPrest());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public void eliminar(PrestamoM prestamo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from Prestamo where idPrest=?");
            st.setInt(1, prestamo.getIdPrest());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }

    @Override
    public List<PrestamoM> listar() throws Exception {
        List<PrestamoM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "select Idrest, TO_CHAR(FechaPrest,'DD/MON/YYYY', 'NLS_DATE_LANGUAGE=SPANISH') as FechaPrest, Socio_idSoc, Telefono2, Identificacion, SSN, ProductKey, Telefono from Prestamo";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs= st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                PrestamoM prestamo= new PrestamoM();
                prestamo.setIdPrest(rs.getInt("Idrest"));
                prestamo.setFechaPrest(rs.getString("FechaPrest"));
                prestamo.setSocio_idSoc(rs.getString("Socio_idSoc"));
                prestamo.setTelefono2(rs.getString("Telefono2"));
                prestamo.setIdentificacion(rs.getString("Identificacion"));
                prestamo.setSSN(rs.getString("SSN"));
                prestamo.setProductKey(rs.getString("ProductKey"));
                prestamo.setTelefono(rs.getString("Telefono"));
                lista.add(prestamo);
            }
            return lista;
        } catch (Exception e) {
            throw e;
        }finally{
           this.Cerrar();
        }
    }
    
}
