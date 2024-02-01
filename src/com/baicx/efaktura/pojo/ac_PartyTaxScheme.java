/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baicx.efaktura.pojo;

/**
 *
 * @author Abhishek.Gautam
 */
class ac_PartyTaxScheme {
    
    private String CompanyID;
    private String TaxScheme;

    public String getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(String CompanyID) {
        this.CompanyID = CompanyID;
    }

    public String getTaxScheme() {
        return TaxScheme;
    }

    public void setTaxScheme(String TaxScheme) {
        this.TaxScheme = TaxScheme;
    }

    public ac_PartyTaxScheme(String CompanyID, String TaxScheme) {
        this.CompanyID = CompanyID;
        this.TaxScheme = TaxScheme;
    }
}
