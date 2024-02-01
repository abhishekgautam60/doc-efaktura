/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baicx.efaktura.pojo;

/**
 *
 * @author Abhishek.Gautam
 */
class TaxCategory {
    
    private String ID;
    private String TaxExemptionReasonCode;
    private String TaxExemptionReason;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTaxExemptionReasonCode() {
        return TaxExemptionReasonCode;
    }

    public void setTaxExemptionReasonCode(String TaxExemptionReasonCode) {
        this.TaxExemptionReasonCode = TaxExemptionReasonCode;
    }

    public String getTaxExemptionReason() {
        return TaxExemptionReason;
    }

    public void setTaxExemptionReason(String TaxExemptionReason) {
        this.TaxExemptionReason = TaxExemptionReason;
    }

    public TaxCategory(String ID, String TaxExemptionReasonCode, String TaxExemptionReason) {
        this.ID = ID;
        this.TaxExemptionReasonCode = TaxExemptionReasonCode;
        this.TaxExemptionReason = TaxExemptionReason;
    }
   
}
