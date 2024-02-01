/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baicx.efaktura.pojo;

/**
 *
 * @author Abhishek.Gautam
 */
class LegalMonetaryTotal {
    private String lineExtensionAmount;
    private String taxExclusiveAmount;
    private String taxInclusiveAmount;
    private String payableAmount;

    public String getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    public void setLineExtensionAmount(String lineExtensionAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
    }

    public String getTaxExclusiveAmount() {
        return taxExclusiveAmount;
    }

    public void setTaxExclusiveAmount(String taxExclusiveAmount) {
        this.taxExclusiveAmount = taxExclusiveAmount;
    }

    public String getTaxInclusiveAmount() {
        return taxInclusiveAmount;
    }

    public void setTaxInclusiveAmount(String taxInclusiveAmount) {
        this.taxInclusiveAmount = taxInclusiveAmount;
    }

    public String getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(String payableAmount) {
        this.payableAmount = payableAmount;
    }

    public LegalMonetaryTotal(String lineExtensionAmount, String taxExclusiveAmount, String taxInclusiveAmount, String payableAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
        this.taxExclusiveAmount = taxExclusiveAmount;
        this.taxInclusiveAmount = taxInclusiveAmount;
        this.payableAmount = payableAmount;
    }
    
    
    
}
