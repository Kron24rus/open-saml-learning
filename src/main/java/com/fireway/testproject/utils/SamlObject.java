package com.fireway.testproject.utils;

import net.shibboleth.utilities.java.support.xml.SerializeSupport;
import org.opensaml.core.xml.io.Marshaller;
import org.opensaml.core.xml.io.MarshallerFactory;
import org.opensaml.core.xml.io.MarshallingException;
import org.opensaml.saml.common.SignableSAMLObject;
import org.opensaml.saml.saml2.core.impl.AuthnRequestImpl;
import org.pac4j.saml.util.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import java.io.StringWriter;

/**
 * @author Alexander Mikheev
 *         Date: 13.02.17
 */
public class SamlObject {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    SignableSAMLObject obj;

    public SamlObject(SignableSAMLObject obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        LOGGER.debug("SAMLObject - toString()");
        Element rspDOM = null;
        String messageXML = "";
        try {
            rspDOM = this.marshallRequestToXML();
        } catch (final MarshallingException e) {
            LOGGER.error(e.getLocalizedMessage(), e);
        }
        if (rspDOM != null) {
            messageXML = SerializeSupport.nodeToString(rspDOM);
        }

        return messageXML;
    }

    public Element marshallRequestToXML() throws MarshallingException {
        LOGGER.debug("SAMLObject - marshallRequestToXML()");

        // Convert the authnRequest to an XML Element
        MarshallerFactory factory = Configuration.getMarshallerFactory();
        Marshaller marshaller = factory.getMarshaller(this.obj);
        return marshaller.marshall(obj);
    }

}
