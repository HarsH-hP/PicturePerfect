/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Vijaya B.
 */
public class DBConnection {
    public static Connection con(){
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pictureperfect","root","");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return con;
    }
}
