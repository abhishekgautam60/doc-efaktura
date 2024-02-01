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
import com.test.efaktura.MyProcessLibrary;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.openadaptor.dataobjects.InvalidParameterException;
import org.w3c.dom.Element;
import com.basicx.efaktura.attributes.PatternCode;
import com.basicx.efaktura.attributes.PatternCurrency;
import com.basicx.efaktura.attributes.PatternLanguage;
import com.basicx.efaktura.attributes.PatternList;
import com.basicx.efaktura.attributes.PatternScheme;
import com.basicx.efaktura.axioms.DocumentT;
import com.basicx.efaktura.elements.AddressFormatCode;
import com.basicx.efaktura.elements.BaseQuantity;
import com.basicx.efaktura.elements.CityName;
import com.basicx.efaktura.elements.CompanyID;
import com.basicx.efaktura.elements.CompanyLegalForm;
import com.basicx.efaktura.elements.CustomizationID;
import com.basicx.efaktura.elements.DocumentCurrencyCode;
import com.basicx.efaktura.elements.DueDate;
import com.basicx.efaktura.elements.ID;
import com.basicx.efaktura.elements.IdentificationCode;
import com.basicx.efaktura.elements.InvoiceTypeCode;
import com.basicx.efaktura.elements.InvoicedQuantity;
import com.basicx.efaktura.elements.IssueDate;
import com.basicx.efaktura.elements.LineExtensionAmount;
import com.basicx.efaktura.elements.Name;
import com.basicx.efaktura.elements.PayableAmount;
import com.basicx.efaktura.elements.Percent;
import com.basicx.efaktura.elements.PostalZone;
import com.basicx.efaktura.elements.PriceAmount;
import com.basicx.efaktura.elements.RegistrationName;
import com.basicx.efaktura.elements.StreetName;
import com.basicx.efaktura.elements.TaxAmount;
import com.basicx.efaktura.elements.TaxCurrencyCode;
import com.basicx.efaktura.elements.TaxExclusiveAmount;
import com.basicx.efaktura.elements.TaxExemptionReason;
import com.basicx.efaktura.elements.TaxExemptionReasonCode;
import com.basicx.efaktura.elements.TaxInclusiveAmount;
import com.basicx.efaktura.elements.TaxableAmount;
import com.basicx.efaktura.modules.AccountingCustomerParty;
import com.basicx.efaktura.modules.AccountingSupplierParty;
import com.basicx.efaktura.modules.ClassifiedTaxCategory;
import com.basicx.efaktura.modules.Country;
import com.basicx.efaktura.modules.InvoiceLine;
import com.basicx.efaktura.modules.Item;
import com.basicx.efaktura.modules.LegalMonetaryTotal;
import com.basicx.efaktura.modules.Party;
import com.basicx.efaktura.modules.PartyIdentification;
import com.basicx.efaktura.modules.PartyLegalEntity;
import com.basicx.efaktura.modules.PartyName;
import com.basicx.efaktura.modules.PartyTaxScheme;
import com.basicx.efaktura.modules.PostalAddress;
import com.basicx.efaktura.modules.Price;
import com.basicx.efaktura.modules.TaxCategory;
import com.basicx.efaktura.modules.TaxScheme;
import com.basicx.efaktura.modules.TaxSubTotal;
import com.basicx.efaktura.modules.TaxTotal;

import java.text.DecimalFormat;
import org.openadaptor.util.DateHolder;
import xml.ubl.templates.UBLTest;

/**
 *
 * @author Abhishek.Gautam
 */
public class MainController implements IProcess{

    
   public static String dateResponse;
   public static String ExecutionStatus ;
   public static String index_incarcare ;
        
