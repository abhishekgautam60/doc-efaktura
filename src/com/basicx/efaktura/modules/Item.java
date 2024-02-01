package com.basicx.efaktura.modules;

import com.basicx.efaktura.attributes.PatternLanguage;
import com.basicx.efaktura.axioms.ElementT;
import com.basicx.efaktura.axioms.Tips;
import com.basicx.efaktura.data.ElementsName;
import com.basicx.efaktura.elements.Description;
import com.basicx.efaktura.elements.Name;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Item
 */
public class Item {

    private Document doc;
    private Element element;
    private List<Description> descriptionList = new ArrayList<>();
    private Name name;
    private SellersItemIdentification sellersItemIdentification;
    private ClassifiedTaxCategory classifiedTaxCategory;

    /**
     * <h2>Element "Item"</h2>
     * <p>An association to Item. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[List] <b>descriptionList</b> <b>[0..*]</b> : [Description] elements list.</li>
     *         <li>[Name] <b>name</b> <b>[0..1]</b> : A short name optionally given to an item, such as a name from a Catalogue, as distinct from a description.</li>
     *         <li>[SellersItemIdentification] <b>sellersItemIdentification</b> <b>[0..1]</b> : Associates the item with its identification according to the seller's system.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private Item(ItemBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.descriptionList = builder.descriptionList;
        this.name = builder.name;
        this.sellersItemIdentification = builder.sellersItemIdentification;
        this.classifiedTaxCategory = builder.classifiedTaxCategory;
    }

    /**
     * Builder Item
     */
    public static class ItemBuilder {

        private Document doc;
        private Element element;
        private List<Description> descriptionList = new ArrayList<>();
        private Name name;
        private SellersItemIdentification sellersItemIdentification;
        private ClassifiedTaxCategory classifiedTaxCategory;

        public ItemBuilder() {}

        public ItemBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public ItemBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public ItemBuilder descriptionList(List<Description> descriptionList){
            this.descriptionList = descriptionList;
            return this;
        }
        public ItemBuilder name(Name name){
            this.name = name;
            return this;
        }
        public ItemBuilder sellersItemIdentification(SellersItemIdentification sellersItemIdentification){
            this.sellersItemIdentification = sellersItemIdentification;
            return this;
        }
        public ItemBuilder classifiedTaxCategory(ClassifiedTaxCategory classifiedTaxCategory){
            this.classifiedTaxCategory = classifiedTaxCategory;
            return this;
        }
        
        
        public Item build(){
            Item item = new Item(this);
            return item;
        }

    }

    public List<Description> getDescriptionList() {
        return descriptionList;
    }

    public Name getName() {
        return name;
    }

    public SellersItemIdentification getSellersItemIdentification() {
        return sellersItemIdentification;
    }
    
    public ClassifiedTaxCategory getClassifiedTaxCategory() {
        return classifiedTaxCategory;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementItem = new ElementT(doc, element, ElementsName.ITEM.label).load();
        if(!Tips.listIsNull(descriptionList)){
            for (Description description : descriptionList) {
                if(!(description.getPatternLanguage() == null)){
                    Element elementDescription = new Description.DescriptionBuilder()
                            .documentLinked(doc)
                            .elementFather(elementItem)
                            .value(description.getValue())
                            .attributes(new PatternLanguage.PatternLanguageBuilder()
                                    .languageID(description.getPatternLanguage().getLanguageID())
                                    .build())
                            .build().load();
                } else {
                    Element elementDescription = new Description.DescriptionBuilder()
                            .documentLinked(doc)
                            .elementFather(elementItem)
                            .value(description.getValue())
                            .build().load();
                }
            }
        }
        if(!(name == null)){
            if(!(name.getPatternLanguage() == null)){
                Element elementName = new Name.NameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementItem)
                        .value(name.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(name.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementName = new Name.NameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementItem)
                        .value(name.getValue())
                        .build().load();
            }
        }
        if(!(sellersItemIdentification == null)){
            Element elementSellersItemIdentification = new SellersItemIdentification.SellersItemIdentificationBuilder()
                    .documentLinked(doc)
                    .elementFather(elementItem)
                    .id(sellersItemIdentification.getId())
                    .build().load();
        }
        
        if(!(classifiedTaxCategory == null)){
            Element elementTaxCategory = new ClassifiedTaxCategory.ClassifiedTaxCategoryBuilder()
                    .documentLinked(doc)
                    .elementFather(elementItem)
                    .id(classifiedTaxCategory.getId())
                    .percent(classifiedTaxCategory.getPercent())
                    .taxScheme(classifiedTaxCategory.getTaxScheme())
                    .build().load();
        }
        return elementItem;
    }

}
