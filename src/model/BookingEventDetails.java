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
@Table(name = "booking_event_details")
@NamedQueries({
    @NamedQuery(name = "BookingEventDetails.findAll", query = "SELECT b FROM BookingEventDetails b"),
    @NamedQuery(name = "BookingEventDetails.findByBookEventId", query = "SELECT b FROM BookingEventDetails b WHERE b.bookEventId = :bookEventId"),
    @NamedQuery(name = "BookingEventDetails.findByBookingId", query = "SELECT b FROM BookingEventDetails b WHERE b.bookingId = :bookingId"),
    @NamedQuery(name = "BookingEventDetails.findByOrgId", query = "SELECT b FROM BookingEventDetails b WHERE b.orgId = :orgId"),
    @NamedQuery(name = "BookingEventDetails.findByVendorId", query = "SELECT b FROM BookingEventDetails b WHERE b.vendorId = :vendorId"),
    @NamedQuery(name = "BookingEventDetails.findByStatus", query = "SELECT b FROM BookingEventDetails b WHERE b.status = :status")})
public class BookingEventDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "book_event_id")
    private Integer bookEventId;
    @Basic(optional = false)
    @Column(name = "booking_id")
    private int bookingId;
    @Basic(optional = false)
    @Column(name = "org_id")
    private int orgId;
    @Basic(optional = false)
    @Column(name = "vendor_id")
    private int vendorId;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "cancellation_reason")
    private String cancellationReason;

    public BookingEventDetails() {
    }

    public BookingEventDetails(Integer bookEventId) {
        this.bookEventId = bookEventId;
    }

    public BookingEventDetails(Integer bookEventId, int bookingId, int orgId, int vendorId, int status, String cancellationReason) {
        this.bookEventId = bookEventId;
        this.bookingId = bookingId;
        this.orgId = orgId;
        this.vendorId = vendorId;
        this.status = status;
        this.cancellationReason = cancellationReason;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public Integer getBookEventId() {
        return bookEventId;
    }

    public void setBookEventId(Integer bookEventId) {
        this.bookEventId = bookEventId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookEventId != null ? bookEventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingEventDetails)) {
            return false;
        }
        BookingEventDetails other = (BookingEventDetails) object;
        if ((this.bookEventId == null && other.bookEventId != null) || (this.bookEventId != null && !this.bookEventId.equals(other.bookEventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.BookingEventDetails[ bookEventId=" + bookEventId + " ]";
    }
    
    public int insertBookingEventDetails(BookingEventDetails bed) {

        int returnedValue = 0;
        int bookingEventId = 0;
        try {
            Connection connection = (Connection) DBConnection.con();

            String insertTableSQL = "INSERT INTO booking_event_details(booking_id, org_id, vendor_id, status) VALUES(?,?,?,?);";
            PreparedStatement st = (PreparedStatement) connection.prepareStatement(insertTableSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setInt(1, bed.getBookingId());
            st.setInt(2,bed.getOrgId());
            st.setInt(3,bed.getVendorId());
            st.setInt(4, bed.getStatus());
            
            returnedValue = st.executeUpdate();

            if (returnedValue > 0) {
                ResultSet rs = st.getGeneratedKeys(); // fetches newly inserted primary key

                if (rs.next()) {
                    bookingEventId = rs.getInt(1);
                }

            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        // returns newly generated booking event Id
        return bookingEventId;
    }
    
}
