
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Abhishek.Gautam
 */
public class Person {
    private String CustomizationID;
    private String party;
    // String-argument constructor

     public Person() {
    }

    public Person(String CustomizationID) {
        this.CustomizationID = CustomizationID;
    }
    

   
   
    public String getCustomizationID() {
        return CustomizationID;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public void setCustomizationID(String CustomizationID) {
        this.CustomizationID = CustomizationID;
    }

    @Override
    public String toString() {
        return "Person{" + "CustomizationID=" + CustomizationID + ", party=" + party + '}';
    }

   
    
}

