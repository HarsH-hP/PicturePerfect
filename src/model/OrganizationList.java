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
@Table(name = "organization_list")
@NamedQueries({
    @NamedQuery(name = "OrganizationList.findAll", query = "SELECT o FROM OrganizationList o"),
    @NamedQuery(name = "OrganizationList.findByOrgId", query = "SELECT o FROM OrganizationList o WHERE o.orgId = :orgId"),
    @NamedQuery(name = "OrganizationList.findByOrgType", query = "SELECT o FROM OrganizationList o WHERE o.orgType = :orgType")})
public class OrganizationList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "org_id")
    private Integer orgId;
    @Basic(optional = false)
    @Column(name = "org_type")
    private String orgType;

    public OrganizationList() {
    }

    public OrganizationList(Integer orgId) {
        this.orgId = orgId;
    }

    public OrganizationList(Integer orgId, String orgType) {
        this.orgId = orgId;
        this.orgType = orgType;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orgId != null ? orgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrganizationList)) {
            return false;
        }
        OrganizationList other = (OrganizationList) object;
        if ((this.orgId == null && other.orgId != null) || (this.orgId != null && !this.orgId.equals(other.orgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.OrganizationList[ orgId=" + orgId + " ]";
    }
    
}
