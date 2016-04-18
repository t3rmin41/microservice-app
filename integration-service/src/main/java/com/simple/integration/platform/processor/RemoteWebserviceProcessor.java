package com.simple.integration.platform.processor;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("webserviceProcessor")
public class RemoteWebserviceProcessor implements Processor {

    private static Logger log = LoggerFactory.getLogger(RemoteWebserviceProcessor.class);
    
    private static final String remoteURL = "http://localhost:8886/ws/cars.wsdl";
    
    @Override
    public void process(Exchange exchange) throws Exception {
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), remoteURL);
        
        log.info(soapResponse.getSOAPBody().getTextContent());
        
        soapConnection.close();
    }

    private SOAPMessage createSOAPRequest() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://entity.soap.simple.com/car";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("car", serverURI);

        //Constructed SOAP Request Message:
        /*
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:car="http://entity.soap.simple.com/car">
        <soapenv:Header/>
            <soapenv:Body>
                <car:getCarRequest>
                    <car:id>2</car:id>
                </coun:getCarRequest>
            </soapenv:Body>
        </soapenv:Envelope>
         */

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("getCarRequest", "car");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("id", "car");
        soapBodyElem1.addTextNode("2");

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "getCarRequest");

        soapMessage.saveChanges();

        return soapMessage;
    }
}
