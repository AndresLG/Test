package controller;

import dao.DirectorD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.DirectorM;

@Data
@Named(value = "directorC")
@SessionScoped
public class DirectorC implements Serializable {

    DirectorM director = new DirectorM();
    private List<DirectorM> lstdirector;
    
    @PostConstruct
    public void iniciar(){
        try {
            list();
        } catch (Exception e) {
        }
    }
    
    public void preparDirector(){
        director = new DirectorM();
    }
    
    public void add() throws Exception{
        DirectorD dao;
        try {
            dao = new DirectorD();
            dao.agregar(director);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Agregar"));
            throw e;
        }
    }
    
    public void update() throws Exception{
        DirectorD dao;
        try {
            dao = new DirectorD();
            dao.modificar(director);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Modificar"));
            throw e;
        }
    }
    
    public void delete() throws Exception{
        DirectorD dao;
        try {
            dao = new DirectorD();
            dao.eliminar(director);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Eliminar"));
            throw e;
        }
    }
    
    public void list() throws Exception{
        DirectorD dao;
        try {
            dao = new DirectorD();
            lstdirector = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
