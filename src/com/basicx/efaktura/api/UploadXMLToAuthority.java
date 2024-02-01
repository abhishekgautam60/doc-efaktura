//
package com.basicx.efaktura.api;
//
///**
// *
// * @author Abhishek.Gautam
// */
//
//
//
import com.bas.basserver.executionengine.ExecutionException;
import com.bas.basserver.executionengine.IExecutionEngine;
import com.bas.basserver.executionengine.IProcess;
import com.bas.basserver.executionengine.SuspendProcessException;
import com.bas.connectionserver.server.AccessDeniedException;
import com.bas.shared.domain.operation.IEntity;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.entity.StringEntity;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.openadaptor.dataobjects.InvalidParameterException;
//
//
public class UploadXMLToAuthority implements IProcess
{    
    @Override
    public Object execute(IExecutionEngine iee, Object[] os) throws SuspendProcessException, ExecutionException, AccessDeniedException {
        
        IEntity invoice_entity = (IEntity) os [0];
        IEntity response_entity = (IEntity) os [1]; 
        IEntity system_settings_entity = (IEntity) os [2];
        IEntity tokenVault = (IEntity) os [3];
        String accessToken;
        String cifValue;
        String xmlBody;
        String apiEndpoint;
        String standardValue;
         
        SAXBuilder builder =new SAXBuilder();
        String readXmlFile;
        try { 
            readXmlFile = (String) invoice_entity.getAttributeValue("PDFInvoice_Path") + "\\"+  
                    (String) invoice_entity.getAttributeValue("SequenceNoTxt") +".xml";             
//            System.out.println(readXmlFile);
            File xmlFile =new File(readXmlFile);
            
            Document document=(Document) builder.build(xmlFile);          
            String xml=new XMLOutputter().outputString(document);            
//            apiEndpoint = "https://api.anaf.ro/test/FCTEL/rest/upload";     
            apiEndpoint = (String) system_settings_entity.getAttributeValue("apiEndpoint");
            standardValue = "UBL";
            cifValue = (String) invoice_entity.getAttributeValue("TC_CIF");            
            accessToken=(String) tokenVault.getAttributeValue("Token");
            xmlBody = xml;
            System.out.println("Uploading XML to anaf");
        try {            
//          Calling the api call method
            makeAPICall(apiEndpoint, accessToken,standardValue, cifValue, xmlBody);    
        } catch (Exception e) {
            e.printStackTrace();
        }                                   
        } catch (InvalidParameterException ex) {
            Logger.getLogger(UploadXMLToAuthority.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDOMException ex) {
            Logger.getLogger(UploadXMLToAuthority.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UploadXMLToAuthority.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("XML Uploaded sucessfully");
        return null;                         
    }

    @Override
    public Object resume(IExecutionEngine iee, Object o) throws SuspendProcessException, ExecutionException, AccessDeniedException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean cancel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    //  Here we are calling the API to upload our generated XML  
    public static void makeAPICall(String apiEndpoint, String accessToken ,String standardValue, String cifValue, String xmlBody) throws Exception {
       try {
            // Create an HttpClient
            HttpClient httpClient = HttpClients.createDefault();

            // Define the request (HttpPost in this case)
            HttpPost httpPost = new HttpPost(apiEndpoint + "?standard="+ standardValue + "&cif=" + cifValue);

            // Set the request body (JSON in this example)
            String jsonBody = xmlBody;
//             BasicHttpEntity entity = new BasicHttpEntity();
            StringEntity entity = new StringEntity(jsonBody);
            
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setHeader("Authorization", "Bearer " + accessToken);
            

            // Execute the request and get the response
            HttpResponse response = httpClient.execute(httpPost);

            // Get the response code
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("Response Code: " + statusCode);

            // Read the response content
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            StringBuilder responseContent = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                System.out.println(reader.toString());
                responseContent.append(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }   
}

