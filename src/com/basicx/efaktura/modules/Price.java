package com.basicx.efaktura.modules;

import com.basicx.efaktura.attributes.PatternCode;
import com.basicx.efaktura.attributes.PatternCurrency;
import com.basicx.efaktura.axioms.AttributeT;
import com.basicx.efaktura.axioms.ElementT;
import com.basicx.efaktura.axioms.Tips;
import com.basicx.efaktura.data.AttributesName;
import com.basicx.efaktura.data.ElementsName;
import com.basicx.efaktura.elements.BaseQuantity;
import com.basicx.efaktura.elements.OrderableUnitFactorRate;
import com.basicx.efaktura.elements.PriceAmount;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class Price
 */
public class Price {

    private Document doc;
    private Element element;
    private PriceAmount priceAmount;
    private BaseQuantity baseQuantity;
    private OrderableUnitFactorRate orderableUnitFactorRate;

    /**
     * <h2>Element "Price"</h2>
     * <p>An association to Price. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[PriceAmount] <b>priceAmount</b> <b>[1..1]</b> : The price amount.</li>
     *         <li>[BaseQuantity] <b>baseQuantity</b> <b>[0..1]</b> : The actual quantity to which the price applies.</li>
     *         <li>[OrderableUnitFactorRate] <b>orderableUnitFactorRate</b> <b>[0..1]</b> : The factor by which the base price unit can be converted to the orderable unit.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private Price(PriceBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.priceAmount = builder.priceAmount;
        this.baseQuantity = builder.baseQuantity;
        this.orderableUnitFactorRate = builder.orderableUnitFactorRate;
    }

    /**
     * Builder Contact
     */
    public static class PriceBuilder {

        private Document doc;
        private Element element;
        private PriceAmount priceAmount;
        private BaseQuantity baseQuantity;
        private OrderableUnitFactorRate orderableUnitFactorRate;

        public PriceBuilder() {}

        public PriceBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PriceBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PriceBuilder priceAmount(PriceAmount priceAmount){
            this.priceAmount = priceAmount;
            return this;
        }
        public PriceBuilder baseQuantity(BaseQuantity baseQuantity){
            this.baseQuantity = baseQuantity;
            return this;
        }
        public PriceBuilder orderableUnitFactorRate(OrderableUnitFactorRate orderableUnitFactorRate){
            this.orderableUnitFactorRate = orderableUnitFactorRate;
            return this;
        }
        public Price build(){
            Price price = new Price(this);
            return price;
        }

    }

    public PriceAmount getPriceAmount() {
        return priceAmount;
    }

    public BaseQuantity getBaseQuantity() {
        return baseQuantity;
    }

    public OrderableUnitFactorRate getOrderableUnitFactorRate() {
        return orderableUnitFactorRate;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementPrice = new ElementT(doc, element,ElementsName.PRICE.label).load();
        if(!(priceAmount == null)){
            if(!(priceAmount.getPatternCurrency() == null)){
                Element elementPriceAmount = new PriceAmount.PriceAmountBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPrice)
                        .value(priceAmount.getValue())
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID(priceAmount.getPatternCurrency().getCurrencyID())
                                .build())
                        .build().load();
            } else {
                Element elementPriceAmount = new PriceAmount.PriceAmountBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPrice)
                        .value(priceAmount.getValue())
                        .build().load();
            }
        }
        if(!(baseQuantity == null)){
            if(!(baseQuantity.getPatternCode() == null)){
                Element elementBaseQuantity = new BaseQuantity.BaseQuantityBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPrice)
                        .value(baseQuantity.getValue())
                        .attributes(new PatternCode.PatternCodeBuilder()
                                .unitCode(baseQuantity.getPatternCode().getUnitCode())
                                .build())
                        .build().load();
            } else {
                Element elementBaseQuantity = new BaseQuantity.BaseQuantityBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPrice)
                        .value(baseQuantity.getValue())
                        .build().load();
            }
        }
        if(!(orderableUnitFactorRate == null)){
            Element elementOrderableUnitFactorRate = new OrderableUnitFactorRate.OrderableUnitFactorRateBuilder()
                    .documentLinked(doc)
                    .elementFather(elementPrice)
                    .value(orderableUnitFactorRate.getValue())
                    .build().load();
        }
        return elementPrice;
    }
}
