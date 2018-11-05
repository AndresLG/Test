package controller;

import dao.ActorD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.ActorM;
import org.primefaces.component.layout.LayoutUnit;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.ToggleEvent;

@Data
@Named(value = "actorC")
@SessionScoped
public class ActorC implements Serializable {

    ActorM actor = new ActorM();
    private List<ActorM> lstactor;

    @PostConstruct
    public void iniciar() {
        try {
            list();
        } catch (Exception e) {
        }
    }

    public void preparActor() {
        actor = new ActorM();
    }

    public void add() throws Exception {
        ActorD dao;
        try {
            dao = new ActorD();
            dao.agregar(actor);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Agregar"));
            throw e;
        }
    }

    public void update() throws Exception {
        ActorD dao;
        try {
            dao = new ActorD();
            dao.modificar(actor);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Modificar"));
            throw e;
        }
    }

    public void delete() throws Exception {
        ActorD dao;
        try {
            dao = new ActorD();
            dao.eliminar(actor);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Eliminar"));
            throw e;
        }
    }

    public void list() throws Exception {
        ActorD dao;
        try {
            dao = new ActorD();
            lstactor = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void handleClose(CloseEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Unit Closed", "Position:'" + ((LayoutUnit) event.getComponent()).getPosition() + "'");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void handleToggle(ToggleEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, ((LayoutUnit) event.getComponent()).getPosition() + " toggled", "Status:" + event.getVisibility().name());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
