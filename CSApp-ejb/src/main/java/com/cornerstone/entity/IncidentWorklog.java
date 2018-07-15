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
@Table(name = "IncidentWorklog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IncidentWorklog.findAll", query = "SELECT i FROM IncidentWorklog i")
    , @NamedQuery(name = "IncidentWorklog.findByIncidentWorklogID", query = "SELECT i FROM IncidentWorklog i WHERE i.incidentWorklogID = :incidentWorklogID")
    , @NamedQuery(name = "IncidentWorklog.findByNotes", query = "SELECT i FROM IncidentWorklog i WHERE i.notes = :notes")
    , @NamedQuery(name = "IncidentWorklog.findByDate", query = "SELECT i FROM IncidentWorklog i WHERE i.date = :date")})
public class IncidentWorklog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IncidentWorklogID", nullable = false)
    private Integer incidentWorklogID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Notes", nullable = false, length = 2147483647)
    private String notes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID", nullable = false)
    @ManyToOne(optional = false)
    private Employee employeeID;
    @JoinColumn(name = "IncidentID", referencedColumnName = "IncidentID", nullable = false)
    @ManyToOne(optional = false)
    private Incident incidentID;

    public IncidentWorklog() {
    }

    public IncidentWorklog(Integer incidentWorklogID) {
        this.incidentWorklogID = incidentWorklogID;
    }

    public IncidentWorklog(Integer incidentWorklogID, String notes, Date date) {
        this.incidentWorklogID = incidentWorklogID;
        this.notes = notes;
        this.date = date;
    }

    public Integer getIncidentWorklogID() {
        return incidentWorklogID;
    }

    public void setIncidentWorklogID(Integer incidentWorklogID) {
        this.incidentWorklogID = incidentWorklogID;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employee employeeID) {
        this.employeeID = employeeID;
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
        hash += (incidentWorklogID != null ? incidentWorklogID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof IncidentWorklog)) {
            return false;
        }
        IncidentWorklog other = (IncidentWorklog) object;
        if ((this.incidentWorklogID == null && other.incidentWorklogID != null) || (this.incidentWorklogID != null && !this.incidentWorklogID.equals(other.incidentWorklogID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cornerstone.datamodel.IncidentWorklog[ incidentWorklogID=" + incidentWorklogID + " ]";
    }
    
}
