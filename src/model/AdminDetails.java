/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author nihar
 */
@Entity
@Table(name = "admin_details")
@NamedQueries({
    @NamedQuery(name = "AdminDetails.findAll", query = "SELECT a FROM AdminDetails a"),
    @NamedQuery(name = "AdminDetails.findByAdminId", query = "SELECT a FROM AdminDetails a WHERE a.adminId = :adminId"),
    @NamedQuery(name = "AdminDetails.findByUsername", query = "SELECT a FROM AdminDetails a WHERE a.username = :username"),
    @NamedQuery(name = "AdminDetails.findByPassword", query = "SELECT a FROM AdminDetails a WHERE a.password = :password")})
public class AdminDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "admin_id")
    private Integer adminId;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    public AdminDetails() {
    }

    public AdminDetails(Integer adminId) {
        this.adminId = adminId;
    }

    public AdminDetails(Integer adminId, String username, String password) {
        this.adminId = adminId;
        this.username = username;
        this.password = password;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminDetails)) {
            return false;
        }
        AdminDetails other = (AdminDetails) object;
        if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AdminDetails[ adminId=" + adminId + " ]";
    }
    
}
