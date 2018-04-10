/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.session;

import com.cornerstone.entity.Employee;
import com.cornerstone.entity.Incident;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Kornel
 */
@Stateless
public class IncidentFacade extends AbstractFacade<Incident> implements IncidentFacadeLocal {

    @PersistenceContext(unitName = "com.cornerstone_CSApp-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IncidentFacade() {
        super(Incident.class);
    }

    @Override
    public List<Incident> findByOwnerID(Employee id) {
        Query q = em.createNamedQuery("Incident.findByOwner");
        q.setParameter("owner", id);
        return q.getResultList();
    }

    @Override
    public List<Incident> findByOwnerID(Integer id) {
        Query empQuery = em.createNamedQuery("Employee.findByEmployeeID").setParameter("employeeID", id);
        Query incQuery = em.createNamedQuery("Incident.findByOwner").setParameter("owner", empQuery.getSingleResult());
        return incQuery.getResultList();
    }

    @Override
    public List<Incident> findAllInEmployeesGroups(Integer id) {
        List<Incident> result = new ArrayList<>();
        Query employee = em.createNamedQuery("Employee.findByEmployeeID").setParameter("employeeID", id);
        Query empGroups = em.createNamedQuery("GroupPermission.findByEmployeeID").setParameter("employeeID", employee.getSingleResult());
        Query incForGroup = em.createNamedQuery("Incident.findByGroupID");
        for(Object groupID : empGroups.getResultList()){
            incForGroup.setParameter("groupID", groupID);
            result.addAll(incForGroup.getResultList());
        }
        return result;
    }
    
    
    
    
    
}
