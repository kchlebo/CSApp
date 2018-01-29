/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cornerstone.entity;

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
@Table(name = "Incident")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incident.findAll", query = "SELECT i FROM Incident i")
    , @NamedQuery(name = "Incident.findByIncidentID", query = "SELECT i FROM Incident i WHERE i.incidentID = :incidentID")
    , @NamedQuery(name = "Incident.findByIncidentStatus", query = "SELECT i FROM Incident i WHERE i.incidentStatus = :incidentStatus")
    , @NamedQuery(name = "Incident.findByPriority", query = "SELECT i FROM Incident i WHERE i.priority = :priority")
    , @NamedQuery(name = "Incident.findByDescription", query = "SELECT i FROM Incident i WHERE i.description = :description")
    , @NamedQuery(name = "Incident.findByCreatedAt", query = "SELECT i FROM Incident i WHERE i.createdAt = :createdAt")
    , @NamedQuery(name = "Incident.findByClosedAt", query = "SELECT i FROM Incident i WHERE i.closedAt = :closedAt")})
public class Incident implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IncidentID", nullable = false)
    private Integer incidentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IncidentStatus", nullable = false, length = 15)
    private String incidentStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Priority", nullable = false, length = 15)
    private String priority;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Description", nullable = false, length = 255)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedAt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "ClosedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentID")
    private Collection<Email> emailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentID")
    private Collection<IncidentWorklog> incidentWorklogCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentID")
    private Collection<IncidentStatusHistory> incidentStatusHistoryCollection;
    @JoinColumn(name = "Owner", referencedColumnName = "EmployeeID")
    @ManyToOne
    private Employee owner;
    @JoinColumn(name = "SubmittedBy", referencedColumnName = "EmployeeID", nullable = false)
    @ManyToOne(optional = false)
    private Employee submittedBy;
    @JoinColumn(name = "GroupID", referencedColumnName = "GroupID")
    @ManyToOne
    private Group1 groupID;

    public Incident() {
    }

    public Incident(Integer incidentID) {
        this.incidentID = incidentID;
    }

    public Incident(Integer incidentID, String incidentStatus, String priority, String description, Date createdAt) {
        this.incidentID = incidentID;
        this.incidentStatus = incidentStatus;
        this.priority = priority;
        this.description = description;
        this.createdAt = createdAt;
    }

    public Integer getIncidentID() {
        return incidentID;
    }

    public void setIncidentID(Integer incidentID) {
        this.incidentID = incidentID;
    }

    public String getIncidentStatus() {
        return incidentStatus;
    }

    public void setIncidentStatus(String incidentStatus) {
        this.incidentStatus = incidentStatus;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

    @XmlTransient
    public Collection<Email> getEmailCollection() {
        return emailCollection;
    }

    public void setEmailCollection(Collection<Email> emailCollection) {
        this.emailCollection = emailCollection;
    }

    @XmlTransient
    public Collection<IncidentWorklog> getIncidentWorklogCollection() {
        return incidentWorklogCollection;
    }

    public void setIncidentWorklogCollection(Collection<IncidentWorklog> incidentWorklogCollection) {
        this.incidentWorklogCollection = incidentWorklogCollection;
    }

    @XmlTransient
    public Collection<IncidentStatusHistory> getIncidentStatusHistoryCollection() {
        return incidentStatusHistoryCollection;
    }

    public void setIncidentStatusHistoryCollection(Collection<IncidentStatusHistory> incidentStatusHistoryCollection) {
        this.incidentStatusHistoryCollection = incidentStatusHistoryCollection;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    public Employee getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(Employee submittedBy) {
        this.submittedBy = submittedBy;
    }

    public Group1 getGroupID() {
        return groupID;
    }

    public void setGroupID(Group1 groupID) {
        this.groupID = groupID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incidentID != null ? incidentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incident)) {
            return false;
        }
        Incident other = (Incident) object;
        if ((this.incidentID == null && other.incidentID != null) || (this.incidentID != null && !this.incidentID.equals(other.incidentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cornerstone.datamodel.Incident[ incidentID=" + incidentID + " ]";
    }

}
