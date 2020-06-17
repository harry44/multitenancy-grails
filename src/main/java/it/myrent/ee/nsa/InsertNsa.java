/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.myrent.ee.nsa;

import it.myrent.ee.db.MROldSetting;
import java.io.ByteArrayOutputStream;
import javax.xml.soap.*;
import org.hibernate.Session;

/**
 * Created by Shivangani on 10/6/2017.
 */
public class InsertNsa {
    public final static String TEST = "http://172.20.242.38:8080/Myrentnsa.asmx";
    public final static String PRODUCTION = "http://MINGRFWS01:8080/MyRentNSA.asmx";
    

    public static String processRequest(Session sx, String nominativo, String cognome, String nome , String partitaIva, String codFiscale, String dtNas
                                ,String nazNas, String provNas,String cittaNas, String sesso,String nazioneEst
                                ,String cittaEst,String telefono, String cellulare,String email, String dtPrivacy,String tipoPrivacy
                                ,String provincia ,String localita,String cap, String frazione, String indirizzo, String tipoCliente , String tipoPersona ) {

        SOAPMessage soapResponse=null;
        String response= null;
        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            //TEST
            String url = "";
            MROldSetting setting = (MROldSetting) sx.get(MROldSetting.class, "isSiaTest");
            if (setting !=null && setting.getValue().equals("true")){
                url = TEST;
            }                            
            else{
                url = PRODUCTION;                        
            }
//            if(sx != null && sx.isOpen()){
//                sx.close();
//            }
            soapResponse = soapConnection.call(createSOAPRequest(nominativo,cognome,nome,partitaIva,codFiscale,dtNas,
                        nazNas,provNas,cittaNas,sesso,nazioneEst,cittaEst,telefono,cellulare,email,dtPrivacy,
                        tipoPrivacy,provincia,localita,cap,frazione,indirizzo,tipoCliente,tipoPersona), url);

//            System.out.print("Response INSERT SOAP Message:");
//            soapResponse.writeTo(System.out);
            soapConnection.close();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            soapResponse.writeTo(out);
            response = new String(out.toByteArray());
            return response;
        } catch (Exception ex) {
            ex.getLocalizedMessage();
               return response;
        }


    }
     public static SOAPMessage createSOAPRequest(String nominativo, String cognome, String nome , String partitaIva, String codFiscale, String dtNas
                                ,String nazNas, String provNas,String cittaNas, String sesso,String nazioneEst
                                ,String cittaEst,String telefono, String cellulare,String email, String dtPrivacy,String tipoPrivacy
                                ,String provincia ,String localita,String cap, String frazione, String indirizzo,String tipoCliente , String tipoPersona) throws Exception {
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();

            
             String serverURI = "http://www.w3.org/2001/XMLSchema";
             String serverURI2 = "http://www.w3.org/2001/XMLSchema-instance";
             String inserimentoNsaURI = "http://myrentnsa.europassistance.it/";
             

            // SOAP Envelope
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.setPrefix("soap");
            envelope.removeNamespaceDeclaration("SOAP-ENV");
            
            //remove empty header
            soapMessage.getSOAPHeader().detachNode();
            
            soapMessage.getSOAPBody().setPrefix("soap");
            
            envelope.addNamespaceDeclaration("xsi", serverURI2);
            envelope.addNamespaceDeclaration("xsd", serverURI);
            
            
            

            // SOAP Body
            SOAPBody soapBody = envelope.getBody();
            SOAPElement soapBodyElem = soapBody.addChildElement("InserimentoNsa", "", inserimentoNsaURI);
            SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("insertNSA", "");

            SOAPElement soapBodyElem2 = soapBodyElem1.addChildElement("in_nominativo", "");
            if(nominativo != null){
                 soapBodyElem2.addTextNode(nominativo);
            }else{
                 soapBodyElem2.addTextNode("");
            }
            SOAPElement soapBodyElem3 = soapBodyElem1.addChildElement("in_cognome", "");
            if(cognome != null){
                soapBodyElem3.addTextNode(cognome);
            }else{
                soapBodyElem3.addTextNode("");
            }
            SOAPElement soapBodyElem4 = soapBodyElem1.addChildElement("in_nome", "");
            if(nome != null){
                soapBodyElem4.addTextNode(nome);
            }else {
                soapBodyElem4.addTextNode("");
            }
            SOAPElement soapBodyElem5 = soapBodyElem1.addChildElement("in_partita_iva", "");
            if(partitaIva != null){
                 soapBodyElem5.addTextNode(partitaIva);
            }else{
                 soapBodyElem5.addTextNode("");
            }
            SOAPElement soapBodyElem6 = soapBodyElem1.addChildElement("in_cod_fiscale", "");
            if(codFiscale != null){
                 soapBodyElem6.addTextNode(codFiscale);
            }else{
                soapBodyElem6.addTextNode("");
            }
            SOAPElement soapBodyElem7 = soapBodyElem1.addChildElement("in_dt_nas", "");
            if(dtNas != null){
                 soapBodyElem7.addTextNode(dtNas);
            }else{
                soapBodyElem7.addTextNode("");
            }
            SOAPElement soapBodyElem8 = soapBodyElem1.addChildElement("in_naz_nas", "");
            if(nazNas != null){
                 soapBodyElem8.addTextNode(nazNas);
            }else{
                soapBodyElem8.addTextNode("");
            }
            SOAPElement soapBodyElem9 = soapBodyElem1.addChildElement("in_prov_nas", "");
            if(provNas != null){
                 soapBodyElem9.addTextNode(provNas);
            }else{
                soapBodyElem9.addTextNode("");
            }
            SOAPElement soapBodyElem10 = soapBodyElem1.addChildElement("in_citta_nas", "");
            if(cittaNas != null){
                soapBodyElem10.addTextNode(cittaNas);
            }else{
                soapBodyElem10.addTextNode("");
            }
            
            //int
            SOAPElement soapBodyElem11 = soapBodyElem1.addChildElement("in_sesso", "");
//            if(sesso != null){
                soapBodyElem11.addTextNode(String.valueOf(sesso));
//            }else{
//                soapBodyElem11.addTextNode("");
//            }
            SOAPElement soapBodyElem12 = soapBodyElem1.addChildElement("in_nazione_est", "");
            if(nazioneEst != null){
                soapBodyElem12.addTextNode(nazioneEst);
            }else{
                soapBodyElem12.addTextNode("");
            }
            SOAPElement soapBodyElem13 = soapBodyElem1.addChildElement("in_citta_est", "");
            if(cittaEst != null){
                soapBodyElem13.addTextNode(cittaEst);
            }else{
                soapBodyElem13.addTextNode("");
            }
            SOAPElement soapBodyElem14 = soapBodyElem1.addChildElement("in_telefono", "");
            if(telefono != null){
                soapBodyElem14.addTextNode(telefono);
            }else{
                soapBodyElem14.addTextNode("");
            }
            SOAPElement soapBodyElem15 = soapBodyElem1.addChildElement("in_cellulare", "");
            if(cellulare != null){
                soapBodyElem15.addTextNode(cellulare);
            }else{
                soapBodyElem15.addTextNode("");
            }
            SOAPElement soapBodyElem16 = soapBodyElem1.addChildElement("in_email", "");
            if(email != null){
                soapBodyElem16.addTextNode(email);
            }else{
                soapBodyElem16.addTextNode("");
            }
            SOAPElement soapBodyElem17 = soapBodyElem1.addChildElement("in_dt_privacy", "");
            if(dtPrivacy != null){
                soapBodyElem17.addTextNode(dtPrivacy);
            }else{
                soapBodyElem17.addTextNode("");
            }
            //int
            SOAPElement soapBodyElem18 = soapBodyElem1.addChildElement("in_tipo_privacy", "");
            if(tipoPrivacy != null){
                soapBodyElem18.addTextNode(tipoPrivacy);
            }else{
                soapBodyElem18.addTextNode("");
            }
            SOAPElement soapBodyElem19 = soapBodyElem1.addChildElement("in_provincia", "");
            if(provincia != null){
                soapBodyElem19.addTextNode(provincia);
            }else{
                soapBodyElem19.addTextNode("");
            }
            SOAPElement soapBodyElem20 = soapBodyElem1.addChildElement("in_localita", "");
            if(localita != null){
                soapBodyElem20.addTextNode(localita);
            }else{
                soapBodyElem20.addTextNode("");
            }
            SOAPElement soapBodyElem21 = soapBodyElem1.addChildElement("in_cap", "");
            if(cap != null){
                soapBodyElem21.addTextNode(cap);
            }else{
                soapBodyElem21.addTextNode("");
            }
            SOAPElement soapBodyElem22 = soapBodyElem1.addChildElement("in_frazione", "");
            if(frazione != null){
                soapBodyElem22.addTextNode(frazione);
            }else{
                soapBodyElem22.addTextNode("");
            }
            SOAPElement soapBodyElem23 = soapBodyElem1.addChildElement("in_indirizzo", "");
            if(indirizzo != null){
                soapBodyElem23.addTextNode(indirizzo);
            }else{
                soapBodyElem23.addTextNode("");
            }
            //int 1 = Consumer 2 = 
            SOAPElement soapBodyElem24 = soapBodyElem1.addChildElement("in_tipo_cliente", "");
            if(tipoCliente != null){
                soapBodyElem24.addTextNode(tipoCliente);
            }else{
                soapBodyElem24.addTextNode("");
            }
            //int 1 = physical person  2 = company
            SOAPElement soapBodyElem25 = soapBodyElem1.addChildElement("in_tipo_persona", "");
            if(tipoPersona != null){
                soapBodyElem25.addTextNode(tipoPersona);
            }else{
                soapBodyElem25.addTextNode("");
            }

            MimeHeaders headers = soapMessage.getMimeHeaders();
            headers.addHeader("SOAPAction", inserimentoNsaURI  + "InserimentoNsa");

            soapMessage.saveChanges();

            /* Print the request message */
//            System.out.print("\nRequest INSERT SOAP Message:");
//            soapMessage.writeTo(System.out);
//            System.out.println();

            return soapMessage;
        }

}


