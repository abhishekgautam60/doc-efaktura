/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicx.efaktura.api.response;

/**
 *
 * @author Abhishek.Gautam
 */
public class InvoiceSubmissionStatus {
    
    public String invoice;
    public String date;
    public String loadIndex;
    public String downloadIndex;
    public String anafSubmissionStatus;

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLoadIndex() {
        return loadIndex;
    }

    public void setLoadIndex(String loadIndex) {
        this.loadIndex = loadIndex;
    }

    public String getDownloadIndex() {
        return downloadIndex;
    }

    public void setDownloadIndex(String downloadIndex) {
        this.downloadIndex = downloadIndex;
    }

    public String getAnafSubmissionStatus() {
        return anafSubmissionStatus;
    }

    public void setAnafSubmissionStatus(String anafSubmissionStatus) {
        this.anafSubmissionStatus = anafSubmissionStatus;
    }

    public InvoiceSubmissionStatus(String invoice, String date, String loadIndex, String downloadIndex, String anafSubmissionStatus) {
        this.invoice = invoice;
        this.date = date;
        this.loadIndex = loadIndex;
        this.downloadIndex = downloadIndex;
        this.anafSubmissionStatus = anafSubmissionStatus;
    }
    
    public InvoiceSubmissionStatus()
    {
        
    }
    

    @Override
    public String toString() {
        return "InvoiceSubmissionStatus{" + "invoice=" + invoice + ", date=" + date + ", loadIndex=" + loadIndex + ", downloadIndex=" + downloadIndex + ", anafSubmissionStatus=" + anafSubmissionStatus + '}';
    }
    
    
    
}
