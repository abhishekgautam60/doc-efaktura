/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baicx.efaktura.pojo;

/**
 *
 * @author Abhishek.Gautam
 */
public class AccountingSupplierParty {
    private String partyIdentification;
    private String partyName;
    private PostalAddress postalAddress;
    private String Country;
    private PartyTaxScheme partyTaxScheme;
    private PartyLegalEntity partyLegalEntity;

    public String getPartyIdentification() {
        return partyIdentification;
    }

    public void setPartyIdentification(String partyIdentification) {
        this.partyIdentification = partyIdentification;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public PartyTaxScheme getPartyTaxScheme() {
        return partyTaxScheme;
    }

    public void setPartyTaxScheme(PartyTaxScheme partyTaxScheme) {
        this.partyTaxScheme = partyTaxScheme;
    }

    public PartyLegalEntity getPartyLegalEntity() {
        return partyLegalEntity;
    }

    public void setPartyLegalEntity(PartyLegalEntity partyLegalEntity) {
        this.partyLegalEntity = partyLegalEntity;
    }

    public AccountingSupplierParty(String partyIdentification, String partyName, PostalAddress postalAddress, String Country, PartyTaxScheme partyTaxScheme, PartyLegalEntity partyLegalEntity) {
        this.partyIdentification = partyIdentification;
        this.partyName = partyName;
        this.postalAddress = postalAddress;
        this.Country = Country;
        this.partyTaxScheme = partyTaxScheme;
        this.partyLegalEntity = partyLegalEntity;
    }

    public AccountingSupplierParty() {
    }
    
    
    
    
}
