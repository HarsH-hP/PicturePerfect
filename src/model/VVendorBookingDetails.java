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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nihar
 */
@Entity
@Table(name = "v_vendor_booking_details")
@NamedQueries({
    @NamedQuery(name = "VVendorBookingDetails.findAll", query = "SELECT v FROM VVendorBookingDetails v"),
    @NamedQuery(name = "VVendorBookingDetails.findByBookingId", query = "SELECT v FROM VVendorBookingDetails v WHERE v.bookingId = :bookingId"),
    @NamedQuery(name = "VVendorBookingDetails.findByBookingDate", query = "SELECT v FROM VVendorBookingDetails v WHERE v.bookingDate = :bookingDate"),
    @NamedQuery(name = "VVendorBookingDetails.findByVendorId", query = "SELECT v FROM VVendorBookingDetails v WHERE v.vendorId = :vendorId"),
    @NamedQuery(name = "VVendorBookingDetails.findByStatus", query = "SELECT v FROM VVendorBookingDetails v WHERE v.status = :status"),
    @NamedQuery(name = "VVendorBookingDetails.findByUsername", query = "SELECT v FROM VVendorBookingDetails v WHERE v.username = :username")})
public class VVendorBookingDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "booking_id")
    
    @Id
    private int bookingId;
    @Basic(optional = false)
    @Column(name = "booking_date")
    @Temporal(TemporalType.DATE)
    private Date bookingDate;
    @Column(name = "vendor_id")
    private Integer vendorId;
    @Column(name = "status")
    private Integer status;
    @Column(name = "username")
    private String username;

    public VVendorBookingDetails() {
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public int getVendorIdFromDB(VVendorBookingDetails vendorbookingDetails) {
        int vendorId = 0;
        ResultSet rs = null;
        try {
            PreparedStatement st;
            Connection connection = (Connection) DBConnection.con();
            st = connection.prepareStatement("Select vendor_id from v_vendor_booking_details where vendor_id = ? and booking_date=? and status in (1, 3);");
                st.setInt(1, vendorbookingDetails.getVendorId());
                st.setDate(2, new java.sql.Date(vendorbookingDetails.getBookingDate().getTime()));

            rs = st.executeQuery();
            
            while(rs.next()){
              vendorId = rs.getInt(1);
            }

            return vendorId;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return vendorId;
    }
}
