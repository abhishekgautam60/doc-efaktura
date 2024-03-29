package xml.ubl.templates;

import com.basicx.efaktura.attributes.PatternScheme;
import com.basicx.efaktura.axioms.AttributeT;
import com.basicx.efaktura.axioms.ElementT;
import com.basicx.efaktura.data.ElementsName;
import com.basicx.efaktura.data.NamespacesName;
import com.basicx.efaktura.elements.CustomizationID;
import com.basicx.efaktura.elements.DocumentCurrencyCode;
import com.basicx.efaktura.elements.ID;
import com.basicx.efaktura.elements.IssueDate;
import com.basicx.efaktura.elements.ProfileID;
import com.basicx.efaktura.elements.UBLVersionID;
import com.basicx.efaktura.modules.AccountingCustomerParty;
import com.basicx.efaktura.modules.AccountingSupplierParty;
import com.basicx.efaktura.modules.AdditionalDocumentReference;
import com.basicx.efaktura.modules.BillingReference;
import com.basicx.efaktura.modules.CreditNoteLine;
import com.basicx.efaktura.modules.LegalMonetaryTotal;
import com.basicx.efaktura.modules.OrderReference;
import com.basicx.efaktura.modules.TaxTotal;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

/**
 * Class UBLCreditNote20
 */
public class UBLCreditNote20 {

    private Document doc;
    private UBLVersionID ublVersionID;
    private CustomizationID customizationID;
    private ProfileID profileID;
    private ID id;
    private IssueDate issueDate;
    private DocumentCurrencyCode documentCurrencyCode;
    private OrderReference orderReference;
    private List<BillingReference> billingReferenceList;
    private List<AdditionalDocumentReference> additionalDocumentReferenceList;
    private AccountingSupplierParty accountingSupplierParty;
    private AccountingCustomerParty accountingCustomerParty;
    private List<TaxTotal> taxTotalList;
    private LegalMonetaryTotal legalMonetaryTotal;
    private List<CreditNoteLine> creditNoteLineList;

    /**
     * <h2>Template "UBLCreditNote20"</h2>
     * <p>A document used to specify credits due to the Debtor from the Creditor. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[UBLVersionID] <b>ublVersionID</b> <b>[0..1]</b> : The earliest version of the UBL 2 schema for this document type that defines all of the elements that might be encountered in the current instance.</li>
     *         <li>[CustomizationID] <b>customizationID</b> <b>[0..1]</b> : Identifies a user-defined customization of UBL for a specific use.</li>
     *         <li>[ProfileID] <b>profileID</b> <b>[0..1]</b> : Identifies a user-defined profile of the customization of UBL being used.</li>
     *         <li>[ID] <b>id</b> <b>[1..1]</b> : An identifier for the Credit Note assigned by the Creditor.</li>
     *         <li>[IssueDate] <b>issueDate</b> <b>[1..1]</b> : The date assigned by the Creditor on which the Credit Note was issued.</li>
     *         <li>[DocumentCurrencyCode] <b>documentCurrencyCode</b> <b>[0..1]</b> : The default currency for the Credit Note.</li>
     *         <li>[OrderReference] <b>orderReference</b> <b>[0..1]</b> : An association to Order Reference.</li>
     *         <li>[List] <b>billingReferenceList</b> <b>[0..*]</b> : [BillingReference] elements list.</li>
     *         <li>[List] <b>additionalDocumentReferenceList</b> <b>[0..*]</b> : [AdditionalDocumentReference] elements list.</li>
     *         <li>[AccountingSupplierParty] <b>accountingSupplierParty</b> <b>[1..1]</b> : An association to the Accounting Supplier Party.</li>
     *         <li>[AccountingCustomerParty] <b>accountingCustomerParty</b> <b>[1..1]</b> : An association to the Accounting Customer Party.</li>
     *         <li>[List] <b>taxTotalList</b> <b>[0..*]</b> : [TaxTotal] elements list.</li>
     *         <li>[LegalMonetaryTotal] <b>legalMonetaryTotal</b> <b>[1..1]</b> : An association to the total amount payable on the Credit Note, including Allowances, Charges, and Taxes.</li>
     *         <li>[List] <b>creditNoteLineList</b> <b>[1..*]</b> : [CreditNoteLine] elements list.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private UBLCreditNote20(UBLCreditNote20Builder builder) {
        this.doc = builder.doc;
        this.ublVersionID = builder.ublVersionID;
        this.customizationID = builder.customizationID;
        this.profileID = builder.profileID;
        this.id = builder.id;
        this.issueDate = builder.issueDate;
        this.documentCurrencyCode = builder.documentCurrencyCode;
        this.orderReference = builder.orderReference;
        this.billingReferenceList = builder.billingReferenceList;
        this.additionalDocumentReferenceList = builder.additionalDocumentReferenceList;
        this.accountingSupplierParty = builder.accountingSupplierParty;
        this.accountingCustomerParty = builder.accountingCustomerParty;
        this.taxTotalList = builder.taxTotalList;
        this.legalMonetaryTotal = builder.legalMonetaryTotal;
        this.creditNoteLineList = builder.creditNoteLineList;
    }

    /**
     * Builder UBLCreditNote20
     */
    public static class UBLCreditNote20Builder {

