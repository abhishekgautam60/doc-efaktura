package com.basicx.efaktura.modules;

import com.basicx.efaktura.axioms.ElementT;
import com.basicx.efaktura.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * Class AccountingCustomerParty
 */
public class AccountingCustomerParty {

  
    private Document doc;
    private Element element;
    private Party party;

    /**
     * <h2>Element "AccountingCustomerParty"</h2>
     * <p>An association to the Accounting Customer Party. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[Party] <b>party</b> <b>[0..1]</b> : An association to Party.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private AccountingCustomerParty(AccountingCustomerPartyBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.party = builder.party;
    }

    /**
     * Builder AccountingCustomerParty
     */
    public static class AccountingCustomerPartyBuilder {

        private Document doc;
        private Element element;
        private Party party;

        public AccountingCustomerPartyBuilder() {}

        public AccountingCustomerPartyBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public AccountingCustomerPartyBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public AccountingCustomerPartyBuilder party(Party party){
            this.party = party;
            return this;
        }
        public AccountingCustomerParty build(){
            AccountingCustomerParty accountingCustomerParty = new AccountingCustomerParty(this);
            return accountingCustomerParty;
        }

    }

    public Party getParty() {
        return party;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementAccountingCustomerParty = new ElementT(doc,element, ElementsName.ACCOUNTING_CUSTOMER_PARTY.label).load();
        if(!(party == null)){
            Element elementParty = new Party.PartyBuilder()
                    .documentLinked(doc)
                    .elementFather(elementAccountingCustomerParty)
                    .partyIdentificationList(party.getPartyIdentificationList())
                    .partyNameList(party.getPartyNameList())
                    .postalAddress(party.getPostalAddress())
                    .partyTaxSchemeList(party.getPartyTaxSchemeList())
                    .partyLegalEntityList(party.getPartyLegalEntityList())
                    .contact(party.getContact())
                    .person(party.getPerson())
                    .build().load();
        }
        return elementAccountingCustomerParty;
    }

}
