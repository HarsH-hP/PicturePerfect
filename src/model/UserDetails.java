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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nihar
 */
@Entity
@Table(name = "user_details")
@NamedQueries({
    @NamedQuery(name = "UserDetails_1.findAll", query = "SELECT u FROM UserDetails_1 u"),
    @NamedQuery(name = "UserDetails_1.findByUserId", query = "SELECT u FROM UserDetails_1 u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserDetails_1.findByFirstName", query = "SELECT u FROM UserDetails_1 u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "UserDetails_1.findByLastName", query = "SELECT u FROM UserDetails_1 u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "UserDetails_1.findByAge", query = "SELECT u FROM UserDetails_1 u WHERE u.age = :age"),
    @NamedQuery(name = "UserDetails_1.findByGender", query = "SELECT u FROM UserDetails_1 u WHERE u.gender = :gender"),
    @NamedQuery(name = "UserDetails_1.findByEmail", query = "SELECT u FROM UserDetails_1 u WHERE u.email = :email"),
    @NamedQuery(name = "UserDetails_1.findByPhoneNumber", query = "SELECT u FROM UserDetails_1 u WHERE u.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "UserDetails_1.findByAddressLine1", query = "SELECT u FROM UserDetails_1 u WHERE u.addressLine1 = :addressLine1"),
    @NamedQuery(name = "UserDetails_1.findByAddressLine2", query = "SELECT u FROM UserDetails_1 u WHERE u.addressLine2 = :addressLine2"),
    @NamedQuery(name = "UserDetails_1.findByUsername", query = "SELECT u FROM UserDetails_1 u WHERE u.username = :username"),
    @NamedQuery(name = "UserDetails_1.findByPassword", query = "SELECT u FROM UserDetails_1 u WHERE u.password = :password")})
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "age")
    private int age;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "address_line_1")
    private String addressLine1;
    @Basic(optional = false)
    @Column(name = "address_line_2")
    private String addressLine2;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    public UserDetails() {
    }

    public UserDetails(Integer userId) {
        this.userId = userId;
    }

    public UserDetails(Integer userId, String firstName, String lastName, int age, String gender, String email, String phoneNumber, String addressLine1, String addressLine2, String username, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.username = username;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDetails)) {
            return false;
        }
        UserDetails other = (UserDetails) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UserDetails_1[ userId=" + userId + " ]";
    }

    // used for login and view user details
    public ResultSet readUserDetails(UserDetails userDetails) {
        ResultSet rs = null;
        String password = userDetails.getPassword();
        try {
            PreparedStatement st;
            Connection connection = (Connection) DBConnection.con();
            if (password == null) {
                st = connection.prepareStatement("SELECT user_id, first_name, last_name, age, gender, email, phone_number, address_line_1, address_line_2, username, password FROM user_details where username = ? ");
                st.setString(1, userDetails.getUsername());
            } else {
                st = connection.prepareStatement("SELECT user_id, first_name, last_name, age, gender, email, phone_number, address_line_1, address_line_2, username, password FROM user_details where username = ? and password = ?");
                st.setString(1, userDetails.getUsername());
                st.setString(2, userDetails.getPassword());
            }

            rs = st.executeQuery();
            return rs;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return rs;
    }

    public int insertUserDetails(UserDetails ud) {

        int returnedValue = 0;
        try {
            Connection connection = (Connection) DBConnection.con();

            String insertTableSQL = "INSERT INTO user_details(first_name, last_name, age, gender, email, phone_number, address_line_1, address_line_2, username, password) VALUES(?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement st = (PreparedStatement) connection.prepareStatement(insertTableSQL);
            st.setString(1, ud.getFirstName());
            st.setString(2, ud.getLastName());
            st.setInt(3, ud.getAge());
            st.setString(4, ud.getGender());
            st.setString(5, ud.getEmail());
            st.setString(6, ud.getPhoneNumber());
            st.setString(7, ud.getAddressLine1());
            st.setString(8, ud.getAddressLine2());
            st.setString(9, ud.getUsername());
            st.setString(10, ud.getPassword());

            returnedValue = st.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return returnedValue;
    }
    
    public int updateUserDetails(UserDetails ud) {

        int returnedValue = 0;
        try {
            Connection connection = (Connection) DBConnection.con();

            String updateTableSQL = "UPDATE user_details SET first_name = ?, last_name = ?, age = ?, gender = ?, email = ?, phone_number = ?, address_line_1= ?, address_line_2 = ? where username = ?;";
            PreparedStatement st = (PreparedStatement) connection.prepareStatement(updateTableSQL);
            st.setString(1, ud.getFirstName());
            st.setString(2, ud.getLastName());
            st.setInt(3, ud.getAge());
            st.setString(4, ud.getGender());
            st.setString(5, ud.getEmail());
            st.setString(6, ud.getPhoneNumber());
            st.setString(7, ud.getAddressLine1());
            st.setString(8, ud.getAddressLine2());
            st.setString(9, ud.getUsername());

            returnedValue = st.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return returnedValue;
    }
}
