/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.sql.ResultSet;
import model.UserDetails;

/**
 *
 * @author nihar
 */
public class CustomerController {
   public ResultSet readUserDetails(UserDetails ud){
      return ud.readUserDetails(ud);
   }
}
