
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
 *         &lt;element name="StockSymbols" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LicenseKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "stockSymbols",
    "licenseKey"
})
@XmlRootElement(name = "GetQuoteDataSet")
public class GetQuoteDataSet {

    @XmlElement(name = "StockSymbols")
    protected String stockSymbols;
    @XmlElement(name = "LicenseKey")
    protected String licenseKey;

    /**
     * Obtient la valeur de la propriété stockSymbols.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStockSymbols() {
        return stockSymbols;
    }

    /**
     * Définit la valeur de la propriété stockSymbols.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStockSymbols(String value) {
        this.stockSymbols = value;
    }

    /**
     * Obtient la valeur de la propriété licenseKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseKey() {
        return licenseKey;
    }

    /**
     * Définit la valeur de la propriété licenseKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseKey(String value) {
        this.licenseKey = value;
    }

}
