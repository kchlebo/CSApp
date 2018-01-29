/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.session;

import com.cornerstone.entity.Group1;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kornel
 */
@Local
public interface Group1FacadeLocal {

    void create(Group1 group1);

    void edit(Group1 group1);

    void remove(Group1 group1);

    Group1 find(Object id);

    List<Group1> findAll();

    List<Group1> findRange(int[] range);

    int count();
    
}
