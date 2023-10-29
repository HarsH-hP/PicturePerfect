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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "booking_details")
@NamedQueries({
    @NamedQuery(name = "BookingDetails.findAll", query = "SELECT b FROM BookingDetails b"),
    @NamedQuery(name = "BookingDetails.findByBookingId", query = "SELECT b FROM BookingDetails b WHERE b.bookingId = :bookingId"),
    @NamedQuery(name = "BookingDetails.findByUserId", query = "SELECT b FROM BookingDetails b WHERE b.userId = :userId"),
    @NamedQuery(name = "BookingDetails.findByEventType", query = "SELECT b FROM BookingDetails b WHERE b.eventType = :eventType"),
    @NamedQuery(name = "BookingDetails.findByBookingDate", query = "SELECT b FROM BookingDetails b WHERE b.bookingDate = :bookingDate"),
    @NamedQuery(name = "BookingDetails.findBySpecialRequest", query = "SELECT b FROM BookingDetails b WHERE b.specialRequest = :specialRequest")})
public class BookingDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "booking_id")
    private Integer bookingId;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @Column(name = "event_type")
    private int eventType;
    @Basic(optional = false)
    @Column(name = "booking_date")
    @Temporal(TemporalType.DATE)
    private Date bookingDate;
    @Basic(optional = false)
    @Column(name = "special_request")
    private String specialRequest;

    public BookingDetails() {
    }

    public BookingDetails(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public BookingDetails(Integer bookingId, int userId, int eventType, Date bookingDate, String specialRequest) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.eventType = eventType;
        this.bookingDate = bookingDate;
        this.specialRequest = specialRequest;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingDetails)) {
            return false;
        }
        BookingDetails other = (BookingDetails) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.BookingDetails[ bookingId=" + bookingId + " ]";
    }
    public ResultSet readBookingDetails(BookingDetails bookingDetails) {
        ResultSet rs = null;
        try {
            PreparedStatement st;
            Connection connection = (Connection) DBConnection.con();
            st = connection.prepareStatement("SELECT booking_id, user_id, event_type, booking_date, special_request FROM booking_details where booking_id = ? ;");
                st.setInt(1, bookingDetails.getBookingId());

            rs = st.executeQuery();

            return rs;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return rs;
    }
    
    public int insertBookingDetails(BookingDetails bd) {

        int returnedValue = 0;
        int bookingId = 0;
        try {
            Connection connection = (Connection) DBConnection.con();

            String insertTableSQL = "INSERT INTO booking_details(user_id, event_type, booking_date, special_request) VALUES(?,?,?,?);";
            PreparedStatement st = (PreparedStatement) connection.prepareStatement(insertTableSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setInt(1, bd.getUserId());
            st.setInt(2,bd.getEventType());
            st.setDate(3, new java.sql.Date(bd.getBookingDate().getTime()));
            st.setString(4,bd.getSpecialRequest());
            
            returnedValue = st.executeUpdate();

            if (returnedValue > 0) {
                ResultSet rs = st.getGeneratedKeys(); // fetches newly inserted primary key

                if (rs.next()) {
                    bookingId = rs.getInt(1);
                }

            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        // returns newly generated booking Id
        return bookingId;
    }
    
    public int updateBookingDetails(BookingDetails bd) {

        int returnedValue = 0;
        try {
            Connection connection = (Connection) DBConnection.con();

            String updateTableSQL = "UPDATE booking_details SET event_type = ?, booking_date = ?, special_request = ? where booking_id = ?;";
            PreparedStatement st = (PreparedStatement) connection.prepareStatement(updateTableSQL);
            
            st.setInt(1,bd.getEventType());
            st.setDate(2, new java.sql.Date(bd.getBookingDate().getTime()));
            st.setString(3,bd.getSpecialRequest());
            st.setInt(4, bd.getBookingId());

            returnedValue = st.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return returnedValue;
    }
}
