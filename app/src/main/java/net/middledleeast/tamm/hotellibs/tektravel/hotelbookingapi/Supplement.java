
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Supplement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Supplement"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Type" use="required" type="{http://TekTravel/HotelBookingApi}SupplementType" /&gt;
 *       &lt;attribute name="SuppID" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="SuppName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SuppIsMandatory" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="SuppChargeType" use="required" type="{http://TekTravel/HotelBookingApi}SupmtChargeType" /&gt;
 *       &lt;attribute name="Price" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Supplement")
public class Supplement {

    @XmlAttribute(name = "Type", required = true)
    protected SupplementType type;
    @XmlAttribute(name = "SuppID", required = true)
    protected int suppID;
    @XmlAttribute(name = "SuppName")
    protected String suppName;
    @XmlAttribute(name = "SuppIsMandatory", required = true)
    protected boolean suppIsMandatory;
    @XmlAttribute(name = "SuppChargeType", required = true)
    protected SupmtChargeType suppChargeType;
    @XmlAttribute(name = "Price", required = true)
    protected BigDecimal price;
    @XmlAttribute(name = "CurrencyCode")
    protected String currencyCode;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link SupplementType }
     *     
     */
    public SupplementType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplementType }
     *     
     */
    public void setType(SupplementType value) {
        this.type = value;
    }

    /**
     * Gets the value of the suppID property.
     * 
     */
    public int getSuppID() {
        return suppID;
    }

    /**
     * Sets the value of the suppID property.
     * 
     */
    public void setSuppID(int value) {
        this.suppID = value;
    }

    /**
     * Gets the value of the suppName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuppName() {
        return suppName;
    }

    /**
     * Sets the value of the suppName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuppName(String value) {
        this.suppName = value;
    }

    /**
     * Gets the value of the suppIsMandatory property.
     * 
     */
    public boolean isSuppIsMandatory() {
        return suppIsMandatory;
    }

    /**
     * Sets the value of the suppIsMandatory property.
     * 
     */
    public void setSuppIsMandatory(boolean value) {
        this.suppIsMandatory = value;
    }

    /**
     * Gets the value of the suppChargeType property.
     * 
     * @return
     *     possible object is
     *     {@link SupmtChargeType }
     *     
     */
    public SupmtChargeType getSuppChargeType() {
        return suppChargeType;
    }

    /**
     * Sets the value of the suppChargeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupmtChargeType }
     *     
     */
    public void setSuppChargeType(SupmtChargeType value) {
        this.suppChargeType = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

}
