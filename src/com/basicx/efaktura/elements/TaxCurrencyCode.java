/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicx.efaktura.elements;

import com.basicx.efaktura.attributes.PatternLanguage;
import com.basicx.efaktura.axioms.AttributeT;
import com.basicx.efaktura.axioms.ElementT;
import com.basicx.efaktura.axioms.Tips;
import com.basicx.efaktura.data.AttributesName;
import com.basicx.efaktura.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Abhishek.Gautam
 */
public class TaxCurrencyCode {
    private Document doc;
    private Element element;
    private String name = ElementsName.TAXCURRENCY_CODE.label;
    private String value;
    private PatternLanguage patternLanguage;

    /**
     * <h2>Element "DocumentCurrencyCode"</h2>
     * <p>The default currency for the Credit Note. Contains :</p>
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
     *         <li>[PatternList] <b>patternList</b> <b>[0..1]</b> : Attributes available for this element.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private TaxCurrencyCode(TaxCurrencyCodeBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternLanguage = builder.patternLanguage;
    }

    /**
     * Builder DocumentCurrencyCode
     */
    public static class TaxCurrencyCodeBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternLanguage patternLanguage;

        public TaxCurrencyCodeBuilder() {}

        public TaxCurrencyCodeBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public TaxCurrencyCodeBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public TaxCurrencyCodeBuilder value(String value){
            this.value = value;
            return this;
        }
        public TaxCurrencyCodeBuilder attributes(PatternLanguage patternLanguage){
            this.patternLanguage = patternLanguage;
            return this;
        }
        public TaxCurrencyCode build(){
            TaxCurrencyCode element = new TaxCurrencyCode(this);
            return element;
        }

    }

    public String getValue() {
        return value;
    }

    public PatternLanguage getPatternLanguage() {
        return patternLanguage;
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
        if(!(patternLanguage == null)){
            if(!(patternLanguage.getLanguageID() == null)){
                Attr elementRoot_Attr1 = new AttributeT(doc, elementRoot, AttributesName.TAXCURRENCY_CODE.label, patternLanguage.getLanguageID()).load();
            }
        }
        return elementRoot;
    }

}
