package com.basicx.efaktura.elements;

import com.basicx.efaktura.attributes.PatternLanguage;
import com.basicx.efaktura.attributes.PatternScheme;
import com.basicx.efaktura.axioms.AttributeT;
import com.basicx.efaktura.axioms.ElementT;
import com.basicx.efaktura.axioms.Tips;
import com.basicx.efaktura.data.AttributesName;
import com.basicx.efaktura.data.ElementsName;
import com.basicx.efaktura.elements.InvoiceNumber.InvoiceNumberBuilder;
import java.util.Date;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class IssueDate
 */
public class IssueDate {

    private Document doc;
    private Element element;
    private String name = ElementsName.ISSUE_DATE.label;
    private String value;
    
    private PatternLanguage patternLanguage;

    /**
     * <h2>Element "IssueDate"</h2>
     * <p>The date assigned by the Creditor on which the Credit Note was issued. Contains :</p>
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
    private IssueDate(IssueDateBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.patternLanguage = builder.patternLanguage;
        
        this.value = builder.value;

    }

    /**
     * Builder IssueDate
     */
    public static class IssueDateBuilder {

        private Document doc;
        private Element element;
        private String name = ElementsName.ISSUE_DATE.label;
        private String value;
        
        private PatternLanguage patternLanguage;

        public IssueDateBuilder() {}

        public IssueDateBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public IssueDateBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        
        public IssueDateBuilder value(String value){
            this.value = value;
            return this;
        }
//        
       
         
        public IssueDateBuilder attributes(PatternLanguage patternLanguage){
            this.patternLanguage = patternLanguage;
            return this;
        }
        
        public IssueDate build(){
            IssueDate element = new IssueDate(this);
            return element;
        }

    }
    public PatternLanguage getPatternLanguage() {
        return patternLanguage;
    }

//    public String getValue() {
//        return value;
//    }
    public String getValue() {
        return value;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
    	Element elementRoot = new ElementT(doc, element, name, value).load();
        if(!(patternLanguage == null)){
            if(!(patternLanguage.getLanguageID() == null)){
                Attr elementRoot_Attr1 = new AttributeT(doc, elementRoot, AttributesName.ISSUE_DATE.label, patternLanguage.getLanguageID()).load();
            }
        }
		return elementRoot;
    }

}
