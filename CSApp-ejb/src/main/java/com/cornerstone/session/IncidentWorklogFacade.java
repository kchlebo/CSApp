/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.session;

import com.cornerstone.entity.IncidentWorklog;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kornel
 */
@Stateless
public class IncidentWorklogFacade extends AbstractFacade<IncidentWorklog> implements IncidentWorklogFacadeLocal {

    @PersistenceContext(unitName = "com.cornerstone_CSApp-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IncidentWorklogFacade() {
        super(IncidentWorklog.class);
    }
    
}
