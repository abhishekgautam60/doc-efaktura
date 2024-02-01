/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baicx.efaktura.pojo;

/**
 *
 * @author Abhishek.Gautam
 */
class AccountingCustomerParty {
    private String ac_partyIdentification;
    private String ac_partyName;
    private ac_PostalAddress ac_postalAddress;
    private String ac_Country;
    private ac_PartyTaxScheme ac_partyTaxScheme;
    private ac_PartyLegalEntity ac_partyLegalEntity;

    public String getAc_partyIdentification() {
        return ac_partyIdentification;
    }

    public void setAc_partyIdentification(String ac_partyIdentification) {
        this.ac_partyIdentification = ac_partyIdentification;
    }

    public String getAc_partyName() {
        return ac_partyName;
    }

    public void setAc_partyName(String ac_partyName) {
        this.ac_partyName = ac_partyName;
    }

    public ac_PostalAddress getAc_postalAddress() {
        return ac_postalAddress;
    }

    public void setAc_postalAddress(ac_PostalAddress ac_postalAddress) {
        this.ac_postalAddress = ac_postalAddress;
    }

    public String getAc_Country() {
        return ac_Country;
    }

    public void setAc_Country(String ac_Country) {
        this.ac_Country = ac_Country;
    }

    public ac_PartyTaxScheme getAc_partyTaxScheme() {
        return ac_partyTaxScheme;
    }

    public void setAc_partyTaxScheme(ac_PartyTaxScheme ac_partyTaxScheme) {
        this.ac_partyTaxScheme = ac_partyTaxScheme;
    }

    public ac_PartyLegalEntity getAc_partyLegalEntity() {
        return ac_partyLegalEntity;
    }

    public void setAc_partyLegalEntity(ac_PartyLegalEntity ac_partyLegalEntity) {
        this.ac_partyLegalEntity = ac_partyLegalEntity;
    }

    public AccountingCustomerParty(String ac_partyIdentification, String ac_partyName, ac_PostalAddress ac_postalAddress, String ac_Country, ac_PartyTaxScheme ac_partyTaxScheme, ac_PartyLegalEntity ac_partyLegalEntity) {
        this.ac_partyIdentification = ac_partyIdentification;
        this.ac_partyName = ac_partyName;
        this.ac_postalAddress = ac_postalAddress;
        this.ac_Country = ac_Country;
        this.ac_partyTaxScheme = ac_partyTaxScheme;
        this.ac_partyLegalEntity = ac_partyLegalEntity;
    }
    
    
    
}
