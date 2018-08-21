package controller;

import dao.GeneroD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.GeneroM;

@Data
@Named(value = "generoC")
@SessionScoped
public class GeneroC implements Serializable {

    GeneroM genero = new GeneroM();
    private List<GeneroM> lstgenero;
    
    @PostConstruct
    public void iniciar(){
        try {
            list();
        } catch (Exception e) {
        }
    }
    
    public void preparGenero(){
        genero = new GeneroM();
    }
    
    public void add() throws Exception{
        GeneroD dao;
        try {
            dao = new GeneroD();
            dao.agregar(genero);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Agregar"));
            throw e;
        }
    }
    
    public void update() throws Exception{
        GeneroD dao;
        try {
            dao = new GeneroD();
            dao.modificar(genero);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Modificar"));
            throw e;
        }
    }
    
    public void delete() throws Exception{
        GeneroD dao;
        try {
            dao = new GeneroD();
            dao.eliminar(genero);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Eliminar"));
            throw e;
        }
    }
    
    public void list() throws Exception{
        GeneroD dao;
        try {
            dao = new GeneroD();
            lstgenero = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
