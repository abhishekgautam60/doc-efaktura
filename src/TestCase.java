
import java.io.File;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

//import org.w3c.dom.Document;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Abhishek.Gautam
 */
public class TestCase {
    
    public static String test()
    {
        SAXBuilder builder =new SAXBuilder();
        File xmlFile =new File("C:/UBL/UBLTestInvoice.xml");
        try{
            Document document=(Document) builder.build(xmlFile);          
            String xml=new XMLOutputter().outputString(document);
            return xml;                              
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "Error encounter";            
        }
    }    
    
    public static void main(String... args)
    {
        System.out.println("Program started...");
        String testing =test();
        System.out.println(testing);
    }
    
}
