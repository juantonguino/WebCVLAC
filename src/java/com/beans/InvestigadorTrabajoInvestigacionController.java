package com.beans;

import com.entidades.InvestigadorTrabajoInvestigacion;
import com.beans.util.JsfUtil;
import com.beans.util.JsfUtil.PersistAction;
import com.session.beans.InvestigadorTrabajoInvestigacionFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "investigadorTrabajoInvestigacionController")
@SessionScoped
public class InvestigadorTrabajoInvestigacionController implements Serializable {

    @EJB
    private com.session.beans.InvestigadorTrabajoInvestigacionFacade ejbFacade;
    private List<InvestigadorTrabajoInvestigacion> items = null;
    private InvestigadorTrabajoInvestigacion selected;

    public InvestigadorTrabajoInvestigacionController() {
    }

    public InvestigadorTrabajoInvestigacion getSelected() {
        return selected;
    }

    public void setSelected(InvestigadorTrabajoInvestigacion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private InvestigadorTrabajoInvestigacionFacade getFacade() {
        return ejbFacade;
    }

    public InvestigadorTrabajoInvestigacion prepareCreate() {
        selected = new InvestigadorTrabajoInvestigacion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("InvestigadorTrabajoInvestigacionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("InvestigadorTrabajoInvestigacionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("InvestigadorTrabajoInvestigacionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<InvestigadorTrabajoInvestigacion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<InvestigadorTrabajoInvestigacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<InvestigadorTrabajoInvestigacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = InvestigadorTrabajoInvestigacion.class)
    public static class InvestigadorTrabajoInvestigacionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InvestigadorTrabajoInvestigacionController controller = (InvestigadorTrabajoInvestigacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "investigadorTrabajoInvestigacionController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof InvestigadorTrabajoInvestigacion) {
                InvestigadorTrabajoInvestigacion o = (InvestigadorTrabajoInvestigacion) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), InvestigadorTrabajoInvestigacion.class.getName()});
                return null;
            }
        }

    }

}
