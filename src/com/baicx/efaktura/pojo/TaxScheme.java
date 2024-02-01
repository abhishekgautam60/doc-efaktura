/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baicx.efaktura.pojo;

/**
 *
 * @author Abhishek.Gautam
 */
class TaxScheme {
    private String ID;
    private String companyID;

    public TaxScheme(String ID, String companyID) {
        this.ID = ID;
        this.companyID = companyID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }
}
