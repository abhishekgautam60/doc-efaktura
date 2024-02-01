package com.basicx.efaktura.elements;

import com.basicx.efaktura.attributes.PatternCode;
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
 * Class InvoicedQuantity
 */
public class InvoicedQuantity {

    private Document doc;
    private Element element;
    private String name = ElementsName.INVOICED_QUANTITY.label;
    private String value;
    private PatternCode patternCode;

    /**
     * <h2>Element "InvoicedQuantity"</h2>
     * <p>The quantity (of Items) on the Invoice Line. Contains :</p>
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
     *         <li>[PatternCode] <b>patternCode</b> <b>[0..1]</b> : Attributes available for this element.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private InvoicedQuantity(InvoicedQuantityBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternCode = builder.patternCode;
    }

    /**
     * Builder InvoicedQuantity
     */
    public static class InvoicedQuantityBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternCode patternCode;

        public InvoicedQuantityBuilder() {}

        public InvoicedQuantityBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public InvoicedQuantityBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public InvoicedQuantityBuilder value(String value){
            this.value = value;
            return this;
        }
        public InvoicedQuantityBuilder attributes(PatternCode patternCode){
            this.patternCode = patternCode;
            return this;
        }
        public InvoicedQuantity build(){
            InvoicedQuantity element = new InvoicedQuantity(this);
            return element;
        }

    }

    public String getValue() {
        return value;
    }

    public PatternCode getPatternCode() {
        return patternCode;
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
        if(!Tips.stringIsNull(patternCode.getUnitCode())){
            Attr elementID_Attr1 = new AttributeT(doc, elementRoot, AttributesName.UNIT_CODE.label, patternCode.getUnitCode()).load();
        }
        return elementRoot;
    }

}