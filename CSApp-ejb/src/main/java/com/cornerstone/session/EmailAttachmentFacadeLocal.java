/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.session;

import com.cornerstone.entity.EmailAttachment;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kornel
 */
@Local
public interface EmailAttachmentFacadeLocal {

    void create(EmailAttachment emailAttachment);

    void edit(EmailAttachment emailAttachment);

    void remove(EmailAttachment emailAttachment);

    EmailAttachment find(Object id);

    List<EmailAttachment> findAll();

    List<EmailAttachment> findRange(int[] range);

    int count();
    
}
