/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.session;

import com.cornerstone.entity.EmailSenderAndRecipients;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kornel
 */
@Local
public interface EmailSenderAndRecipientsFacadeLocal {

    void create(EmailSenderAndRecipients emailSenderAndRecipients);

    void edit(EmailSenderAndRecipients emailSenderAndRecipients);

    void remove(EmailSenderAndRecipients emailSenderAndRecipients);

    EmailSenderAndRecipients find(Object id);

    List<EmailSenderAndRecipients> findAll();

    List<EmailSenderAndRecipients> findRange(int[] range);

    int count();
    
}
