/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.datamodel;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kornel
 */
@Entity
@Table(name = "GroupPermission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupPermission.findAll", query = "SELECT g FROM GroupPermission g")
    , @NamedQuery(name = "GroupPermission.findByGroupPermissionID", query = "SELECT g FROM GroupPermission g WHERE g.groupPermissionID = :groupPermissionID")})
public class GroupPermission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GroupPermissionID", nullable = false)
    private Integer groupPermissionID;
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID", nullable = false)
    @ManyToOne(optional = false)
    private Employee employeeID;
    @JoinColumn(name = "GroupID", referencedColumnName = "GroupID", nullable = false)
    @ManyToOne(optional = false)
    private Group1 groupID;

    public GroupPermission() {
    }

    public GroupPermission(Integer groupPermissionID) {
        this.groupPermissionID = groupPermissionID;
    }

    public Integer getGroupPermissionID() {
        return groupPermissionID;
    }

    public void setGroupPermissionID(Integer groupPermissionID) {
        this.groupPermissionID = groupPermissionID;
    }

    public Employee getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employee employeeID) {
        this.employeeID = employeeID;
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
        hash += (groupPermissionID != null ? groupPermissionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupPermission)) {
            return false;
        }
        GroupPermission other = (GroupPermission) object;
        if ((this.groupPermissionID == null && other.groupPermissionID != null) || (this.groupPermissionID != null && !this.groupPermissionID.equals(other.groupPermissionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cornerstone.datamodel.GroupPermission[ groupPermissionID=" + groupPermissionID + " ]";
    }
    
}
