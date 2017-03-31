
package com.cdyne.ws;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cdyne.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Decimal_QNAME = new QName("http://ws.cdyne.com/", "decimal");
    private final static QName _QuoteData_QNAME = new QName("http://ws.cdyne.com/", "QuoteData");
    private final static QName _DataSet_QNAME = new QName("http://ws.cdyne.com/", "DataSet");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cdyne.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetQuoteDataSetResponse }
     * 
     */
    public GetQuoteDataSetResponse createGetQuoteDataSetResponse() {
        return new GetQuoteDataSetResponse();
    }

    /**
     * Create an instance of {@link QuoteData }
     * 
     */
    public QuoteData createQuoteData() {
        return new QuoteData();
    }

    /**
     * Create an instance of {@link GetQuote }
     * 
     */
    public GetQuote createGetQuote() {
        return new GetQuote();
    }

    /**
     * Create an instance of {@link GetQuoteDataSet }
     * 
     */
    public GetQuoteDataSet createGetQuoteDataSet() {
        return new GetQuoteDataSet();
    }

    /**
     * Create an instance of {@link GetQuoteDataSetResponse.GetQuoteDataSetResult }
     * 
     */
    public GetQuoteDataSetResponse.GetQuoteDataSetResult createGetQuoteDataSetResponseGetQuoteDataSetResult() {
        return new GetQuoteDataSetResponse.GetQuoteDataSetResult();
    }

    /**
     * Create an instance of {@link DataSet }
     * 
     */
    public DataSet createDataSet() {
        return new DataSet();
    }

    /**
     * Create an instance of {@link GetQuoteResponse }
     * 
     */
    public GetQuoteResponse createGetQuoteResponse() {
        return new GetQuoteResponse();
    }

    /**
     * Create an instance of {@link GetQuickQuoteResponse }
     * 
     */
    public GetQuickQuoteResponse createGetQuickQuoteResponse() {
        return new GetQuickQuoteResponse();
    }

    /**
     * Create an instance of {@link GetQuickQuote }
     * 
     */
    public GetQuickQuote createGetQuickQuote() {
        return new GetQuickQuote();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.cdyne.com/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuoteData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.cdyne.com/", name = "QuoteData")
    public JAXBElement<QuoteData> createQuoteData(QuoteData value) {
        return new JAXBElement<QuoteData>(_QuoteData_QNAME, QuoteData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.cdyne.com/", name = "DataSet")
    public JAXBElement<DataSet> createDataSet(DataSet value) {
        return new JAXBElement<DataSet>(_DataSet_QNAME, DataSet.class, null, value);
    }

}