        private Document doc;
        private UBLVersionID ublVersionID;
        private CustomizationID customizationID;
        private ProfileID profileID;
        private ID id;

        private IssueDate issueDate;
        private DocumentCurrencyCode documentCurrencyCode;
        private OrderReference orderReference;
        private List<BillingReference> billingReferenceList;
        private List<AdditionalDocumentReference> additionalDocumentReferenceList;

        private AccountingSupplierParty accountingSupplierParty;
        private AccountingCustomerParty accountingCustomerParty;
        private List<TaxTotal> taxTotalList;
        private LegalMonetaryTotal legalMonetaryTotal;
        private List<CreditNoteLine> creditNoteLineList;

        public UBLCreditNote20Builder() {}

        public UBLCreditNote20Builder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public UBLCreditNote20Builder ublVersionID(UBLVersionID ublVersionID){
            this.ublVersionID = ublVersionID;
            return this;
        }
        public UBLCreditNote20Builder customizationID(CustomizationID customizationID){
            this.customizationID = customizationID;
            return this;
        }
        public UBLCreditNote20Builder profileID(ProfileID profileID){
            this.profileID = profileID;
            return this;
        }
        public UBLCreditNote20Builder id(ID id){
            this.id = id;
            return this;
        }
        public UBLCreditNote20Builder issueDate(IssueDate issueDate){
            this.issueDate = issueDate;
            return this;
        }
        public UBLCreditNote20Builder documentCurrencyCode(DocumentCurrencyCode documentCurrencyCode){
            this.documentCurrencyCode = documentCurrencyCode;
            return this;
        }
        public UBLCreditNote20Builder orderReference(OrderReference orderReference){
            this.orderReference = orderReference;
            return this;
        }
        public UBLCreditNote20Builder billingReferenceList(List<BillingReference> billingReferenceList){
            this.billingReferenceList = billingReferenceList;
            return this;
        }
        public UBLCreditNote20Builder additionalDocumentReferenceList(List<AdditionalDocumentReference> additionalDocumentReferenceList){
            this.additionalDocumentReferenceList = additionalDocumentReferenceList;
            return this;
        }
        public UBLCreditNote20Builder accountingSupplierParty(AccountingSupplierParty accountingSupplierParty){
            this.accountingSupplierParty = accountingSupplierParty;
            return this;
        }
        public UBLCreditNote20Builder accountingCustomerParty(AccountingCustomerParty accountingCustomerParty){
            this.accountingCustomerParty = accountingCustomerParty;
            return this;
        }
        public UBLCreditNote20Builder taxTotalList(List<TaxTotal> taxTotalList){
            this.taxTotalList = taxTotalList;
            return this;
        }
        public UBLCreditNote20Builder legalMonetaryTotal(LegalMonetaryTotal legalMonetaryTotal){
            this.legalMonetaryTotal = legalMonetaryTotal;
            return this;
        }
        public UBLCreditNote20Builder creditNoteLineList(List<CreditNoteLine> creditNoteLineList){
            this.creditNoteLineList = creditNoteLineList;
            return this;
        }
        public UBLCreditNote20 build(){
            UBLCreditNote20 ublCreditNote20 = new UBLCreditNote20(this);
            return ublCreditNote20;
        }

    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        //System.out.println("/**");
        //System.out.println("* TEMPLATE CREDIT NOTE 2.0 (from XML-UBL in Github)");
        //System.out.println("* version 1.1.0");
        //System.out.println("*/");
        Element elementCreditNote = new ElementT(doc, ElementsName.CREDIT_NOTE.label).loadDoc();
        Attr attrEleCreditCard1 = new AttributeT(doc, elementCreditNote, NamespacesName.XMLNS.label, NamespacesName.XMLNS_IMPORT.label).load();
        Attr attrEleCreditCard2 = new AttributeT(doc, elementCreditNote, NamespacesName.XMLNS_CAC_ATTR.label, NamespacesName.XMLNS_CAC_IMPORT.label).load();
        Attr attrEleCreditCard3 = new AttributeT(doc, elementCreditNote, NamespacesName.XMLNS_CBC_ATTR.label, NamespacesName.XMLNS_CBC_IMPORT.label).load();
        Attr attrEleCreditCard4 = new AttributeT(doc, elementCreditNote, NamespacesName.XMLNS_CCTS_ATTR.label, NamespacesName.XMLNS_CCTS_IMPORT.label).load();
        Attr attrEleCreditCard5 = new AttributeT(doc, elementCreditNote, NamespacesName.XMLNS_EXT_ATTR.label, NamespacesName.XMLNS_EXT_IMPORT.label).load();
        Attr attrEleCreditCard6 = new AttributeT(doc, elementCreditNote, NamespacesName.XMLNS_NS7_ATTR.label, NamespacesName.XMLNS_NS7_IMPORT.label).load();
        Attr attrEleCreditCard7 = new AttributeT(doc, elementCreditNote, NamespacesName.XMLNS_SDT_ATTR.label, NamespacesName.XMLNS_SDT_IMPORT.label).load();
        Attr attrEleCreditCard8 = new AttributeT(doc, elementCreditNote, NamespacesName.XMLNS_UDT_ATTR.label, NamespacesName.XMLNS_UDT_IMPORT.label).load();

