package com.basicx.efaktura.modules;

import com.basicx.efaktura.axioms.ElementT;
import com.basicx.efaktura.axioms.Tips;
import com.basicx.efaktura.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

/**
 * Class BillingReference
 */
public class BillingReference {

    private Document doc;
    private Element element;
    private InvoiceDocumentReference invoiceDocumentReference;

    /**
     * <h2>Module "BillingReference"</h2>
     * <p>An association to Billing Reference. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[InvoiceDocumentReference] <b>invoiceDocumentReference</b> <b>[0..1]</b> : An associative reference to Invoice.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private BillingReference(BillingReferenceBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.invoiceDocumentReference = builder.invoiceDocumentReference;
    }

    /**
     * Builder BillingReference
     */
    public static class BillingReferenceBuilder {

        private Document doc;
        private Element element;
        private InvoiceDocumentReference invoiceDocumentReference;

        public BillingReferenceBuilder() {}

        public BillingReferenceBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public BillingReferenceBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public BillingReferenceBuilder invoiceDocumentReference(InvoiceDocumentReference invoiceDocumentReference){
            this.invoiceDocumentReference = invoiceDocumentReference;
            return this;
        }
        public BillingReference build(){
            BillingReference billingReference = new BillingReference(this);
            return billingReference;
        }

    }

    public InvoiceDocumentReference getInvoiceDocumentReference() {
        return invoiceDocumentReference;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementBillingReference = new ElementT(doc, ElementsName.BILLING_REFERENCE.label).load();
        if(!(invoiceDocumentReference == null)){
            Element elementInvoiceDocumentReference = new InvoiceDocumentReference.InvoiceDocumentReferenceBuilder()
                    .documentLinked(doc)
                    .elementFather(elementBillingReference)
                    .id(invoiceDocumentReference.getId())
                    .build().load();
        }
        return elementBillingReference;
    }

}
