/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.session;

import com.cornerstone.entity.IncidentStatusHistory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kornel
 */
@Local
public interface IncidentStatusHistoryFacadeLocal {

    void create(IncidentStatusHistory incidentStatusHistory);

    void edit(IncidentStatusHistory incidentStatusHistory);

    void remove(IncidentStatusHistory incidentStatusHistory);

    IncidentStatusHistory find(Object id);

    List<IncidentStatusHistory> findAll();

    List<IncidentStatusHistory> findRange(int[] range);

    int count();
    
}
