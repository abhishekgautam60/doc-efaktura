package com.basicx.efaktura.elements;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.basicx.efaktura.attributes.PatternLanguage;
import com.basicx.efaktura.axioms.AttributeT;
import com.basicx.efaktura.axioms.ElementT;
import com.basicx.efaktura.axioms.Tips;
import com.basicx.efaktura.data.AttributesName;
import com.basicx.efaktura.data.ElementsName;
import com.basicx.efaktura.elements.BuildingNumber.BuildingNumberBuilder;

public class InvoiceNumber {

    private Document doc;
    private Element element;
    private String name = ElementsName.INVOICE_NUMBER.label;
    private String value;
    private PatternLanguage patternLanguage;

    /**
     * <h2>Element "InvoiceNumber"</h2>
     * <p>The number of a building. Contains :</p>
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
     *         <li>[PatternLanguage] <b>patternLanguage</b> <b>[0..1]</b> : Attributes available for this element.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private InvoiceNumber(InvoiceNumberBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternLanguage = builder.patternLanguage;
    }

    /**
     * Builder InvoiceNumber
     */
    public static class InvoiceNumberBuilder {

        private Document doc;
        private Element element;
        private String name = ElementsName.NAME.label;
        private String value;
        private PatternLanguage patternLanguage;

        public InvoiceNumberBuilder() {}

        public InvoiceNumberBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public InvoiceNumberBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public InvoiceNumberBuilder value(String value){
            this.value = value;
            return this;
        }
        public InvoiceNumberBuilder attributes(PatternLanguage patternLanguage){
            this.patternLanguage = patternLanguage;
            return this;
        }
        public InvoiceNumber build(){
        	InvoiceNumber elementBuild = new InvoiceNumber(this);
            return elementBuild;
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
                Attr elementRoot_Attr1 = new AttributeT(doc, elementRoot, AttributesName.INVOICE_ID.label, patternLanguage.getLanguageID()).load();
            }
        }
        return elementRoot;
    }


}
