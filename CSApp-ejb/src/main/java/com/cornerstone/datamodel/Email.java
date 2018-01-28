/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.datamodel;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kornel
 */
@Entity
@Table(name = "Email")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e")
    , @NamedQuery(name = "Email.findByEmailID", query = "SELECT e FROM Email e WHERE e.emailID = :emailID")
    , @NamedQuery(name = "Email.findBySubject", query = "SELECT e FROM Email e WHERE e.subject = :subject")
    , @NamedQuery(name = "Email.findByBody", query = "SELECT e FROM Email e WHERE e.body = :body")
    , @NamedQuery(name = "Email.findByReceivedAt", query = "SELECT e FROM Email e WHERE e.receivedAt = :receivedAt")})
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EmailID", nullable = false)
    private Integer emailID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Subject", nullable = false, length = 255)
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Body", nullable = false, length = 2147483647)
    private String body;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReceivedAt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedAt;
    @JoinColumn(name = "EmailSenderAndRecipientsID", referencedColumnName = "EmailSenderAndRecipientsID", nullable = false)
    @ManyToOne(optional = false)
    private EmailSenderAndRecipients emailSenderAndRecipientsID;
    @JoinColumn(name = "IncidentID", referencedColumnName = "IncidentID", nullable = false)
    @ManyToOne(optional = false)
    private Incident incidentID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emailID")
    private Collection<EmailAttachment> emailAttachmentCollection;

    public Email() {
    }

    public Email(Integer emailID) {
        this.emailID = emailID;
    }

    public Email(Integer emailID, String subject, String body, Date receivedAt) {
        this.emailID = emailID;
        this.subject = subject;
        this.body = body;
        this.receivedAt = receivedAt;
    }

    public Integer getEmailID() {
        return emailID;
    }

    public void setEmailID(Integer emailID) {
        this.emailID = emailID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(Date receivedAt) {
        this.receivedAt = receivedAt;
    }

    public EmailSenderAndRecipients getEmailSenderAndRecipientsID() {
        return emailSenderAndRecipientsID;
    }

    public void setEmailSenderAndRecipientsID(EmailSenderAndRecipients emailSenderAndRecipientsID) {
        this.emailSenderAndRecipientsID = emailSenderAndRecipientsID;
    }

    public Incident getIncidentID() {
        return incidentID;
    }

    public void setIncidentID(Incident incidentID) {
        this.incidentID = incidentID;
    }

    @XmlTransient
    public Collection<EmailAttachment> getEmailAttachmentCollection() {
        return emailAttachmentCollection;
    }

    public void setEmailAttachmentCollection(Collection<EmailAttachment> emailAttachmentCollection) {
        this.emailAttachmentCollection = emailAttachmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailID != null ? emailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.emailID == null && other.emailID != null) || (this.emailID != null && !this.emailID.equals(other.emailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cornerstone.datamodel.Email[ emailID=" + emailID + " ]";
    }
    
}
