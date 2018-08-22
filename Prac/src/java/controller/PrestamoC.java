package controller;

import dao.PrestamoD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.PrestamoM;

@Data
@Named(value = "prestamoC")
@SessionScoped
public class PrestamoC implements Serializable {

    PrestamoM prestamo = new PrestamoM();
    private List<PrestamoM> lstprestamo;
    
    @PostConstruct
    public void iniciar(){
        try {
            list();
        } catch (Exception e) {
        }
    }
    
    public void preparPrestamo(){
        prestamo = new PrestamoM();
    }
    
    public void add() throws Exception{
        PrestamoD dao;
        try {
            dao = new PrestamoD();
            dao.agregar(prestamo);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Agregar"));
            throw e;
        }
    }
    
    public void update() throws Exception{
        PrestamoD dao;
        try {
            dao = new PrestamoD();
            dao.modificar(prestamo);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Modificar"));
            throw e;
        }
    }
    
    public void delete() throws Exception{
        PrestamoD dao;
        try {
            dao = new PrestamoD();
            dao.eliminar(prestamo);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Eliminar"));
            throw e;
        }
    }
    
    public void list() throws Exception{
        PrestamoD dao;
        try {
            dao = new PrestamoD();
            lstprestamo = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
