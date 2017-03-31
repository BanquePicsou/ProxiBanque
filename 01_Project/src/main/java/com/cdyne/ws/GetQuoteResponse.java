
package com.cdyne.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetQuoteResult" type="{http://ws.cdyne.com/}QuoteData"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getQuoteResult"
})
@XmlRootElement(name = "GetQuoteResponse")
public class GetQuoteResponse {

    @XmlElement(name = "GetQuoteResult", required = true)
    protected QuoteData getQuoteResult;

    /**
     * Obtient la valeur de la propriété getQuoteResult.
     * 
     * @return
     *     possible object is
     *     {@link QuoteData }
     *     
     */
    public QuoteData getGetQuoteResult() {
        return getQuoteResult;
    }

    /**
     * Définit la valeur de la propriété getQuoteResult.
     * 
     * @param value
     *     allowed object is
     *     {@link QuoteData }
     *     
     */
    public void setGetQuoteResult(QuoteData value) {
        this.getQuoteResult = value;
    }

}
