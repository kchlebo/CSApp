/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kornel
 */
@Entity
@Table(name = "IncidentStatusHistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IncidentStatusHistory.findAll", query = "SELECT i FROM IncidentStatusHistory i")
    , @NamedQuery(name = "IncidentStatusHistory.findByIncidentStatusHistoryID", query = "SELECT i FROM IncidentStatusHistory i WHERE i.incidentStatusHistoryID = :incidentStatusHistoryID")
    , @NamedQuery(name = "IncidentStatusHistory.findByStatusStart", query = "SELECT i FROM IncidentStatusHistory i WHERE i.statusStart = :statusStart")
    , @NamedQuery(name = "IncidentStatusHistory.findByIncidentStatus", query = "SELECT i FROM IncidentStatusHistory i WHERE i.incidentStatus = :incidentStatus")})
public class IncidentStatusHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IncidentStatusHistoryID", nullable = false)
    private Integer incidentStatusHistoryID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "StatusStart", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date statusStart;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IncidentStatus", nullable = false, length = 15)
    private String incidentStatus;
    @JoinColumn(name = "IncidentID", referencedColumnName = "IncidentID", nullable = false)
    @ManyToOne(optional = false)
    private Incident incidentID;

    public IncidentStatusHistory() {
    }

    public IncidentStatusHistory(Integer incidentStatusHistoryID) {
        this.incidentStatusHistoryID = incidentStatusHistoryID;
    }

    public IncidentStatusHistory(Integer incidentStatusHistoryID, Date statusStart, String incidentStatus) {
        this.incidentStatusHistoryID = incidentStatusHistoryID;
        this.statusStart = statusStart;
        this.incidentStatus = incidentStatus;
    }

    public Integer getIncidentStatusHistoryID() {
        return incidentStatusHistoryID;
    }

    public void setIncidentStatusHistoryID(Integer incidentStatusHistoryID) {
        this.incidentStatusHistoryID = incidentStatusHistoryID;
    }

    public Date getStatusStart() {
        return statusStart;
    }

    public void setStatusStart(Date statusStart) {
        this.statusStart = statusStart;
    }

    public String getIncidentStatus() {
        return incidentStatus;
    }

    public void setIncidentStatus(String incidentStatus) {
        this.incidentStatus = incidentStatus;
    }

    public Incident getIncidentID() {
        return incidentID;
    }

    public void setIncidentID(Incident incidentID) {
        this.incidentID = incidentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incidentStatusHistoryID != null ? incidentStatusHistoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IncidentStatusHistory)) {
            return false;
        }
        IncidentStatusHistory other = (IncidentStatusHistory) object;
        if ((this.incidentStatusHistoryID == null && other.incidentStatusHistoryID != null) || (this.incidentStatusHistoryID != null && !this.incidentStatusHistoryID.equals(other.incidentStatusHistoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cornerstone.datamodel.IncidentStatusHistory[ incidentStatusHistoryID=" + incidentStatusHistoryID + " ]";
    }
    
}
