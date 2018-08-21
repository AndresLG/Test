package controller;

import dao.SocioD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.SocioM;

@Data
@Named(value = "socioC")
@SessionScoped
public class SocioC implements Serializable {

    SocioM socio = new SocioM();
    private List<SocioM> lstsocio;
    
    @PostConstruct
    public void iniciar(){
        try {
            list();
        } catch (Exception e) {
        }
    }
    
    public void preparSocio(){
        socio = new SocioM();
    }
    
    public void add() throws Exception{
        SocioD dao;
        try {
            dao = new SocioD();
            dao.agregar(socio);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Agregar"));
            throw e;
        }
    }
    
    public void update() throws Exception{
        SocioD dao;
        try {
            dao = new SocioD();
            dao.modificar(socio);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Modificar"));
            throw e;
        }
    }
    
    public void delete() throws Exception{
        SocioD dao;
        try {
            dao = new SocioD();
            dao.eliminar(socio);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Eliminar"));
            throw e;
        }
    }
    
    public void list() throws Exception{
        SocioD dao;
        try {
            dao = new SocioD();
            lstsocio = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
