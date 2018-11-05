package controller;

import dao.PeliculaD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.PeliculaM;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;
import org.primefaces.event.ToggleEvent;

@Data
@Named(value = "peliculaC")
@SessionScoped
public class PeliculaC implements Serializable {

    PeliculaM pelicula = new PeliculaM();
    private List<PeliculaM> lstpelicula;
    
    @PostConstruct
    public void iniciar(){
        try {
            list();
        } catch (Exception e) {
        }
    }
    
    public void preparPelicula(){
        pelicula = new PeliculaM();
    }
    
    public void add() throws Exception{
        PeliculaD dao;
        try {
            dao = new PeliculaD();
            dao.agregar(pelicula);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Agregar"));
            throw e;
        }
    }
    
    public void update() throws Exception{
        PeliculaD dao;
        try {
            dao = new PeliculaD();
            dao.modificar(pelicula);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Modificar"));
            throw e;
        }
    }
    
    public void delete() throws Exception{
        PeliculaD dao;
        try {
            dao = new PeliculaD();
            dao.eliminar(pelicula);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Eliminar"));
            throw e;
        }
    }
    
    public void list() throws Exception{
        PeliculaD dao;
        try {
            dao = new PeliculaD();
            lstpelicula = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void onTabChange(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
         
    public void onTabClose(TabCloseEvent event) {
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void handleToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled", "Visibility:" + event.getVisibility());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