        if(!(ublVersionID == null)){
            if(!(ublVersionID.getPatternScheme() == null)){
                Element elementUBLVersionID = new UBLVersionID.UBLVersionIDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNote)
                        .value(ublVersionID.getValue())
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID(ublVersionID.getPatternScheme().getSchemeID())
                                .schemeName(ublVersionID.getPatternScheme().getSchemeName())
                                .schemeAgencyID(ublVersionID.getPatternScheme().getSchemeAgencyID())
                                .schemeAgencyName(ublVersionID.getPatternScheme().getSchemeAgencyName())
                                .schemeVersionID(ublVersionID.getPatternScheme().getSchemeVersionID())
                                .schemeDataURI(ublVersionID.getPatternScheme().getSchemeDataURI())
                                .schemeURI(ublVersionID.getPatternScheme().getSchemeURI())
                                .build())
                        .build().load();
            } else {
                Element elementUBLVersionID = new UBLVersionID.UBLVersionIDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNote)
                        .value(ublVersionID.getValue())
                        .build().load();
            }
        }
//        if(!(customizationID == null)){
//            if(!(customizationID.getPatternScheme() == null)){
//                Element elementCustomizationID = new CustomizationID.CustomizationIDBuilder()
//                        .documentLinked(doc)
//                        .elementFather(elementCreditNote)
//                        .value(customizationID.getValue())
//                        .attributes(new PatternScheme.PatternSchemeBuilder()
//                                .schemeID(customizationID.getPatternScheme().getSchemeID())
//                                .schemeName(customizationID.getPatternScheme().getSchemeName())
//                                .schemeAgencyID(customizationID.getPatternScheme().getSchemeAgencyID())
//                                .schemeAgencyName(customizationID.getPatternScheme().getSchemeAgencyName())
//                                .schemeVersionID(customizationID.getPatternScheme().getSchemeVersionID())
//                                .schemeDataURI(customizationID.getPatternScheme().getSchemeDataURI())
//                                .schemeURI(customizationID.getPatternScheme().getSchemeURI())
//                                .build())
//                        .build().load();
//            } else {
//                Element elementCustomizationID = new CustomizationID.CustomizationIDBuilder()
//                        .documentLinked(doc)
//                        .elementFather(elementCreditNote)
//                        .value(customizationID.getValue())
//                        .build().load();
//            }
//        }
        if(!(profileID == null)){
            if(!(profileID.getPatternScheme() == null)){
                Element elementProfileID = new ProfileID.ProfileIDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNote)
                        .value(profileID.getValue())
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID(profileID.getPatternScheme().getSchemeID())
                                .schemeName(profileID.getPatternScheme().getSchemeName())
                                .schemeAgencyID(profileID.getPatternScheme().getSchemeAgencyID())
                                .schemeAgencyName(profileID.getPatternScheme().getSchemeAgencyName())
                                .schemeVersionID(profileID.getPatternScheme().getSchemeVersionID())
                                .schemeDataURI(profileID.getPatternScheme().getSchemeDataURI())
                                .schemeURI(profileID.getPatternScheme().getSchemeURI())
                                .build())
                        .build().load();
            } else {
                Element elementProfileID = new ProfileID.ProfileIDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNote)
                        .value(profileID.getValue())
                        .build().load();
            }
        }
        if(!(id == null)){
            if(!(id.getPatternScheme() == null)){
                Element elementID = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNote)
                        .value(id.getValue())
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID(id.getPatternScheme().getSchemeID())
                                .schemeName(id.getPatternScheme().getSchemeName())
                                .schemeAgencyID(id.getPatternScheme().getSchemeAgencyID())
                                .schemeAgencyName(id.getPatternScheme().getSchemeAgencyName())
                                .schemeVersionID(id.getPatternScheme().getSchemeVersionID())
                                .schemeDataURI(id.getPatternScheme().getSchemeDataURI())
                                .schemeURI(id.getPatternScheme().getSchemeURI())
                                .build())
                        .build().load();
            } else {
                Element elementID = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNote)
                        .value(id.getValue())
                        .build().load();
            }
        } else {
            //System.out.println("[CreditNote 2.0] : Attention ! The element ID is mandatory in this template.");
        }
        if(!(issueDate == null)){
            Element elementIssueDate = new IssueDate.IssueDateBuilder()
                    .documentLinked(doc)
                    .elementFather(elementCreditNote)
                    .value(issueDate.getValue())
                    .build().load();
        }
