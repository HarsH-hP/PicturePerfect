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
@Table(name = "vendor_details")
@NamedQueries({
    @NamedQuery(name = "VendorDetails.findAll", query = "SELECT v FROM VendorDetails v"),
    @NamedQuery(name = "VendorDetails.findByVendorId", query = "SELECT v FROM VendorDetails v WHERE v.vendorId = :vendorId"),
    @NamedQuery(name = "VendorDetails.findByVendorTypeId", query = "SELECT v FROM VendorDetails v WHERE v.vendorTypeId = :vendorTypeId"),
    @NamedQuery(name = "VendorDetails.findByVendorName", query = "SELECT v FROM VendorDetails v WHERE v.vendorName = :vendorName"),
    @NamedQuery(name = "VendorDetails.findByEmail", query = "SELECT v FROM VendorDetails v WHERE v.email = :email"),
    @NamedQuery(name = "VendorDetails.findByPhoneNumber", query = "SELECT v FROM VendorDetails v WHERE v.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "VendorDetails.findByAddrLine1", query = "SELECT v FROM VendorDetails v WHERE v.addrLine1 = :addrLine1"),
    @NamedQuery(name = "VendorDetails.findByAddrLine2", query = "SELECT v FROM VendorDetails v WHERE v.addrLine2 = :addrLine2"),
    @NamedQuery(name = "VendorDetails.findByUsername", query = "SELECT v FROM VendorDetails v WHERE v.username = :username"),
    @NamedQuery(name = "VendorDetails.findByPassword", query = "SELECT v FROM VendorDetails v WHERE v.password = :password"),
    @NamedQuery(name = "VendorDetails.findByRegistrationStatus", query = "SELECT v FROM VendorDetails v WHERE v.registrationStatus = :registrationStatus")})
public class VendorDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vendor_id")
    private Integer vendorId;
    @Basic(optional = false)
    @Column(name = "vendor_type_id")
    private String vendorTypeId;
    @Basic(optional = false)
    @Column(name = "vendor_name")
    private String vendorName;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "addr_line_1")
    private String addrLine1;
    @Basic(optional = false)
    @Column(name = "addr_line_2")
    private String addrLine2;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "registration_status")
    private int registrationStatus;

    public VendorDetails() {
    }

    public VendorDetails(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public VendorDetails(Integer vendorId, String vendorTypeId, String vendorName, String email, String phoneNumber, String addrLine1, String addrLine2, String username, String password, int registrationStatus) {
        this.vendorId = vendorId;
        this.vendorTypeId = vendorTypeId;
        this.vendorName = vendorName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addrLine1 = addrLine1;
        this.addrLine2 = addrLine2;
        this.username = username;
        this.password = password;
        this.registrationStatus = registrationStatus;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorTypeId() {
        return vendorTypeId;
    }

    public void setVendorTypeId(String vendorTypeId) {
        this.vendorTypeId = vendorTypeId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddrLine1() {
        return addrLine1;
    }

    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public String getAddrLine2() {
        return addrLine2;
    }

    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
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

    public int getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(int registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendorId != null ? vendorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendorDetails)) {
            return false;
        }
        VendorDetails other = (VendorDetails) object;
        if ((this.vendorId == null && other.vendorId != null) || (this.vendorId != null && !this.vendorId.equals(other.vendorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.VendorDetails[ vendorId=" + vendorId + " ]";
    }
    public ResultSet readVendorDetails(VendorDetails vendorDetails) {
        ResultSet rs = null;
        String password = vendorDetails.getPassword();
        try {
            PreparedStatement st;
            Connection connection = (Connection) DBConnection.con();
            if (password == null) {
                //System.out.println("DB Check -iF");
                st = connection.prepareStatement("SELECT vendor_id, vendor_type_id, vendor_name, email, phone_number, addr_line_1, addr_line_2, username, password, registration_status FROM vendor_details where username = ? ");
                st.setString(1, vendorDetails.getUsername());
            } else {
                //System.out.println("DB Check -else");
                st = connection.prepareStatement("SELECT vendor_id, vendor_type_id, vendor_name, email, phone_number, addr_line_1, addr_line_2, username, password, registration_status FROM vendor_details where username = ? and password = ?");
                st.setString(1, vendorDetails.getUsername());
                st.setString(2, vendorDetails.getPassword());
            }

            rs = st.executeQuery();

            return rs;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return rs;
    }
    
    public ResultSet loadVendorDetails(VendorDetails vendorDetails) {
        ResultSet rs = null;
        try {
            PreparedStatement st;
            Connection connection = (Connection) DBConnection.con();
            st = connection.prepareStatement("Select vendor_id, vendor_name, concat(addr_line_1,\" \", addr_line_2) as address, email, phone_number from vendor_details where vendor_type_id= ? and registration_status=3 ");
            st.setString(1, vendorDetails.getVendorTypeId());

            rs = st.executeQuery();

            return rs;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return rs;
    }

    public int insertVendorDetails(VendorDetails vd) {

        int returnedValue = 0;
        try {
            Connection connection = (Connection) DBConnection.con();

            String insertTableSQL = "INSERT INTO vendor_details(vendor_id, vendor_type_id, vendor_name, email, phone_number, addr_line_1, addr_line_2, username, password, registration_status) VALUES(?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement st = (PreparedStatement) connection.prepareStatement(insertTableSQL);
            st.setInt(1, vd.getVendorId());
            st.setString(2, vd.getVendorTypeId());
            st.setString(3, vd.getVendorName());
            st.setString(4, vd.getEmail());
            st.setString(5, vd.getPhoneNumber());
            st.setString(6, vd.getAddrLine1());
            st.setString(7, vd.getAddrLine2());
            st.setString(8, vd.getUsername());
            st.setString(9, vd.getPassword());
            st.setInt(10, vd.getRegistrationStatus());

            returnedValue = st.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return returnedValue;
}
    public int updateVendorDetails(VendorDetails vd) {

        int returnedValue = 0;
        try {
            Connection connection = (Connection) DBConnection.con();

            String updateTableSQL = "UPDATE vendor_details SET vendor_name = ?, email = ?, phone_number = ?, addr_line_1= ?, addr_line_2 = ? where username = ?;";
            PreparedStatement st = (PreparedStatement) connection.prepareStatement(updateTableSQL);
            st.setString(1, vd.getVendorName());
            st.setString(2, vd.getEmail());
            st.setString(3, vd.getPhoneNumber());
            st.setString(4, vd.getAddrLine1());
            st.setString(5, vd.getAddrLine2());
            st.setString(6, vd.getUsername());

            returnedValue = st.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return returnedValue;
    }
}
