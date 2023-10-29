/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@Table(name = "enterprises_list")
@NamedQueries({
    @NamedQuery(name = "EnterprisesList.findAll", query = "SELECT e FROM EnterprisesList e"),
    @NamedQuery(name = "EnterprisesList.findByEnterpriseId", query = "SELECT e FROM EnterprisesList e WHERE e.enterpriseId = :enterpriseId"),
    @NamedQuery(name = "EnterprisesList.findByEnterpriseName", query = "SELECT e FROM EnterprisesList e WHERE e.enterpriseName = :enterpriseName")})
public class EnterprisesList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "enterprise_id")
    private Integer enterpriseId;
    @Basic(optional = false)
    @Column(name = "enterprise_name")
    private String enterpriseName;

    public EnterprisesList() {
    }

    public EnterprisesList(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public EnterprisesList(Integer enterpriseId, String enterpriseName) {
        this.enterpriseId = enterpriseId;
        this.enterpriseName = enterpriseName;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enterpriseId != null ? enterpriseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnterprisesList)) {
            return false;
        }
        EnterprisesList other = (EnterprisesList) object;
        if ((this.enterpriseId == null && other.enterpriseId != null) || (this.enterpriseId != null && !this.enterpriseId.equals(other.enterpriseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.EnterprisesList[ enterpriseId=" + enterpriseId + " ]";
    }
    
     public ResultSet readEnterprises() {
        ResultSet rs = null;
        try {
            PreparedStatement st;
            Connection connection = (Connection) DBConnection.con();
            st = connection.prepareStatement("SELECT enterprise_id, enterprise_name FROM enterprises_list order by enterprise_id;");
            rs = st.executeQuery();

            return rs;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return rs;
    }
     
    public ResultSet readEnterprises(EnterprisesList e) {
        ResultSet rs = null;
        try {
            PreparedStatement st;
            Connection connection = (Connection) DBConnection.con();
            st = connection.prepareStatement("SELECT enterprise_id, enterprise_name FROM enterprises_list where enterprise_id = ?");
            st.setInt(1, e.getEnterpriseId());
            rs = st.executeQuery();

            return rs;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return rs;
    }
    
}
