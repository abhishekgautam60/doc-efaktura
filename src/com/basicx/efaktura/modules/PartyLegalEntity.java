package com.basicx.efaktura.modules;

import com.basicx.efaktura.attributes.PatternLanguage;
import com.basicx.efaktura.attributes.PatternScheme;
import com.basicx.efaktura.axioms.AttributeT;
import com.basicx.efaktura.axioms.ElementT;
import com.basicx.efaktura.axioms.Tips;
import com.basicx.efaktura.data.AttributesName;
import com.basicx.efaktura.data.ElementsName;
import com.basicx.efaktura.elements.CompanyID;
import com.basicx.efaktura.elements.CompanyLegalForm;
import com.basicx.efaktura.elements.RegistrationName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class PartyLegalEntity
 */
public class PartyLegalEntity {

     private Document doc;
    private Element element;
    private RegistrationName registrationName;
    private CompanyID companyID;
    private RegistrationAddress registrationAddress;
    private CorporateRegistrationScheme corporateRegistrationScheme;
    private CompanyLegalForm companyLegalForm;

    /**
     * <h2>Element "PartyLegalEntity"</h2>
     * <p>An association to Party Legal Entity. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[RegistrationName] <b>registrationName</b> <b>[0..1]</b> : The name of a party as registered with the legal authority.</li>
     *         <li>[CompanyID] <b>companyId</b> <b>[0..1]</b> : Identifies a company as registered with the company registration scheme.</li>
     *         <li>[RegistrationAddress] <b>registrationAddress</b> <b>[0..1]</b> : Associates with the registered address of the party within a Corporate Registration Scheme.</li>
     *         <li>[CorporateRegistrationScheme] <b>corporateRegistrationScheme</b> <b>[0..1]</b> : Associates the party with a Corporate Registration Scheme.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private PartyLegalEntity(PartyLegalEntityBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.registrationName = builder.registrationName;
        this.companyID = builder.companyID;
        this.registrationAddress = builder.registrationAddress;
        this.corporateRegistrationScheme = builder.corporateRegistrationScheme;
        this.companyLegalForm = builder.companyLegalForm;
    }

    /**
     * Builder PartyLegalEntity
     */
    public static class PartyLegalEntityBuilder {

        private Document doc;
        private Element element;
        private RegistrationName registrationName;
        private CompanyID companyID;
        private RegistrationAddress registrationAddress;
        private CorporateRegistrationScheme corporateRegistrationScheme;
        private CompanyLegalForm companyLegalForm;

        public PartyLegalEntityBuilder(){}

        public PartyLegalEntityBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PartyLegalEntityBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PartyLegalEntityBuilder registrationName(RegistrationName registrationName){
            this.registrationName = registrationName;
            return this;
        }
        public PartyLegalEntityBuilder companyId(CompanyID companyId){
            this.companyID = companyId;
            return this;
        }
        public PartyLegalEntityBuilder registrationAddress(RegistrationAddress registrationAddress){
            this.registrationAddress = registrationAddress;
            return this;
        }
        public PartyLegalEntityBuilder corporateRegistrationScheme(CorporateRegistrationScheme corporateRegistrationScheme){
            this.corporateRegistrationScheme = corporateRegistrationScheme;
            return this;
        }
        
        public PartyLegalEntityBuilder companyLegalForm(CompanyLegalForm companyLegalForm){
            this.companyLegalForm = companyLegalForm;
            return this;
        }
        public PartyLegalEntity build(){
            PartyLegalEntity partyLegalEntity = new PartyLegalEntity(this);
            return partyLegalEntity;
        }

    }

    public RegistrationName getRegistrationName() {
        return registrationName;
    }

    public CompanyID getCompanyID() {
        return companyID;
    }

    public RegistrationAddress getRegistrationAddress() {
        return registrationAddress;
    }

    public CorporateRegistrationScheme getCorporateRegistrationScheme() {
        return corporateRegistrationScheme;
    }
    public CompanyLegalForm getcompanyLegalForm() {
        return companyLegalForm;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementPartyLegalEntity = new ElementT(doc, element, ElementsName.PARTY_LEGAL_ENTITY.label).load();
        if(!(registrationName == null)){
            if(!(registrationName.getPatternLanguage() == null)){
                Element elementRegistrationName = new RegistrationName.RegistrationNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPartyLegalEntity)
                        .value(registrationName.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(registrationName.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementRegistrationName = new RegistrationName.RegistrationNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPartyLegalEntity)
                        .value(registrationName.getValue())
                        .build().load();
            }
        }
        if(!(companyID == null)){
            if(!(companyID.getPatternScheme() == null)){
                Element elementCompanyId = new CompanyID.CompanyIDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPartyLegalEntity)
                        .value(companyID.getValue())
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID(companyID.getPatternScheme().getSchemeID())
                                .schemeName(companyID.getPatternScheme().getSchemeName())
                                .schemeAgencyID(companyID.getPatternScheme().getSchemeAgencyID())
                                .schemeAgencyName(companyID.getPatternScheme().getSchemeAgencyName())
                                .schemeVersionID(companyID.getPatternScheme().getSchemeVersionID())
                                .schemeDataURI(companyID.getPatternScheme().getSchemeDataURI())
                                .schemeURI(companyID.getPatternScheme().getSchemeURI())
                                .build())
                        .build().load();
            } else {
                Element elementCompanyId = new CompanyID.CompanyIDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPartyLegalEntity)
                        .value(companyID.getValue())
                        .build().load();
            }
        }
        if(!(registrationAddress == null)){
            Element elementRegistrationAddress = new RegistrationAddress.RegistrationAddressBuilder()
                    .documentLinked(doc)
                    .elementFather(elementPartyLegalEntity)
                    .id(registrationAddress.getId())
                    .addressFormatCode(registrationAddress.getAddressFormatCode())
                    .postBox(registrationAddress.getPostbox())
                    .streetName(registrationAddress.getStreetName())
                    .buildingNumber(registrationAddress.getBuildingNumber())
                    .cityName(registrationAddress.getCityName())
                    .postalZone(registrationAddress.getPostalZone())
                    .build().load();
        }
        if(!(corporateRegistrationScheme == null)){
            Element CorporateRegistrationScheme = new CorporateRegistrationScheme.CorporateRegistrationSchemeBuilder()
                    .documentLinked(doc)
                    .elementFather(elementPartyLegalEntity)
                    .id(corporateRegistrationScheme.getId())
                    .build().load();
        }
        
        if(!(companyLegalForm == null)){
            Element CompanyLegalForm = new CompanyLegalForm.CompanyLegalFormBuilder()
                    .documentLinked(doc)
                    .elementFather(elementPartyLegalEntity)
                    .value(companyLegalForm.getValue())
                    .build().load();
        }
        return elementPartyLegalEntity;
    }

}
