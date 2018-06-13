
package controller;

import dao.EstudianteDaoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.EstudianteM;

@Named(value = "estudianteC")
@SessionScoped
public class EstudianteC implements Serializable {

    private EstudianteM estudiante = new EstudianteM();
    
    public EstudianteC() {
        
    }

    public EstudianteM getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteM estudiante) {
        this.estudiante = estudiante;
    }
    
    public void guardar() throws Exception{
        EstudianteDaoImpl dao;
        
        try {
            dao = new EstudianteDaoImpl();
            dao.guardar(estudiante);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado","Correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error","No se pudo guardar"));
            throw e;
        }
    }
    
}
