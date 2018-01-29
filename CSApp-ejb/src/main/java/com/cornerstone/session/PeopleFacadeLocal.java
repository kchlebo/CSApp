/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.session;

import com.cornerstone.entity.People;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kornel
 */
@Local
public interface PeopleFacadeLocal {

    void create(People people);

    void edit(People people);

    void remove(People people);

    People find(Object id);

    List<People> findAll();

    List<People> findRange(int[] range);

    int count();
    
}
