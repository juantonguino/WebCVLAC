/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session.beans;

import com.entidades.PonenciaAutor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juandiego
 */
@Stateless
public class PonenciaAutorFacade extends AbstractFacade<PonenciaAutor> {
    @PersistenceContext(unitName = "WebCVLACPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PonenciaAutorFacade() {
        super(PonenciaAutor.class);
    }
    
}
