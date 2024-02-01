package com.basicx.efaktura.elements;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.basicx.efaktura.attributes.PatternLanguage;
import com.basicx.efaktura.axioms.AttributeT;
import com.basicx.efaktura.axioms.ElementT;
import com.basicx.efaktura.data.AttributesName;
import com.basicx.efaktura.data.ElementsName;
import com.basicx.efaktura.elements.IssueDate.IssueDateBuilder;

public class DueDate {
	 	private Document doc;
	    private Element element;
	    private String name = ElementsName.DUE_DATE.label;
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
	    private DueDate(DueDateBuilder builder) {
	        this.doc = builder.doc;
	        this.element = builder.element;
	        this.patternLanguage = builder.patternLanguage;
	        this.value = builder.value;

	    }

	    /**
	     * Builder IssueDate
	     */
	    public static class DueDateBuilder {

	        private Document doc;
	        private Element element;
	        private String name = ElementsName.DUE_DATE.label;
	        private String value;
	        private PatternLanguage patternLanguage;

	        public DueDateBuilder() {}

	        public DueDateBuilder documentLinked(Document doc){
	            this.doc = doc;
	            return this;
	        }
	        public DueDateBuilder elementFather(Element element){
	            this.element = element;
	            return this;
	        }
	        public DueDateBuilder value(String value){
	            this.value = value;
	            return this;
	        }
	        public DueDateBuilder attributes(PatternLanguage patternLanguage){
	            this.patternLanguage = patternLanguage;
	            return this;
	        }
	        
	        public DueDate build(){
	        	DueDate element = new DueDate(this);
	            return element;
	        }

	    }
	    public PatternLanguage getPatternLanguage() {
	        return patternLanguage;
	    }

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
	                Attr elementRoot_Attr1 = new AttributeT(doc, elementRoot, AttributesName.DUE_DATE.label, patternLanguage.getLanguageID()).load();
	            }
	        }
			return elementRoot;
	    }


}
