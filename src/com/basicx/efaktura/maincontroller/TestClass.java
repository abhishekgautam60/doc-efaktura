/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicx.efaktura.maincontroller;


import com.baicx.efaktura.pojo.InvoiceOfIC_Company;
import com.bas.basserver.executionengine.ExecutionException;
import com.bas.basserver.executionengine.IExecutionEngine;
import com.bas.basserver.executionengine.IProcess;
import com.bas.basserver.executionengine.SuspendProcessException;
import com.bas.connectionserver.server.AccessDeniedException;
import com.bas.shared.domain.operation.IEntity;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openadaptor.dataobjects.InvalidParameterException;
import org.openadaptor.util.DateHolder;
import com.baicx.efaktura.pojo.AccountingSupplierParty;

/**
 *
 * @author Abhishek.Gautam
 */
public class TestClass implements IProcess{

    @Override
    public Object execute(IExecutionEngine iee, Object[] os) throws SuspendProcessException, ExecutionException, AccessDeniedException {
       IEntity invoice_entity = (IEntity) os [0];
            IEntity response_entity = (IEntity) os [1]; 
            IEntity system_settings_entity = (IEntity) os [2]; 
            
            InvoiceOfIC_Company invoiceOfIC_Company=new InvoiceOfIC_Company();
        try {                        
                DateHolder duedate = (DateHolder) invoice_entity.getAttributeValue("DueDate");
                DateHolder issuedate = (DateHolder) invoice_entity.getAttributeValue("Date");

                invoiceOfIC_Company.setID((String) invoice_entity.getAttributeValue("SequenceNoTxt"));
                invoiceOfIC_Company.setDueDate(duedate.toString());            
                invoiceOfIC_Company.setDocumentCurrencyCode((String) invoice_entity.getAttributeValue("CurrencySC"));
                invoiceOfIC_Company.setInvoiceTypeCode((String)invoice_entity.getAttributeValue("sc_efactura_Invoice_Type"));
                invoiceOfIC_Company.setIssueDate(issuedate.toString());
                
                
                AccountingSupplierParty accountingSupplierParty=new AccountingSupplierParty();
                accountingSupplierParty.setCountry((String) invoice_entity.getAttributeValue("C_Country"));
                accountingSupplierParty.setPartyIdentification(((Long) invoice_entity.getAttributeValue("C_Identification_Number")).toString());
                
                accountingSupplierParty.setPartyName((String) invoice_entity.getAttributeValue("C_Name"));
               
            
            
            
            
            
        } catch (InvalidParameterException ex) {
            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return null;
    }

    @Override
    public Object resume(IExecutionEngine iee, Object o) throws SuspendProcessException, ExecutionException, AccessDeniedException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean cancel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
