/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baicx.efaktura.pojo;

/**
 *
 * @author Abhishek.Gautam
 */
class ac_PartyLegalEntity {
    
    private String RegistrationName;
    private String CompanyID;

    public String getRegistrationName() {
        return RegistrationName;
    }

    public void setRegistrationName(String RegistrationName) {
        this.RegistrationName = RegistrationName;
    }

    public String getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(String CompanyID) {
        this.CompanyID = CompanyID;
    }

    public ac_PartyLegalEntity(String RegistrationName, String CompanyID) {
        this.RegistrationName = RegistrationName;
        this.CompanyID = CompanyID;
    }
    
}
