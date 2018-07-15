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
@Table(name = "People")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "People.findAll", query = "SELECT p FROM People p")
    , @NamedQuery(name = "People.findByPeopleID", query = "SELECT p FROM People p WHERE p.peopleID = :peopleID")
    , @NamedQuery(name = "People.findByFirstName", query = "SELECT p FROM People p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "People.findByLastName", query = "SELECT p FROM People p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "People.findByEmailAddress", query = "SELECT p FROM People p WHERE p.emailAddress = :emailAddress")
    , @NamedQuery(name = "People.findByPhoneNumber", query = "SELECT p FROM People p WHERE p.phoneNumber = :phoneNumber")})
public class People implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PeopleID", nullable = false)
    private Integer peopleID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FirstName", nullable = false, length = 255)
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LastName", nullable = false, length = 255)
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EmailAddress", nullable = false, length = 255)
    private String emailAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PhoneNumber", nullable = false, length = 50)
    private String phoneNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peopleID")
    private Collection<Customer> customerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peopleID")
    private Collection<Employee> employeeCollection;

    public People() {
    }

    public People(Integer peopleID) {
        this.peopleID = peopleID;
    }

    public People(Integer peopleID, String firstName, String lastName, String emailAddress, String phoneNumber) {
        this.peopleID = peopleID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public Integer getPeopleID() {
        return peopleID;
    }

    public void setPeopleID(Integer peopleID) {
        this.peopleID = peopleID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peopleID != null ? peopleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof People)) {
            return false;
        }
        People other = (People) object;
        if ((this.peopleID == null && other.peopleID != null) || (this.peopleID != null && !this.peopleID.equals(other.peopleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cornerstone.datamodel.People[ peopleID=" + peopleID + " ]";
    }
    
}
