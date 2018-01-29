/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kornel
 */
@Entity
@Table(name = "EmailSenderAndRecipients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailSenderAndRecipients.findAll", query = "SELECT e FROM EmailSenderAndRecipients e")
    , @NamedQuery(name = "EmailSenderAndRecipients.findByEmailSenderAndRecipientsID", query = "SELECT e FROM EmailSenderAndRecipients e WHERE e.emailSenderAndRecipientsID = :emailSenderAndRecipientsID")
    , @NamedQuery(name = "EmailSenderAndRecipients.findByEmailContactType", query = "SELECT e FROM EmailSenderAndRecipients e WHERE e.emailContactType = :emailContactType")
    , @NamedQuery(name = "EmailSenderAndRecipients.findByEmailAddress", query = "SELECT e FROM EmailSenderAndRecipients e WHERE e.emailAddress = :emailAddress")})
public class EmailSenderAndRecipients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EmailSenderAndRecipientsID", nullable = false)
    private Integer emailSenderAndRecipientsID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EmailContactType", nullable = false, length = 50)
    private String emailContactType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EmailAddress", nullable = false, length = 255)
    private String emailAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emailSenderAndRecipientsID")
    private Collection<Email> emailCollection;

    public EmailSenderAndRecipients() {
    }

    public EmailSenderAndRecipients(Integer emailSenderAndRecipientsID) {
        this.emailSenderAndRecipientsID = emailSenderAndRecipientsID;
    }

    public EmailSenderAndRecipients(Integer emailSenderAndRecipientsID, String emailContactType, String emailAddress) {
        this.emailSenderAndRecipientsID = emailSenderAndRecipientsID;
        this.emailContactType = emailContactType;
        this.emailAddress = emailAddress;
    }

    public Integer getEmailSenderAndRecipientsID() {
        return emailSenderAndRecipientsID;
    }

    public void setEmailSenderAndRecipientsID(Integer emailSenderAndRecipientsID) {
        this.emailSenderAndRecipientsID = emailSenderAndRecipientsID;
    }

    public String getEmailContactType() {
        return emailContactType;
    }

    public void setEmailContactType(String emailContactType) {
        this.emailContactType = emailContactType;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @XmlTransient
    public Collection<Email> getEmailCollection() {
        return emailCollection;
    }

    public void setEmailCollection(Collection<Email> emailCollection) {
        this.emailCollection = emailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailSenderAndRecipientsID != null ? emailSenderAndRecipientsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailSenderAndRecipients)) {
            return false;
        }
        EmailSenderAndRecipients other = (EmailSenderAndRecipients) object;
        if ((this.emailSenderAndRecipientsID == null && other.emailSenderAndRecipientsID != null) || (this.emailSenderAndRecipientsID != null && !this.emailSenderAndRecipientsID.equals(other.emailSenderAndRecipientsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cornerstone.datamodel.EmailSenderAndRecipients[ emailSenderAndRecipientsID=" + emailSenderAndRecipientsID + " ]";
    }
    
}
