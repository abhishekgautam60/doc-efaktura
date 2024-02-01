/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baicx.efaktura.pojo;

/**
 *
 * @author Abhishek.Gautam
 */
class TaxTotal {
    private String TaxAmount;
    private TaxSubtotal taxableAmount;
    private TaxCategory taxCategory;
    private TaxScheme taxScheme;
    private String ronTaxAmount;

    public TaxTotal(String TaxAmount, TaxSubtotal taxableAmount, TaxCategory taxCategory, TaxScheme taxScheme, String ronTaxAmount) {
        this.TaxAmount = TaxAmount;
        this.taxableAmount = taxableAmount;
        this.taxCategory = taxCategory;
        this.taxScheme = taxScheme;
        this.ronTaxAmount = ronTaxAmount;
    }
    
    
    
}
