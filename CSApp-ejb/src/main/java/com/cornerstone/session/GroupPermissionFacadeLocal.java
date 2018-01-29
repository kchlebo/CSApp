/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.session;

import com.cornerstone.entity.GroupPermission;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kornel
 */
@Local
public interface GroupPermissionFacadeLocal {

    void create(GroupPermission groupPermission);

    void edit(GroupPermission groupPermission);

    void remove(GroupPermission groupPermission);

    GroupPermission find(Object id);

    List<GroupPermission> findAll();

    List<GroupPermission> findRange(int[] range);

    int count();
    
}