    @Override
    public Object execute(IExecutionEngine iee, Object[] os) throws SuspendProcessException, ExecutionException, AccessDeniedException 
   {      
        try 
        {                        
            String customizationId="";
            String c_TaxSchemeID="";
            String tc_CustomerAddresFormateCode="";
            String tc_TaxSchemeID="";
            String taxTotalTaxSchemeID="";                        
            String taxExclusiveAmount="";
            String c_AdditionalStreetName="";
            String totalValueNoVAT = "";
                        
            
            // get the parameter
            IEntity invoice_entity = (IEntity) os [0];
            IEntity response_entity = (IEntity) os [1]; 
            IEntity system_settings_entity = (IEntity) os [2]; 
         
            
            
            
            
            
            
            
            
            
            System.out.println("Main Controller Started");
            System.out.println(os.length);
            
            customizationId="urn:cen.eu:en16931:2017#compliant#urn:efactura.mfinante.ro:CIUS-RO:1.0.1";
            
//          Fetching the data from awareIM attributes.
            String sequenceNoTxt =(String) invoice_entity.getAttributeValue("SequenceNoTxt");       
            String xmlName = sequenceNoTxt + ".xml";
            String pathName = ((String) invoice_entity.getAttributeValue("PDFInvoice_Path")+"//");
            
            System.out.println(pathName );
 
            DateHolder issuedate = (DateHolder) invoice_entity.getAttributeValue("Date");
            DateHolder duedate = (DateHolder) invoice_entity.getAttributeValue("DueDate");
            
            String sc_efactura_Invoice_Type =(String)invoice_entity.getAttributeValue("sc_efactura_Invoice_Type");                         
            String currencySC =(String) invoice_entity.getAttributeValue("CurrencySC");
            String C_Name=(String) invoice_entity.getAttributeValue("C_Name");
            String C_Country =(String) invoice_entity.getAttributeValue("C_Country");
            String C_Address =(String) invoice_entity.getAttributeValue("C_Address");
            try{
                c_AdditionalStreetName=(String) invoice_entity.getAttributeValue("C_AdditionalStreetName");
            }
            catch(InvalidParameterException ex)
            {
                System.out.println("c_AdditionalStreetName attribute not found");
            }            
            String c_city=(String) invoice_entity.getAttributeValue("C_City");
            String C_County_Subdivision=(String) invoice_entity.getAttributeValue("C_County_Subdivision");
            Long C_Identification_Number =(Long) invoice_entity.getAttributeValue("C_Identification_Number");                        
            try{
                c_TaxSchemeID =(String) invoice_entity.getAttributeValue("C_TaxSchemeID");

            }
            catch(InvalidParameterException ex)
            {
                System.out.println("TaxSchemeID attribute not found");
            }                        
            String C_CUI =(String) invoice_entity.getAttributeValue("C_CUI");
            String C_RegCom =(String) invoice_entity.getAttributeValue("C_RegCom");           
            String tc_PartyIdentificationNumber =(String) invoice_entity.getAttributeValue("TC_PartyIdentificationNumber");
            String toSC =(String) invoice_entity.getAttributeValue("ToSC");
            String tc_Country =(String) invoice_entity.getAttributeValue("TC_Country");
            String tc_Address =(String) invoice_entity.getAttributeValue("TC_Address");            
            try{
                tc_CustomerAddresFormateCode =(String) invoice_entity.getAttributeValue("TC_AdditionalStreetName");

            }
            catch(InvalidParameterException ex)
            {
                System.out.println("TC_CustomerAddresFormateCode attribute not found");
            }
            String tc_CIF =(String) invoice_entity.getAttributeValue("TC_CIF");
            String tc_County_Subdivision =(String) invoice_entity.getAttributeValue("TC_County_Subdivision");            
            try{
                tc_TaxSchemeID =(String) invoice_entity.getAttributeValue("TC_TaxSchemeID");
            }
            catch(InvalidParameterException ex)
            {
                System.out.println("TaxSchemeID attribute not found");
            }            
            String tc_City =(String) invoice_entity.getAttributeValue("TC_City");            
            
            IEntity[] lines1 = iee.getAllReferences(this, invoice_entity, "LineItems");             
//              these lines1[]are from LineItems object.
            String sc_currency_code= (String) lines1[0].getAttributeValue("sc_currency_code"); 
            
//          TaxTotal - TaxAmount Value
            Double totalVATRon= (Double) invoice_entity.getAttributeValue("TotalVAT");
            
            String attributeCurrencySC=(String) invoice_entity.getAttributeValue("CurrencySC");
            
//          Storing the data into the entities.
            DocumentT docInvoice = new DocumentT(xmlName, pathName);           
            docInvoice.initialize();

            CustomizationID customizationID= new CustomizationID.CustomizationIDBuilder()
                    .value(customizationId)
                    .build();
            
             ID id= new ID.IDBuilder()
                    .value(sequenceNoTxt)
                    .build();

                                                
             IssueDate issueDate = new IssueDate.IssueDateBuilder()
                    .value(issuedate.toString())
                    .build();
                        
            //Due Date
            DueDate dueDate = new DueDate.DueDateBuilder()
                    .value(duedate.toString())
                    .build();

            InvoiceTypeCode invoiceTypeCode = new InvoiceTypeCode.InvoiceTypeCodeBuilder()
                    .value(sc_efactura_Invoice_Type)
                    .build();          

            DocumentCurrencyCode documentCurrencyCode = new DocumentCurrencyCode.DocumentCurrencyCodeBuilder()
                    .value(currencySC)
                    .build();       

            TaxCurrencyCode taxCurrencyCode = new TaxCurrencyCode.TaxCurrencyCodeBuilder()
                    .value("RON")
                    .build();  
    /**
     * Account supplier party
     */
      
           //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY IDENTIFICATION
           List<PartyIdentification> partyIdentificationListInvoice = new ArrayList<>();
           PartyIdentification partyIdentification1Invoice = new PartyIdentification.PartyIdentificationBuilder()
                   .id(new ID.IDBuilder()
                           .value(C_Identification_Number.toString())
                           .build())
                   .build();

           partyIdentificationListInvoice.add(partyIdentification1Invoice);


           //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY NAME
           List<PartyName> partyNameListInvoice = new ArrayList<>();
           PartyName partyNameInvoice1 = new PartyName.PartyNameBuilder()
                   .name(new Name.NameBuilder()
                           .value(C_Name)
                           .build())
                   .build();
           partyNameListInvoice.add(partyNameInvoice1);

           //ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS > COUNTRY
           Country countryInvoice1 = new Country.CountryBuilder()
                   .identificationCode(new IdentificationCode.IdentificationCodeBuilder()
                           .value(C_Country)
                           .build())

                   .build();
                               
           
           //ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS
           PostalAddress postalAddressInvoice1 = new PostalAddress.PostalAddressBuilder()
                   .streetName(new StreetName.StreetNameBuilder()
                           .value(C_Address)
                           .attributes(new PatternLanguage.PatternLanguageBuilder()
                                   .build())
                           .build())
                   .addressFormatCode(new AddressFormatCode.AddressFormatCodeBuilder()
                           .value(c_AdditionalStreetName)
                           .attributes(new PatternList.PatternListBuilder()
                                   .build())
                           .build())
                   .cityName(new CityName.CityNameBuilder()
                           .value(c_city)
                           .attributes(new PatternLanguage.PatternLanguageBuilder()
                                   .build())
                           .build())
                   .countrySubentity(new PostalZone.PostalZoneBuilder()
                           .value(C_County_Subdivision)
                           .build())

                   .country(countryInvoice1)
                   .build();
           
           //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY TAX SCHEME > TAX SCHEME
           TaxScheme taxSchemeInvoice1 = new TaxScheme.TaxSchemeBuilder()
                   .id(new ID.IDBuilder()
                           .value(c_TaxSchemeID)

                           .build())
                   .build();
           //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY TAX SCHEME
           List<PartyTaxScheme> partyTaxSchemeListInvoice = new ArrayList<>();
                if(((Boolean) invoice_entity.getAttributeValue("C_is_Paying_VAT")==false)){  
               PartyTaxScheme partyTaxSchemeInvoice1 = new PartyTaxScheme.PartyTaxSchemeBuilder()
                  
//                   .companyId(new CompanyID.CompanyIDBuilder()
//                           .value(C_CUI)
//                           .build())
                   .taxScheme(taxSchemeInvoice1)
                   .build();
                    partyTaxSchemeListInvoice.add(partyTaxSchemeInvoice1);
                }
                else{
                              PartyTaxScheme partyTaxSchemeInvoice1 = new PartyTaxScheme.PartyTaxSchemeBuilder()
                  
                   .companyId(new CompanyID.CompanyIDBuilder()
                           .value(C_CUI)
                           .build())
                   .taxScheme(taxSchemeInvoice1)
                   .build();
                    partyTaxSchemeListInvoice.add(partyTaxSchemeInvoice1);
               }
                             
           
               
           //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY
           List<PartyLegalEntity> partyLegalEntityListInvoice = new ArrayList<>();
           PartyLegalEntity partyLegalEntityInvoice1 = new PartyLegalEntity.PartyLegalEntityBuilder()
                   .registrationName(new RegistrationName.RegistrationNameBuilder()
                           .value(C_Name)
                           .build())
                   .companyId(new CompanyID.CompanyIDBuilder()
                           .value(C_CUI)            
                           .build())

                   .companyLegalForm(new CompanyLegalForm.CompanyLegalFormBuilder()
                           .value(C_RegCom)
                           .build())
                   .build();
           partyLegalEntityListInvoice.add(partyLegalEntityInvoice1);

           //ACCOUNTING SUPPLIER PARTY > PARTY
           Party elementPartyInvoice1 = new Party.PartyBuilder()
                   .partyIdentificationList(partyIdentificationListInvoice)
                   .partyNameList(partyNameListInvoice)
                   .postalAddress(postalAddressInvoice1)
                   .partyTaxSchemeList(partyTaxSchemeListInvoice)
                   .partyLegalEntityList(partyLegalEntityListInvoice)
                   .build();

           //ACCOUNTING SUPPLIER PARTY
           AccountingSupplierParty elementAccountingSupplierPartyInvoice = new AccountingSupplierParty.AccountingSupplierPartyBuilder()
                   .party(elementPartyInvoice1)
                   .build();
           
           System.out.println(elementAccountingSupplierPartyInvoice.toString());


    /**
     * Element AccountingCustomerParty
     */
                       
           //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY IDENTIFICATION
           List<PartyIdentification> partyIdentificationListCreditNote = new ArrayList<>();
           PartyIdentification partyIdentificationCreditNote1 = new PartyIdentification.PartyIdentificationBuilder()
                   .id(new ID.IDBuilder()
                           .value(tc_PartyIdentificationNumber)
                           .build())
                   .build();

           partyIdentificationListCreditNote.add(partyIdentificationCreditNote1);

           //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY NAME
           List<PartyName> partyNameListCreditNote = new ArrayList<>();
           PartyName partyNameCreditNote1 = new PartyName.PartyNameBuilder()
                   .name(new Name.NameBuilder()
                           .value(toSC)
                           .build())
                   .build();
           partyNameListCreditNote.add(partyNameCreditNote1);

           //ACCOUNTING CUSTOMER PARTY > PARTY > POSTAL ADDRESS > COUNTRY
           Country countryCreditNote1 = new Country.CountryBuilder()
                   .identificationCode(new IdentificationCode.IdentificationCodeBuilder()
                           .value(tc_Country)
                           .build())
                   .build();


           //ACCOUNTING CUSTOMER PARTY > PARTY > POSTAL ADDRESS
           PostalAddress postalAddressCreditNote1 = new PostalAddress.PostalAddressBuilder()
                   .streetName(new StreetName.StreetNameBuilder()
                           .value(tc_Address)
                           .build())
                   .addressFormatCode(new AddressFormatCode.AddressFormatCodeBuilder()
                           .value(tc_CustomerAddresFormateCode)
                           .build())
                   .cityName(new CityName.CityNameBuilder()
                           .value(tc_City)
                           .build())

                   .countrySubentity(new PostalZone.PostalZoneBuilder()
                           .value(tc_County_Subdivision)
                           .build())

                   .country(countryCreditNote1)

                   .build();
           //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY TAX SCHEME > TAX SCHEME
           TaxScheme taxSchemeCreditNote1 = new TaxScheme.TaxSchemeBuilder()

                   .id(new ID.IDBuilder()
                           .value(tc_TaxSchemeID)
                           .build())

                   .build();

           //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY TAX SCHEME
           List<PartyTaxScheme> partyTaxSchemeListCreditNote = new ArrayList<>();
           
            if(((Boolean) invoice_entity.getAttributeValue("C_is_Paying_VAT")==false)){
                
               System.out.println("TC_is_Paying_VAT ="+(Boolean) invoice_entity.getAttributeValue("TC_is_Paying_VAT"));
               System.out.println("Customer compnayID is also removed");
                 PartyTaxScheme partyTaxSchemeCreditNote1 = new PartyTaxScheme.PartyTaxSchemeBuilder()                
                   .taxScheme(taxSchemeCreditNote1)
                   .build();
           partyTaxSchemeListCreditNote.add(partyTaxSchemeCreditNote1);
           }
            else
            {
                 PartyTaxScheme partyTaxSchemeCreditNote1 = new PartyTaxScheme.PartyTaxSchemeBuilder()
//                   .companyId(new CompanyID.CompanyIDBuilder()
//                           .value(tc_CIF)
//                           .build())
                   .taxScheme(taxSchemeCreditNote1)
                   .build();
           partyTaxSchemeListCreditNote.add(partyTaxSchemeCreditNote1);
            }
                
          

           //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY LEGAL ENTITY
           List<PartyLegalEntity> partyLegalEntityListCreditNote = new ArrayList<>();
           PartyLegalEntity partyLegalEntityCreditNote1 = new PartyLegalEntity.PartyLegalEntityBuilder()
                   .registrationName(new RegistrationName.RegistrationNameBuilder()
                           .value(toSC)
                           .build())
                   .companyId(new CompanyID.CompanyIDBuilder()
                           .value(tc_CIF)
                           .build())

                   .build();
           partyLegalEntityListCreditNote.add(partyLegalEntityCreditNote1);


           //ACCOUNTING CUSTOMER PARTY > PARTY
           Party elementPartyCreditNote = new Party.PartyBuilder()
                   .partyIdentificationList(partyIdentificationListCreditNote)
                   .partyNameList(partyNameListCreditNote)
                   .postalAddress(postalAddressCreditNote1)
                   .partyTaxSchemeList(partyTaxSchemeListCreditNote)
                   .partyLegalEntityList(partyLegalEntityListCreditNote)
                   .build();

           //ACCOUNTING CUSTOMER PARTY
           AccountingCustomerParty elementAccountingCustomerPartyCreditNote = new AccountingCustomerParty.AccountingCustomerPartyBuilder()
                   .party(elementPartyCreditNote)
                   .build();


    /**
     * Element TaxTotal [List]
     */
//          Formating the decimal number
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            DecimalFormat decimalFormat2 = new DecimalFormat("0.000");
            
            //TAX TOTAL > TAX SUB TOTAL                    
            
            IEntity[] taxTotal = iee.getAllReferences(this, invoice_entity, "pm_TaxSummary");
            
            System.out.println("fdv");
            Double TaxTotalAmount = 0.0;
            String totalValueRON="";
            String totalAmount="";
            String FormatingTaxTotal_Amount="";
            Double taxInclusiveAndPayvableAmount=0.0;
            String InclusiveAndPayvable="";
            String taxExemptionReasonCode="VATEX-EU-O";
            String taxExemptionReason="Entitatea nu este inregistrata in scopuri de TVA";
            
            
            List<TaxSubTotal> taxSubTotalList44 = new ArrayList<>();
            for(int i=0; i<taxTotal.length; i++)
            {
//            
                
                totalValueRON=decimalFormat.format((Double) invoice_entity.getAttributeValue("TotalValueRON"));
                totalAmount=decimalFormat.format((Double) invoice_entity.getAttributeValue("TotalAmount"));
                String taxableAmount=decimalFormat.format((Double) taxTotal[i].getAttributeValue("TaxableAmount"));      
                String taxAmount=decimalFormat.format((Double) taxTotal[i].getAttributeValue("TaxAmount"));                
                String taxCategoryID= (String) taxTotal[i].getAttributeValue("TaxCategory_ID");
                String taxPercent= decimalFormat.format((Double) taxTotal[i].getAttributeValue("TaxCategory_VatPercent"));
                String TaxSchemeID= (String) taxTotal[i].getAttributeValue("TaxSchemeID");
                String currencyID= (String) taxTotal[i].getAttributeValue("currencyID");                                
                
                //TAX TOTAL > TAX SUB TOTAL > TAX CATEGORY > TAX SCHEME
                TaxScheme taxSchemeInvoice44 = new TaxScheme.TaxSchemeBuilder()
                    .id(new ID.IDBuilder()
                            .value(TaxSchemeID)
                            .build())
                    .build();

            //TAX TOTAL > TAX SUB TOTAL > TAX CATEGORY
             TaxCategory taxCategoryInvoice44 = null;
             
            if(((Boolean) invoice_entity.getAttributeValue("C_is_Paying_VAT")==false)){
                System.out.println("C_is_Paying_VAT = "+(Boolean) invoice_entity.getAttributeValue("C_is_Paying_VAT"));
                System.out.println("Ihis is belongs to TaxTotal perecent, which is removed and replace by the some other attributes");
                 taxCategoryInvoice44 = new TaxCategory.TaxCategoryBuilder()
                    .id(new ID.IDBuilder()
                            .value(taxCategoryID)
                            .build())
                    .taxExemptionReason(new TaxExemptionReason.TaxExemptionReasonBuilder().value(taxExemptionReason).build())
                    .taxExemptionReasonCode(new TaxExemptionReasonCode.TaxExemptionReasonCodeBuilder().value(taxExemptionReasonCode).build())
                    .taxScheme(taxSchemeInvoice44)
                    .build();  
            }
            else{
                
                 taxCategoryInvoice44 = new TaxCategory.TaxCategoryBuilder()
                    .id(new ID.IDBuilder()
                            .value(taxCategoryID)

                            .build())
                    .percent(new Percent.PercentBuilder().value(taxPercent).build())
                    .taxScheme(taxSchemeInvoice44)
                    .build();  
            }
               
            
                                                  
                
                TaxSubTotal taxSubTotal44 = new TaxSubTotal.TaxSubTotalBuilder()
                    .taxableAmount(new TaxableAmount.TaxableAmountBuilder()
                            .value(taxableAmount)
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                    .currencyID(currencyID)
                                    .build())
                            .build())
                    .taxAmount(new TaxAmount.TaxAmountBuilder()
                            .value(taxAmount)
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                   .currencyID(currencyID)
                                    .build())
                            .build())
                    .taxCategory(taxCategoryInvoice44)
                    .build();
                taxSubTotalList44.add(taxSubTotal44);
                
               TaxTotalAmount= TaxTotalAmount + (Double) taxTotal[i].getAttributeValue("TaxableAmount");
               FormatingTaxTotal_Amount=decimalFormat.format(TaxTotalAmount);
               
               taxInclusiveAndPayvableAmount= TaxTotalAmount + (Double) invoice_entity.getAttributeValue("TotalVAT");
               InclusiveAndPayvable=decimalFormat.format(taxInclusiveAndPayvableAmount);
            }
            

