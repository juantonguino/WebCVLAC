/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session.beans;

import com.entidades.NivelFormacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juandiego
 */
@Stateless
public class NivelFormacionFacade extends AbstractFacade<NivelFormacion> {
    @PersistenceContext(unitName = "WebCVLACPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NivelFormacionFacade() {
        super(NivelFormacion.class);
    }
    
}
