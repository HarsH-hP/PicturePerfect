/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import model.EnterprisesList;

/**
 *
 * @author nihar
 */
public class EnterpriseController {
    public ResultSet readUserDetails(EnterprisesList e){
      return e.readEnterprises(e);
   }
    public ResultSet readUserDetails(){
        EnterprisesList e= new EnterprisesList();
      return e.readEnterprises();
   }
}
