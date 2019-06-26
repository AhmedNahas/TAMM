
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SuppInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SuppInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="SuppID" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="SuppChargeType" use="required" type="{http://TekTravel/HotelBookingApi}SuppChargeType" /&gt;
 *       &lt;attribute name="Price" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="SuppIsSelected" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SuppInfo")
public class SuppInfo {

    @XmlAttribute(name = "SuppID", required = true)
    protected int suppID;
    @XmlAttribute(name = "SuppChargeType", required = true)
    protected SuppChargeType suppChargeType;
    @XmlAttribute(name = "Price", required = true)
    protected BigDecimal price;
    @XmlAttribute(name = "SuppIsSelected", required = true)
    protected boolean suppIsSelected;

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
     * Gets the value of the suppChargeType property.
     * 
     * @return
     *     possible object is
     *     {@link SuppChargeType }
     *     
     */
    public SuppChargeType getSuppChargeType() {
        return suppChargeType;
    }

    /**
     * Sets the value of the suppChargeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SuppChargeType }
     *     
     */
    public void setSuppChargeType(SuppChargeType value) {
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
     * Gets the value of the suppIsSelected property.
     * 
     */
    public boolean isSuppIsSelected() {
        return suppIsSelected;
    }

    /**
     * Sets the value of the suppIsSelected property.
     * 
     */
    public void setSuppIsSelected(boolean value) {
        this.suppIsSelected = value;
    }

}
