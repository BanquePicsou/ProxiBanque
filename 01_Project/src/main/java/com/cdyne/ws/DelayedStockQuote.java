
package com.cdyne.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DelayedStockQuote", targetNamespace = "http://ws.cdyne.com/", wsdlLocation = "file:/C:/Users/inti0221/Desktop/a.xml")
public class DelayedStockQuote
    extends Service
{

    private final static URL DELAYEDSTOCKQUOTE_WSDL_LOCATION;
    private final static WebServiceException DELAYEDSTOCKQUOTE_EXCEPTION;
    private final static QName DELAYEDSTOCKQUOTE_QNAME = new QName("http://ws.cdyne.com/", "DelayedStockQuote");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/inti0221/Desktop/a.xml");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DELAYEDSTOCKQUOTE_WSDL_LOCATION = url;
        DELAYEDSTOCKQUOTE_EXCEPTION = e;
    }

    public DelayedStockQuote() {
        super(__getWsdlLocation(), DELAYEDSTOCKQUOTE_QNAME);
    }

    public DelayedStockQuote(WebServiceFeature... features) {
        super(__getWsdlLocation(), DELAYEDSTOCKQUOTE_QNAME, features);
    }

    public DelayedStockQuote(URL wsdlLocation) {
        super(wsdlLocation, DELAYEDSTOCKQUOTE_QNAME);
    }

    public DelayedStockQuote(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DELAYEDSTOCKQUOTE_QNAME, features);
    }

    public DelayedStockQuote(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DelayedStockQuote(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DelayedStockQuoteSoap
     */
    @WebEndpoint(name = "DelayedStockQuoteSoap")
    public DelayedStockQuoteSoap getDelayedStockQuoteSoap() {
        return super.getPort(new QName("http://ws.cdyne.com/", "DelayedStockQuoteSoap"), DelayedStockQuoteSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DelayedStockQuoteSoap
     */
    @WebEndpoint(name = "DelayedStockQuoteSoap")
    public DelayedStockQuoteSoap getDelayedStockQuoteSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.cdyne.com/", "DelayedStockQuoteSoap"), DelayedStockQuoteSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DELAYEDSTOCKQUOTE_EXCEPTION!= null) {
            throw DELAYEDSTOCKQUOTE_EXCEPTION;
        }
        return DELAYEDSTOCKQUOTE_WSDL_LOCATION;
    }

}
