
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MinHotelPrice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MinHotelPrice"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="PrefPrice" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="PrefCurrency" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="TotalPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="B2CRates" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="OriginalPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MinHotelPrice")
public class MinHotelPrice {

    @XmlAttribute(name = "PrefPrice")
    protected String prefPrice;
    @XmlAttribute(name = "PrefCurrency")
    protected String prefCurrency;
    @XmlAttribute(name = "TotalPrice", required = true)
    protected BigDecimal totalPrice;
    @XmlAttribute(name = "Currency")
    protected String currency;
    @XmlAttribute(name = "B2CRates", required = true)
    protected boolean b2CRates;
    @XmlAttribute(name = "OriginalPrice", required = true)
    protected BigDecimal originalPrice;

    /**
     * Gets the value of the prefPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefPrice() {
        return prefPrice;
    }

    /**
     * Sets the value of the prefPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefPrice(String value) {
        this.prefPrice = value;
    }

    /**
     * Gets the value of the prefCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefCurrency() {
        return prefCurrency;
    }

    /**
     * Sets the value of the prefCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefCurrency(String value) {
        this.prefCurrency = value;
    }

    /**
     * Gets the value of the totalPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the value of the totalPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalPrice(BigDecimal value) {
        this.totalPrice = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the b2CRates property.
     * 
     */
    public boolean isB2CRates() {
        return b2CRates;
    }

    /**
     * Sets the value of the b2CRates property.
     * 
     */
    public void setB2CRates(boolean value) {
        this.b2CRates = value;
    }

    /**
     * Gets the value of the originalPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    /**
     * Sets the value of the originalPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOriginalPrice(BigDecimal value) {
        this.originalPrice = value;
    }

}
