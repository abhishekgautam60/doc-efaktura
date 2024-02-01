/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baicx.efaktura.pojo;

/**
 *
 * @author Abhishek.Gautam
 */
class InvoiceLine {
    private String ID;
    private String invoicedQuantity;
    private String lineExtensionAmount;
    private String item;
    private String classifiedTaxCategory;
    private String taxScheme;
    private String priceAmount;
    private String baseQuantity;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getInvoicedQuantity() {
        return invoicedQuantity;
    }

    public void setInvoicedQuantity(String invoicedQuantity) {
        this.invoicedQuantity = invoicedQuantity;
    }

    public String getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    public void setLineExtensionAmount(String lineExtensionAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getClassifiedTaxCategory() {
        return classifiedTaxCategory;
    }

    public void setClassifiedTaxCategory(String classifiedTaxCategory) {
        this.classifiedTaxCategory = classifiedTaxCategory;
    }

    public String getTaxScheme() {
        return taxScheme;
    }

    public void setTaxScheme(String taxScheme) {
        this.taxScheme = taxScheme;
    }

    public String getPriceAmount() {
        return priceAmount;
    }

    public void setPriceAmount(String priceAmount) {
        this.priceAmount = priceAmount;
    }

    public String getBaseQuantity() {
        return baseQuantity;
    }

    public void setBaseQuantity(String baseQuantity) {
        this.baseQuantity = baseQuantity;
    }

    public InvoiceLine(String ID, String invoicedQuantity, String lineExtensionAmount, String item, String classifiedTaxCategory, String taxScheme, String priceAmount, String baseQuantity) {
        this.ID = ID;
        this.invoicedQuantity = invoicedQuantity;
        this.lineExtensionAmount = lineExtensionAmount;
        this.item = item;
        this.classifiedTaxCategory = classifiedTaxCategory;
        this.taxScheme = taxScheme;
        this.priceAmount = priceAmount;
        this.baseQuantity = baseQuantity;
    }
    
    
    
}
