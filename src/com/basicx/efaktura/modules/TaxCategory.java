package com.basicx.efaktura.modules;


import com.basicx.efaktura.attributes.PatternScheme;
import com.basicx.efaktura.axioms.AttributeT;
import com.basicx.efaktura.axioms.ElementT;
import com.basicx.efaktura.axioms.Tips;
import com.basicx.efaktura.data.AttributesName;
import com.basicx.efaktura.data.ElementsName;
import com.basicx.efaktura.elements.ID;
import com.basicx.efaktura.elements.Percent;
import com.basicx.efaktura.elements.TaxExemptionReason;
import com.basicx.efaktura.elements.TaxExemptionReasonCode;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Class TaxCategory
 */
public class TaxCategory {

    private Document doc;
    private Element element;
    private ID id;
    private Percent percent;
    private TaxExemptionReasonCode taxExemptionReasonCode;
    private TaxExemptionReason taxExemptionReason;
    private TaxScheme taxScheme;

    /**
     * <h2>Element "TaxCategory"</h2>
     * <p>An association to Tax Category. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[ID] <b>id</b> <b>[0..1]</b> : Identifies the tax category.</li>
     *         <li>[Percent] <b>percent</b> <b>[0..1]</b> : The tax rate for the category, expressed as a percentage.</li>
     *         <li>[TaxScheme] <b>taxScheme</b> <b>[1..1]</b> :  An association to Tax Scheme.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private TaxCategory(TaxCategoryBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.percent = builder.percent;
        this.taxExemptionReasonCode = builder.taxExemptionReasonCode;
        this.taxExemptionReason = builder.taxExemptionReason;
        this.taxScheme = builder.taxScheme;
    }

    /**
     * Builder Contact
     */
    public static class TaxCategoryBuilder {

        private Document doc;
        private Element element;
        private ID id;
        private Percent percent;
        private TaxExemptionReasonCode taxExemptionReasonCode;
        private TaxExemptionReason taxExemptionReason;
        private TaxScheme taxScheme;

        public TaxCategoryBuilder() {}

        public TaxCategoryBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public TaxCategoryBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public TaxCategoryBuilder id(ID id){
            this.id = id;
            return this;
        }
        public TaxCategoryBuilder percent(Percent percent){
            this.percent = percent;
            return this;
        }
        public TaxCategoryBuilder taxExemptionReasonCode(TaxExemptionReasonCode taxExemptionReasonCode){
            this.taxExemptionReasonCode = taxExemptionReasonCode;
            return this;
        }
        
        public TaxCategoryBuilder taxExemptionReason(TaxExemptionReason taxExemptionReason){
            this.taxExemptionReason = taxExemptionReason;
            return this;
        }
        public TaxCategoryBuilder taxScheme(TaxScheme taxScheme){
            this.taxScheme = taxScheme;
            return this;
        }
        public TaxCategory build(){
            TaxCategory taxCategory = new TaxCategory(this);
            return taxCategory;
        }

    }

    public ID getId() {
        return id;
    }

    public Percent getPercent() {
        return percent;
    }
    public TaxExemptionReasonCode getTaxExemptionReasonCode() {
        return taxExemptionReasonCode;
    }
    
     public TaxExemptionReason getTaxExemptionReason() {
        return taxExemptionReason;
    }

    public TaxScheme getTaxScheme() {
        return taxScheme;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementTaxCategory = new ElementT(doc,element, ElementsName.TAX_CATEGORY.label).load();
        if(!(id == null)){
            if(!(id.getPatternScheme() == null)){
                Element elementId = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementTaxCategory)
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
                        .elementFather(elementTaxCategory)
                        .value(id.getValue())
                        .build().load();
            }
        }
        if(!(percent == null)){
            Element elementPercent = new Percent.PercentBuilder()
                    .documentLinked(doc)
                    .elementFather(elementTaxCategory)
                    .value(percent.getValue())
                    .build().load();
        }
        
        if(!(taxExemptionReasonCode == null)){
            Element elementTaxExemptionReasonCode = new TaxExemptionReasonCode.TaxExemptionReasonCodeBuilder()
                    .documentLinked(doc)
                    .elementFather(elementTaxCategory)
                    .value(taxExemptionReasonCode.getValue())
                    .build().load();
        }
        
        if(!(taxExemptionReason == null)){
            Element elementPercent = new TaxExemptionReason.TaxExemptionReasonBuilder()
                    .documentLinked(doc)
                    .elementFather(elementTaxCategory)
                    .value(taxExemptionReason.getValue())
                    .build().load();
        }
        
        if(!(taxScheme == null)){
            Element elementTaxScheme = new TaxScheme.TaxSchemeBuilder()
                    .documentLinked(doc)
                    .elementFather(elementTaxCategory)
                    .id(taxScheme.getId())
                    .name(taxScheme.getName())
                    .build().load();
        }
        return elementTaxCategory;
    }

}