             //TAX TOTAL
            List<TaxTotal> taxTotalList44 = new ArrayList<>();
            TaxTotal taxTotal44 = new TaxTotal.TaxTotalBuilder()
                    .taxAmount(new TaxAmount.TaxAmountBuilder()
                            .value(totalVATRon.toString())
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                     .currencyID(sc_currency_code)
                                    .build())
                            .build())
                    .taxSubTotalList(taxSubTotalList44)
                    .build();
            
            taxTotalList44.add(taxTotal44);
            
            List<TaxTotal> taxTotalList444 = new ArrayList<>();                              
                  TaxTotal taxTotal444 = new TaxTotal.TaxTotalBuilder()
                    .taxAmount(new TaxAmount.TaxAmountBuilder()
                            .value(totalVATRon.toString())
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                     .currencyID("RON")
                                    .build())
                            .build())                   
                    .build();
             taxTotalList444.add(taxTotal444);                               
             
            
    /**
     * Element LegalMonetaryTotal
     */

            LegalMonetaryTotal legalMonetaryTotalInvoice1 = new LegalMonetaryTotal.LegalMonetaryTotalBuilder()
                    .lineExtensionAmount(new LineExtensionAmount.LineExtensionAmountBuilder()
                            .value(FormatingTaxTotal_Amount)
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID(sc_currency_code)
                                .build())
                            .build())
                    
                    .taxExclusiveAmount(new TaxExclusiveAmount.TaxExclusiveAmountBuilder()
                            .value(FormatingTaxTotal_Amount)
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                    .currencyID(attributeCurrencySC)
                                    .build())
                            .build())
                    .taxInclusiveAmount(new TaxInclusiveAmount.TaxInclusiveAmountBuilder()
                            .value(InclusiveAndPayvable)
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                    .currencyID(sc_currency_code)
                                    .build())
                            
                            .build())
                    
                    .payableAmount(new PayableAmount.PayableAmountBuilder()
                            .value(InclusiveAndPayvable)
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                    .currencyID(attributeCurrencySC)
                                    .build())
                            .build())
                    .build();
     
            

    /**
     * Element InvoiceLine [List]
     */

            //INVOICE LINE
            IEntity[] lines = iee.getAllReferences(this, invoice_entity, "LineItems");
                    
            List<InvoiceLine> invoiceLineList44 = new ArrayList<>();
            for(int i=0; i<lines.length; i++)
            {
                
                String price=decimalFormat.format((Double) lines[i].getAttributeValue("Price"));
                String quantity=decimalFormat2.format((Double) lines[i].getAttributeValue("Quantity"));
                Long recordOrder=(Long) lines[i].getAttributeValue("RecordOrder");
                String totalValueNoVat=decimalFormat.format((Double) lines[i].getAttributeValue("TotalValueNoVAT"));
                String VATRate_SC= decimalFormat.format((Double) lines[i].getAttributeValue("VATRate_SC"));
                String sc_TaxSchemeID= (String) lines[i].getAttributeValue("sc_TaxSchemeID");                
                                
                TaxScheme taxSchemeInvoice44 = new TaxScheme.TaxSchemeBuilder()
                    .id(new ID.IDBuilder()
                            .value(sc_TaxSchemeID)
                            .build())
                    .build();
                 
                
                ClassifiedTaxCategory classifiedTaxCategoryInvoice44 = null;
                
                if(((Boolean) invoice_entity.getAttributeValue("C_is_Paying_VAT")==false)){
                    System.out.println("C_is_Paying_VAT ="+(Boolean) invoice_entity.getAttributeValue("C_is_Paying_VAT"));
                    System.out.println("Invoice percent is also removed");
                    classifiedTaxCategoryInvoice44 = new ClassifiedTaxCategory.ClassifiedTaxCategoryBuilder()
                    .id(new ID.IDBuilder()
                            .value((String) lines[i].getAttributeValue("sc_efactura_VAT_Type"))
                            .build())                    
                    .taxScheme(taxSchemeInvoice44)
                    .build();
                }
                else{
                    classifiedTaxCategoryInvoice44 = new ClassifiedTaxCategory.ClassifiedTaxCategoryBuilder()
                    .id(new ID.IDBuilder()
                            .value((String) lines[i].getAttributeValue("sc_efactura_VAT_Type"))
                            .build())
                    .percent(new Percent.PercentBuilder().value(VATRate_SC).build())
                    .taxScheme(taxSchemeInvoice44)
                    .build();

                }           

            //INVOICE LINE > ITEM
                Item item44 = new Item.ItemBuilder()       
                       .name(new Name.NameBuilder()
                            .value((String) lines[i].getAttributeValue("ServiceOrProduct"))
                            .build())
                       .classifiedTaxCategory(classifiedTaxCategoryInvoice44)
                       .build();

                
                
            //INVOICE LINE > PRICE
                Price price44 = new Price.PriceBuilder()
                    .priceAmount(new PriceAmount.PriceAmountBuilder()
                            .value(price)
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                    .currencyID((String) lines[i].getAttributeValue("sc_currency_code"))
                                    .build())
                            
                            .build())
                    .baseQuantity(new BaseQuantity.BaseQuantityBuilder()
                            .value(quantity)
                            .attributes(new PatternCode.PatternCodeBuilder()
                                    .unitCode((String) lines[i].getAttributeValue("sc_efactura_um_type"))
                                    .build())
                            .build())                        
                    .build();

            //  INVOICE LINE
                InvoiceLine invoiceLine44 = new InvoiceLine.InvoiceLineBuilder()        
                    .id(new ID.IDBuilder()
                            .value(recordOrder.toString())
                            .attributes(new PatternScheme.PatternSchemeBuilder()
                                    .build())
                            .build())
                    .invoicedQuantity(new InvoicedQuantity.InvoicedQuantityBuilder()
                            .value(quantity)
                            .attributes(new PatternCode.PatternCodeBuilder()
                                    .unitCode((String) lines[i].getAttributeValue("sc_efactura_um_type"))
                                    .build())
                            .build())
                    .lineExtensionAmount(new LineExtensionAmount.LineExtensionAmountBuilder()
                            .value(totalValueNoVat)
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                    .currencyID((String) lines[i].getAttributeValue("sc_currency_code"))
                                    .build())
                            .build())
                    .item(item44)
                    .price(price44)
                    .build();
                    invoiceLineList44.add(invoiceLine44);
            }
            
    /**
     * Element ROOT
     */
                System.out.println(invoiceLineList44);

                    //Creating the XML with the values
                System.out.println("Element start");
          
                String ron="RON";
                if((Boolean) invoice_entity.getAttributeValue("CurrencySC").equals(ron))                    
                {
                    System.out.println((Boolean) invoice_entity.getAttributeValue("CurrencySC").equals(ron));
                  System.out.println("This is belongs to only B condition");
                     Element elementInvoice = (Element) new UBLTest.UBLTestBuilder()

                            .documentLinked(docInvoice.getDoc())
                            .customizationID(customizationID)
                            .id(id)
                            .dueDate(dueDate)
                            .issueDate(issueDate)
                            .invoiceTypeCode(invoiceTypeCode)
                            .documentCurrencyCode(documentCurrencyCode)   
                            .taxCurrencyCode(taxCurrencyCode)   
                            .accountingSupplierParty(elementAccountingSupplierPartyInvoice)
                            .accountingCustomerParty(elementAccountingCustomerPartyCreditNote)
                            .taxTotalList(taxTotal44)
                                                
                            .legalMonetaryTotal(legalMonetaryTotalInvoice1)
                            .invoiceLineList(invoiceLineList44)

                            .build().load();
                            docInvoice.generate();   
                }
                else{
                    System.out.println((Boolean) invoice_entity.getAttributeValue("CurrencySC").equals(ron));                    
                    System.out.println("This is belongs to A, C, D condition");
                     Element elementInvoice = (Element) new UBLTest.UBLTestBuilder()

                            .documentLinked(docInvoice.getDoc())
                            .customizationID(customizationID)
                            .id(id)
                            .dueDate(dueDate)
                            .issueDate(issueDate)
                            .invoiceTypeCode(invoiceTypeCode)
                            .documentCurrencyCode(documentCurrencyCode)   
                            .taxCurrencyCode(taxCurrencyCode)   
                            .accountingSupplierParty(elementAccountingSupplierPartyInvoice)
                            .accountingCustomerParty(elementAccountingCustomerPartyCreditNote)
                            .taxTotalList(taxTotal44)               
                            .taxTotalList2(taxTotal444)   
                            .legalMonetaryTotal(legalMonetaryTotalInvoice1)
                            .invoiceLineList(invoiceLineList44)

                            .build().load();
                            docInvoice.generate();   
                }

                        
                            
                System.out.println("XML is successfully created on given path");            

        }   
        
        catch (ParserConfigurationException ex) 
        {
            Logger.getLogger(MyProcessLibrary.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ParaserConfiguration Exception occur");
        } 
        catch (TransformerException | NullPointerException ex) 
        {
            Logger.getLogger(MyProcessLibrary.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Provide the given attribute value=" +ex.toString());
        }
        
        catch (InvalidParameterException ex) 
        {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Attribute not found " + ex.toString());                                            
            return "Attribute not found " + ex.toString();
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
