/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicx.efaktura.api;

import com.bas.basserver.executionengine.ExecutionException;
import com.bas.basserver.executionengine.IExecutionEngine;
import com.bas.basserver.executionengine.IProcess;
import com.bas.basserver.executionengine.SuspendProcessException;
import com.bas.connectionserver.server.AccessDeniedException;
import com.bas.shared.domain.operation.IEntity;
import static com.basicx.efaktura.api.UploadXMLToAuthority.makeAPICall;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Abhishek.Gautam
 */
public class ValidateXml implements IProcess{

    @Override
    public Object execute(IExecutionEngine iee, Object[] os) throws SuspendProcessException, ExecutionException, AccessDeniedException {
        IEntity invoice_entity = (IEntity) os [0];
        IEntity response_entity = (IEntity) os [1]; 
        IEntity system_settings_entity = (IEntity) os [2];            
          
        SAXBuilder builder =new SAXBuilder();       
        String cifValue;
        String xmlBody;
        String apiEndpoint;
        String standardValue;
        String readXmlFile;
        try { 
            readXmlFile = (String) invoice_entity.getAttributeValue("PDFInvoice_Path") + "\\"+  
                    (String) invoice_entity.getAttributeValue("SequenceNoTxt") +".xml";
            File xmlFile =new File(readXmlFile);
            Document document=(Document) builder.build(xmlFile);          
            String xml=new XMLOutputter().outputString(document);            
            apiEndpoint = (String) system_settings_entity.getAttributeValue("validateApi");                        
            xmlBody = xml;
          StringBuilder content=  makeAPICall(apiEndpoint, xmlBody);  
          System.out.println(content);
        }
        catch(Exception ex){
                
        }
            
            
            
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

    private StringBuilder makeAPICall(String apiEndpoint, String xmlBody) {
         try {
            // Create an HttpClient
            HttpClient httpClient = HttpClients.createDefault();

            // Define the request (HttpPost in this case)
            HttpPost httpPost = new HttpPost(apiEndpoint);

            // Set the request body (JSON in this example)
            String jsonBody = xmlBody;
//             BasicHttpEntity entity = new BasicHttpEntity();
            StringEntity entity = new StringEntity(jsonBody);
            
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-type", "application/json");
//            httpPost.setHeader("Authorization", "Bearer " + accessToken);
            

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
            return responseContent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}
