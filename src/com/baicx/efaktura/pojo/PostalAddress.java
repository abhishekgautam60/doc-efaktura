/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baicx.efaktura.pojo;

/**
 *
 * @author Abhishek.Gautam
 */
class PostalAddress {
    private String StreetName;
    private String AdditionalStreetName;
    private String CityName;
    private String CountrySubentity;

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String StreetName) {
        this.StreetName = StreetName;
    }

    public String getAdditionalStreetName() {
        return AdditionalStreetName;
    }

    public void setAdditionalStreetName(String AdditionalStreetName) {
        this.AdditionalStreetName = AdditionalStreetName;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public String getCountrySubentity() {
        return CountrySubentity;
    }

    public void setCountrySubentity(String CountrySubentity) {
        this.CountrySubentity = CountrySubentity;
    }

    public PostalAddress(String StreetName, String AdditionalStreetName, String CityName, String CountrySubentity) {
        this.StreetName = StreetName;
        this.AdditionalStreetName = AdditionalStreetName;
        this.CityName = CityName;
        this.CountrySubentity = CountrySubentity;
    }
    
    
    
}
