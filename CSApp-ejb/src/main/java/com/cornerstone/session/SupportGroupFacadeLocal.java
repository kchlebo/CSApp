/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.session;

import com.cornerstone.entity.SupportGroup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kornel
 */
@Local
public interface SupportGroupFacadeLocal {

    void create(SupportGroup supportGroup);

    void edit(SupportGroup supportGroup);

    void remove(SupportGroup supportGroup);

    SupportGroup find(Object id);

    List<SupportGroup> findAll();

    List<SupportGroup> findRange(int[] range);

    int count();
    
}
