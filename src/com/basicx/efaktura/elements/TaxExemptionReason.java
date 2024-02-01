/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicx.efaktura.elements;

import com.basicx.efaktura.axioms.ElementT;
import com.basicx.efaktura.axioms.Tips;
import com.basicx.efaktura.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Abhishek.Gautam
 */
public class TaxExemptionReason {
    private Document doc;
    private Element element;
    private String name = ElementsName.TAXEXEMPTIONREASON.label;
    private String value;

    /**
     * <h2>Element "Percent"</h2>
     * <p>The tax rate for the category, expressed as a percentage. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>value</b> <b>[1..1]</b> : Value for this element.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private TaxExemptionReason(TaxExemptionReasonBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
    }

    /**
     * Builder Percent
     */
    public static class TaxExemptionReasonBuilder {

        private Document doc;
        private Element element;
        private String value;

        public TaxExemptionReasonBuilder() {}

        public TaxExemptionReasonBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public TaxExemptionReasonBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public TaxExemptionReasonBuilder value(String value){
            this.value = value;
            return this;
        }
        public TaxExemptionReason build(){
            TaxExemptionReason elementBuild = new TaxExemptionReason(this);
            return elementBuild;
        }

    }

    public String getValue() {
        return value;
    }


    public boolean isNull() {
        if(Tips.stringIsNull(value)){
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
        Element elementRoot = new ElementT(doc, element, name, value).load();
        return elementRoot;
    }

}


