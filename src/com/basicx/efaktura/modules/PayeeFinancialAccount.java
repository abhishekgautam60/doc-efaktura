package com.basicx.efaktura.modules;

import com.basicx.efaktura.attributes.PatternScheme;
import com.basicx.efaktura.axioms.ElementT;
import com.basicx.efaktura.axioms.Tips;
import com.basicx.efaktura.data.ElementsName;
import com.basicx.efaktura.elements.ID;
import com.basicx.efaktura.elements.Name;
import com.basicx.efaktura.elements.PaymentMeansCode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class PayeeFinancialAccount
 */
public class PayeeFinancialAccount {

    private Document doc;
    private Element element;
    private ID id;
    private FinancialInstitutionBranch financialInstitutionBranch;

    /**
     * <h2>Element "PayeeFinancialAccount"</h2>
     * <p>An association to the payee's Financial Account. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[ID] <b>id</b> <b>[0..1]</b> : The identifier for the Financial Account; the Bank Account Number.</li>
     *         <li>[FinancialInstitutionBranch] <b>financialInstitutionBranch</b> <b>[0..1]</b> : An association to Financial Institution Branch.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private PayeeFinancialAccount(PayeeFinancialAccountBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.financialInstitutionBranch = builder.financialInstitutionBranch;
    }

    /**
     * Builder PayeeFinancialAccount
     */
    public static class PayeeFinancialAccountBuilder {

        private Document doc;
        private Element element;
        private ID id;
        private FinancialInstitutionBranch financialInstitutionBranch;

        public PayeeFinancialAccountBuilder() {}

        public PayeeFinancialAccountBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PayeeFinancialAccountBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PayeeFinancialAccountBuilder id(ID id){
            this.id = id;
            return this;
        }
        public PayeeFinancialAccountBuilder financialInstitutionBranch(FinancialInstitutionBranch financialInstitutionBranch){
            this.financialInstitutionBranch = financialInstitutionBranch;
            return this;
        }
        public PayeeFinancialAccount build(){
            PayeeFinancialAccount element = new PayeeFinancialAccount(this);
            return element;
        }

    }

    public ID getId() {
        return id;
    }

    public FinancialInstitutionBranch getFinancialInstitutionBranch() {
        return financialInstitutionBranch;
    }

    public boolean isNull() {
        if(id.isNull() && financialInstitutionBranch.isNull()){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementRoot = new ElementT(doc, ElementsName.PAYEE_FINANCIAL_ACCOUNT.label).load();
        if(!(id == null)){
            if(!(id.getPatternScheme() == null)){
                Element elementId = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementRoot)
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
                Element elementId = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementRoot)
                        .value(id.getValue())
                        .build().load();
            }
        }
        if(!(financialInstitutionBranch == null)){
            Element elementFinancialInstitutionBranch = new FinancialInstitutionBranch.FinancialInstitutionBranchBuilder()
                    .documentLinked(doc)
                    .elementFather(elementRoot)
                    .financialInstitution(financialInstitutionBranch.getFinancialInstitution())
                    .build().load();
        }
        return elementRoot;
    }
}