//        if(!(documentCurrencyCode == null)){
//            if(!(documentCurrencyCode.getPatternList() == null)){
//                Element elementCurrencyCode = new DocumentCurrencyCode.DocumentCurrencyCodeBuilder()
//                        .documentLinked(doc)
//                        .elementFather(elementCreditNote)
//                        .value(documentCurrencyCode.getValue())
//                        .attributes(new PatternList.PatternListBuilder()
//                                .listID(documentCurrencyCode.getPatternList().getListID())
//                                .listAgencyID(documentCurrencyCode.getPatternList().getListAgencyID())
//                                .listAgencyName(documentCurrencyCode.getPatternList().getListAgencyName())
//                                .listName(documentCurrencyCode.getPatternList().getListName())
//                                .listVersionID(documentCurrencyCode.getPatternList().getListVersionID())
//                                .name(documentCurrencyCode.getPatternList().getName())
//                                .languageID(documentCurrencyCode.getPatternList().getLanguageID())
//                                .listURI(documentCurrencyCode.getPatternList().getListURI())
//                                .listSchemeURI(documentCurrencyCode.getPatternList().getListSchemeURI())
//                                .build())
//                        .build().load();
//            } else {
//                Element elementCurrencyCode = new DocumentCurrencyCode.DocumentCurrencyCodeBuilder()
//                        .documentLinked(doc)
//                        .elementFather(elementCreditNote)
//                        .value(documentCurrencyCode.getValue())
//                        .build().load();
//            }
//        }
        if(!(orderReference == null)){
            Element elementOrderReference = new OrderReference.OrderReferenceBuilder()
                    .documentLinked(doc)
                    .elementFather(elementCreditNote)
                    .id(id)
                    .build().load();
        }
        if(!(billingReferenceList == null)){
            for (BillingReference billingReference : billingReferenceList) {
                Element elementBillingReference = new BillingReference.BillingReferenceBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNote)
                        .invoiceDocumentReference(billingReference.getInvoiceDocumentReference())
                        .build().load();
            }
        }
        if(!(additionalDocumentReferenceList == null)){
            for (AdditionalDocumentReference additionalDocumentReference : additionalDocumentReferenceList) {
                Element elementAdditionalDocumentReference = new AdditionalDocumentReference.AdditionalDocumentReferenceBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNote)
                        .id(additionalDocumentReference.getId())
//                        .documentTypeCode(additionalDocumentReference.getDocumentTypeCode())
                        .attachment(additionalDocumentReference.getAttachment())
                        .build().load();
            }
        }
        if(!(accountingSupplierParty == null)){
            Element elementAccountingSupplierParty = new AccountingSupplierParty.AccountingSupplierPartyBuilder()
                    .documentLinked(doc)
                    .elementFather(elementCreditNote)
                    .party(accountingSupplierParty.getParty())
                    .build().load();
        }
        if(!(accountingCustomerParty == null)){
            Element elementAccountingCustomerParty = new AccountingCustomerParty.AccountingCustomerPartyBuilder()
                    .documentLinked(doc)
                    .elementFather(elementCreditNote)
                    .party(accountingCustomerParty.getParty())
                    .build().load();
        }
        if(!(taxTotalList == null)){
            for (TaxTotal taxTotal : taxTotalList) {
                Element elementTaxTotal = new TaxTotal.TaxTotalBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNote)
                        .taxAmount(taxTotal.getTaxAmount())
                        .taxSubTotalList(taxTotal.getTaxSubTotalList())
                        .build().load();
            }
        }
        if(!(legalMonetaryTotal == null)){
            Element elementLegalMonetaryTotal = new LegalMonetaryTotal.LegalMonetaryTotalBuilder()
                    .documentLinked(doc)
                    .elementFather(elementCreditNote)
                    .lineExtensionAmount(legalMonetaryTotal.getLineExtensionAmount())
                    .taxExclusiveAmount(legalMonetaryTotal.getTaxExclusiveAmount())
                    .taxInclusiveAmount(legalMonetaryTotal.getTaxInclusiveAmount())
                    .payableAmount(legalMonetaryTotal.getPayableAmount())
                    .build().load();
        }
        if(!(creditNoteLineList == null)){
            for (CreditNoteLine creditNoteLine : creditNoteLineList) {
                Element elementCreditNoteLine = new CreditNoteLine.CreditNoteLineBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNote)
                        .id(creditNoteLine.getId())
                        .creditedQuantity(creditNoteLine.getCreditedQuantity())
                        .lineExtensionAmount(creditNoteLine.getLineExtensionAmount())
                        .taxTotalList(creditNoteLine.getTaxTotalList())
                        .item(creditNoteLine.getItem())
                        .price(creditNoteLine.getPrice())
                        .build().load();
            }
        }
        return elementCreditNote;
    }


}
