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
@Table(name = "SupportGroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupportGroup.findAll", query = "SELECT s FROM SupportGroup s")
    , @NamedQuery(name = "SupportGroup.findByGroupID", query = "SELECT s FROM SupportGroup s WHERE s.groupID = :groupID")
    , @NamedQuery(name = "SupportGroup.findByGroupName", query = "SELECT s FROM SupportGroup s WHERE s.groupName = :groupName")})
public class SupportGroup implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupID")
    private Collection<GroupPermission> groupPermissionCollection;
    @OneToMany(mappedBy = "groupID")
    private Collection<Incident> incidentCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GroupID")
    private Integer groupID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "GroupName")
    private String groupName;

    public SupportGroup() {
    }

    public SupportGroup(Integer groupID) {
        this.groupID = groupID;
    }

    public SupportGroup(Integer groupID, String groupName) {
        this.groupID = groupID;
        this.groupName = groupName;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupID != null ? groupID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupportGroup)) {
            return false;
        }
        SupportGroup other = (SupportGroup) object;
        if ((this.groupID == null && other.groupID != null) || (this.groupID != null && !this.groupID.equals(other.groupID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cornerstone.entity.SupportGroup[ groupID=" + groupID + " ]";
    }

    @XmlTransient
    public Collection<GroupPermission> getGroupPermissionCollection() {
        return groupPermissionCollection;
    }

    public void setGroupPermissionCollection(Collection<GroupPermission> groupPermissionCollection) {
        this.groupPermissionCollection = groupPermissionCollection;
    }

    @XmlTransient
    public Collection<Incident> getIncidentCollection() {
        return incidentCollection;
    }

    public void setIncidentCollection(Collection<Incident> incidentCollection) {
        this.incidentCollection = incidentCollection;
    }
    
}
