package com.basicx.efaktura.modules;

import com.basicx.efaktura.attributes.PatternScheme;
import com.basicx.efaktura.axioms.AttributeT;
import com.basicx.efaktura.axioms.ElementT;
import com.basicx.efaktura.axioms.Tips;
import com.basicx.efaktura.data.AttributesName;
import com.basicx.efaktura.data.ElementsName;
import com.basicx.efaktura.data.NamespacesName;
import com.basicx.efaktura.elements.ID;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class FinancialInstitution
 */
public class FinancialInstitution {

    private Document doc;
    private Element element;
    private ID id;

    /**
     * <h2>Element "FinancialInstitution"</h2>
     * <p>An association to Financial Institution. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[ID] <b>id</b> <b>[0..1]</b> : The identifier for the Financial Institution expressed as a code; ISO 9362 BIC (Bank Identification Code) is recommended.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private FinancialInstitution(FinancialInstitutionBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
    }

    /**
     * Builder FinancialInstitution
     */
    public static class FinancialInstitutionBuilder {

        private Document doc;
        private Element element;
        private ID id;

        public FinancialInstitutionBuilder() {}

        public FinancialInstitutionBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public FinancialInstitutionBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public FinancialInstitutionBuilder id(ID id){
            this.id = id;
            return this;
        }
        public FinancialInstitution build(){
            FinancialInstitution element = new FinancialInstitution(this);
            return element;
        }

    }

    public ID getId() {
        return id;
    }

    public boolean isNull() {
        if(Tips.stringIsNull(id.getValue())){
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
        Element elementRoot = new ElementT(doc, ElementsName.FINANCIAL_INSTITUTION.label).load();
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
        return elementRoot;
    }

}