/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kornel
 */
@Entity
@Table(name = "EmailAttachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailAttachment.findAll", query = "SELECT e FROM EmailAttachment e")
    , @NamedQuery(name = "EmailAttachment.findByEmailAttachmentID", query = "SELECT e FROM EmailAttachment e WHERE e.emailAttachmentID = :emailAttachmentID")
    , @NamedQuery(name = "EmailAttachment.findByFileName", query = "SELECT e FROM EmailAttachment e WHERE e.fileName = :fileName")
    , @NamedQuery(name = "EmailAttachment.findByFileSizeinBytes", query = "SELECT e FROM EmailAttachment e WHERE e.fileSizeinBytes = :fileSizeinBytes")
    , @NamedQuery(name = "EmailAttachment.findByFileLocation", query = "SELECT e FROM EmailAttachment e WHERE e.fileLocation = :fileLocation")})
public class EmailAttachment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EmailAttachmentID", nullable = false)
    private Integer emailAttachmentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "FileName", nullable = false, length = 1000)
    private String fileName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FileSizeinBytes", nullable = false)
    private int fileSizeinBytes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FileLocation", nullable = false, length = 255)
    private String fileLocation;
    @JoinColumn(name = "EmailID", referencedColumnName = "EmailID", nullable = false)
    @ManyToOne(optional = false)
    private Email emailID;

    public EmailAttachment() {
    }

    public EmailAttachment(Integer emailAttachmentID) {
        this.emailAttachmentID = emailAttachmentID;
    }

    public EmailAttachment(Integer emailAttachmentID, String fileName, int fileSizeinBytes, String fileLocation) {
        this.emailAttachmentID = emailAttachmentID;
        this.fileName = fileName;
        this.fileSizeinBytes = fileSizeinBytes;
        this.fileLocation = fileLocation;
    }

    public Integer getEmailAttachmentID() {
        return emailAttachmentID;
    }

    public void setEmailAttachmentID(Integer emailAttachmentID) {
        this.emailAttachmentID = emailAttachmentID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSizeinBytes() {
        return fileSizeinBytes;
    }

    public void setFileSizeinBytes(int fileSizeinBytes) {
        this.fileSizeinBytes = fileSizeinBytes;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Email getEmailID() {
        return emailID;
    }

    public void setEmailID(Email emailID) {
        this.emailID = emailID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailAttachmentID != null ? emailAttachmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EmailAttachment)) {
            return false;
        }
        EmailAttachment other = (EmailAttachment) object;
        if ((this.emailAttachmentID == null && other.emailAttachmentID != null) || (this.emailAttachmentID != null && !this.emailAttachmentID.equals(other.emailAttachmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cornerstone.datamodel.EmailAttachment[ emailAttachmentID=" + emailAttachmentID + " ]";
    }
    
}
