/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.datamodel;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "Employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByEmployeeID", query = "SELECT e FROM Employee e WHERE e.employeeID = :employeeID")
    , @NamedQuery(name = "Employee.findByUserName", query = "SELECT e FROM Employee e WHERE e.userName = :userName")
    , @NamedQuery(name = "Employee.findBySalt", query = "SELECT e FROM Employee e WHERE e.salt = :salt")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EmployeeID", nullable = false)
    private Integer employeeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "UserName", nullable = false, length = 255)
    private String userName;
    @Lob
    @Column(name = "PasswordHash")
    private byte[] passwordHash;
    @Size(max = 36)
    @Column(name = "Salt", length = 36)
    private String salt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeID")
    private Collection<IncidentWorklog> incidentWorklogCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeID")
    private Collection<GroupPermission> groupPermissionCollection;
    @JoinColumn(name = "PeopleID", referencedColumnName = "PeopleID", nullable = false)
    @ManyToOne(optional = false)
    private People peopleID;
    @JoinColumn(name = "RoleID", referencedColumnName = "RoleID", nullable = false)
    @ManyToOne(optional = false)
    private Role roleID;
    @OneToMany(mappedBy = "owner")
    private Collection<Incident> incidentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "submittedBy")
    private Collection<Incident> incidentCollection1;

    public Employee() {
    }

    public Employee(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Employee(Integer employeeID, String userName) {
        this.employeeID = employeeID;
        this.userName = userName;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @XmlTransient
    public Collection<IncidentWorklog> getIncidentWorklogCollection() {
        return incidentWorklogCollection;
    }

    public void setIncidentWorklogCollection(Collection<IncidentWorklog> incidentWorklogCollection) {
        this.incidentWorklogCollection = incidentWorklogCollection;
    }

    @XmlTransient
    public Collection<GroupPermission> getGroupPermissionCollection() {
        return groupPermissionCollection;
    }

    public void setGroupPermissionCollection(Collection<GroupPermission> groupPermissionCollection) {
        this.groupPermissionCollection = groupPermissionCollection;
    }

    public People getPeopleID() {
        return peopleID;
    }

    public void setPeopleID(People peopleID) {
        this.peopleID = peopleID;
    }

    public Role getRoleID() {
        return roleID;
    }

    public void setRoleID(Role roleID) {
        this.roleID = roleID;
    }

    @XmlTransient
    public Collection<Incident> getIncidentCollection() {
        return incidentCollection;
    }

    public void setIncidentCollection(Collection<Incident> incidentCollection) {
        this.incidentCollection = incidentCollection;
    }

    @XmlTransient
    public Collection<Incident> getIncidentCollection1() {
        return incidentCollection1;
    }

    public void setIncidentCollection1(Collection<Incident> incidentCollection1) {
        this.incidentCollection1 = incidentCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeID != null ? employeeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeID == null && other.employeeID != null) || (this.employeeID != null && !this.employeeID.equals(other.employeeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cornerstone.datamodel.Employee[ employeeID=" + employeeID + " ]";
    }
    
}
