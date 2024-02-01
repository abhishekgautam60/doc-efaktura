/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baicx.efaktura.pojo;


import java.util.List;

/**
 *
 * @author Abhishek.Gautam
 */

public class InvoiceOfIC_Company {
    
    private String CustomizationID;
    private String ID;
    private String IssueDate;
    private String DueDate;
    private String InvoiceTypeCode;
    private String DocumentCurrencyCode;
    private String TaxCurrencyCode;
    private AccountingSupplierParty accountingSupplierParty;
    private AccountingCustomerParty accountingCustomerParty;
    private List<TaxTotal> taxTotal;
    private LegalMonetaryTotal legalMonetaryTotal;
    private List<InvoiceLine> invoiceLine;

    public String getCustomizationID() {
        return CustomizationID;
    }

    public void setCustomizationID(String CustomizationID) {
        this.CustomizationID = CustomizationID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(String IssueDate) {
        this.IssueDate = IssueDate;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String DueDate) {
        this.DueDate = DueDate;
    }

    public String getInvoiceTypeCode() {
        return InvoiceTypeCode;
    }

    public void setInvoiceTypeCode(String InvoiceTypeCode) {
        this.InvoiceTypeCode = InvoiceTypeCode;
    }

    public String getDocumentCurrencyCode() {
        return DocumentCurrencyCode;
    }

    public void setDocumentCurrencyCode(String DocumentCurrencyCode) {
        this.DocumentCurrencyCode = DocumentCurrencyCode;
    }

    public String getTaxCurrencyCode() {
        return TaxCurrencyCode;
    }

    public void setTaxCurrencyCode(String TaxCurrencyCode) {
        this.TaxCurrencyCode = TaxCurrencyCode;
    }

    public AccountingSupplierParty getAccountingSupplierParty() {
        return accountingSupplierParty;
    }

    public void setAccountingSupplierParty(AccountingSupplierParty accountingSupplierParty) {
        this.accountingSupplierParty = accountingSupplierParty;
    }

    public AccountingCustomerParty getAccountingCustomerParty() {
        return accountingCustomerParty;
    }

    public void setAccountingCustomerParty(AccountingCustomerParty accountingCustomerParty) {
        this.accountingCustomerParty = accountingCustomerParty;
    }

    public List<TaxTotal> getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(List<TaxTotal> taxTotal) {
        this.taxTotal = taxTotal;
    }

    public LegalMonetaryTotal getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }

    public void setLegalMonetaryTotal(LegalMonetaryTotal legalMonetaryTotal) {
        this.legalMonetaryTotal = legalMonetaryTotal;
    }

    public List<InvoiceLine> getInvoiceLine() {
        return invoiceLine;
    }

    public void setInvoiceLine(List<InvoiceLine> invoiceLine) {
        this.invoiceLine = invoiceLine;
    }

    public InvoiceOfIC_Company(String CustomizationID, String ID, String IssueDate, String DueDate, String InvoiceTypeCode, String DocumentCurrencyCode, String TaxCurrencyCode, AccountingSupplierParty accountingSupplierParty, AccountingCustomerParty accountingCustomerParty, List<TaxTotal> taxTotal, LegalMonetaryTotal legalMonetaryTotal, List<InvoiceLine> invoiceLine) {
        this.CustomizationID = CustomizationID;
        this.ID = ID;
        this.IssueDate = IssueDate;
        this.DueDate = DueDate;
        this.InvoiceTypeCode = InvoiceTypeCode;
        this.DocumentCurrencyCode = DocumentCurrencyCode;
        this.TaxCurrencyCode = TaxCurrencyCode;
        this.accountingSupplierParty = accountingSupplierParty;
        this.accountingCustomerParty = accountingCustomerParty;
        this.taxTotal = taxTotal;
        this.legalMonetaryTotal = legalMonetaryTotal;
        this.invoiceLine = invoiceLine;
    }

    public InvoiceOfIC_Company() {
     
    }

    
    
}
