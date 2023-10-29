/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.VendorDetails;
import java.sql.ResultSet;

/**
 *
 * @author nihar
 */
public class VendorController {
    public ResultSet readVendorDetails(VendorDetails vd){
        return vd.readVendorDetails(vd);
    }
    
    public ResultSet loadVendorDetails(VendorDetails vd){
        return vd.loadVendorDetails(vd);
    }
}
