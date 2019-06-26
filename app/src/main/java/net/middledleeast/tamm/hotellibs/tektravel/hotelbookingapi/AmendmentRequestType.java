
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AmendmentRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AmendmentRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Type" use="required" type="{http://TekTravel/HotelBookingApi}AmendmentType" /&gt;
 *       &lt;attribute name="PriceChange" use="required" type="{http://TekTravel/HotelBookingApi}PriceChange" /&gt;
 *       &lt;attribute name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmendmentRequestType")
public class AmendmentRequestType {

    @XmlAttribute(name = "Type", required = true)
    protected AmendmentType type;
    @XmlAttribute(name = "PriceChange", required = true)
    protected PriceChange priceChange;
    @XmlAttribute(name = "Remarks")
    protected String remarks;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link AmendmentType }
     *     
     */
    public AmendmentType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmendmentType }
     *     
     */
    public void setType(AmendmentType value) {
        this.type = value;
    }

    /**
     * Gets the value of the priceChange property.
     * 
     * @return
     *     possible object is
     *     {@link PriceChange }
     *     
     */
    public PriceChange getPriceChange() {
        return priceChange;
    }

    /**
     * Sets the value of the priceChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceChange }
     *     
     */
    public void setPriceChange(PriceChange value) {
        this.priceChange = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Sets the value of the remarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

}
