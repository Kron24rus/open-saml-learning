package com.fireway.testproject.servlets;

import com.fireway.testproject.utils.SamlObject;
import com.fireway.testproject.utils.TestContext;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.opensaml.core.config.ConfigurationService;
import org.opensaml.core.config.InitializationService;
import org.opensaml.saml.common.SAMLObjectBuilder;
import org.opensaml.saml.saml2.core.AuthnRequest;
import org.opensaml.saml.saml2.core.impl.AuthnRequestBuilder;
import org.pac4j.core.context.J2EContext;
import org.pac4j.core.context.WebContext;
import org.pac4j.saml.client.SAML2Client;
import org.pac4j.saml.client.SAML2ClientConfiguration;
import org.pac4j.saml.util.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author Alexander Mikheev
 *         Date: 26.01.17
 */
@SlingServlet(paths = {"/bin/pac4jtest.html"})
public class LoginServlet extends SlingAllMethodsServlet {

    Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doGet(@Nonnull SlingHttpServletRequest request, @Nonnull SlingHttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(@Nonnull SlingHttpServletRequest request, @Nonnull SlingHttpServletResponse response) throws ServletException, IOException {
        try {
            InitializationService.initialize();
            AuthnRequest authnRequest = new AuthnRequestBuilder().buildObject();
            authnRequest.setID("123");
            LOGGER.error("DEMO::::, {}", authnRequest.getID());
            LOGGER.error("REQUEST:::::, {}", new SamlObject(authnRequest).toString());
            WebContext context1 = new J2EContext(request, response);

            LOGGER.error("-------------------------TEST CONTEXT-------------------");



            SAML2ClientConfiguration configuration = new SAML2ClientConfiguration();
            SAML2Client client = new SAML2Client(configuration);
            LOGGER.error("_________________________TEST CLIENT____________________");
        } catch (Exception e) {
            LOGGER.error("WTF", e);
        }
    }
}
