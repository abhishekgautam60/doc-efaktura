package com.basicx.efaktura.elements;

import com.basicx.efaktura.attributes.PatternCurrency;
import com.basicx.efaktura.axioms.AttributeT;
import com.basicx.efaktura.axioms.ElementT;
import com.basicx.efaktura.axioms.Tips;
import com.basicx.efaktura.data.AttributesName;
import com.basicx.efaktura.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class PriceAmount
 */
public class PriceAmount {

    private Document doc;
    private Element element;
    private String name = ElementsName.PRICE_AMOUNT.label;
    private String value;
    private PatternCurrency patternCurrency;

    /**
     * <h2>Element "PriceAmount"</h2>
     * <p>The earliest version of the UBL 2 schema for this document type that defines all of the elements that might be encountered in the current instance. Contains :</p>
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
     *         <li>[PatternCurrency] <b>patternCurrency</b> <b>[0..1]</b> : Attributes available for this element.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private PriceAmount(PriceAmountBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternCurrency = builder.patternCurrency;
    }

    /**
     * Builder PriceAmount
     */
    public static class PriceAmountBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternCurrency patternCurrency;

        public PriceAmountBuilder() {}

        public PriceAmountBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PriceAmountBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PriceAmountBuilder value(String value){
            this.value = value;
            return this;
        }
        public PriceAmountBuilder attributes(PatternCurrency patternCurrency){
            this.patternCurrency = patternCurrency;
            return this;
        }
        public PriceAmount build(){
            PriceAmount elementBuild = new PriceAmount(this);
            return elementBuild;
        }

    }

    public String getValue() {
        return value;
    }

    public PatternCurrency getPatternCurrency() {
        return patternCurrency;
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
        if(!(patternCurrency == null)){
            if(!(patternCurrency.getCurrencyID() == null)){
                Attr elementRoot_Attr1 = new AttributeT(doc, elementRoot, AttributesName.CURRENCY_ID.label, patternCurrency.getCurrencyID()).load();
            }
        }
        return elementRoot;
    }

}
