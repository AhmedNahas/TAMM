
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CancelPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancelPolicy"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="RoomTypeName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="RoomIndex" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="FromDate" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ToDate" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ChargeType" use="required" type="{http://TekTravel/HotelBookingApi}CancellationChargeTypeForHotel" /&gt;
 *       &lt;attribute name="CancellationCharge" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="PrefCurrency" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="PrefCancellationCharge" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelPolicy")
public class CancelPolicy {

    @XmlAttribute(name = "RoomTypeName")
    protected String roomTypeName;
    @XmlAttribute(name = "RoomIndex")
    protected String roomIndex;
    @XmlAttribute(name = "FromDate")
    protected String fromDate;
    @XmlAttribute(name = "ToDate")
    protected String toDate;
    @XmlAttribute(name = "ChargeType", required = true)
    protected CancellationChargeTypeForHotel chargeType;
    @XmlAttribute(name = "CancellationCharge", required = true)
    protected BigDecimal cancellationCharge;
    @XmlAttribute(name = "Currency")
    protected String currency;
    @XmlAttribute(name = "PrefCurrency")
    protected String prefCurrency;
    @XmlAttribute(name = "PrefCancellationCharge")
    protected String prefCancellationCharge;

    /**
     * Gets the value of the roomTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomTypeName() {
        return roomTypeName;
    }

    /**
     * Sets the value of the roomTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomTypeName(String value) {
        this.roomTypeName = value;
    }

    /**
     * Gets the value of the roomIndex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomIndex() {
        return roomIndex;
    }

    /**
     * Sets the value of the roomIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomIndex(String value) {
        this.roomIndex = value;
    }

    /**
     * Gets the value of the fromDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * Sets the value of the fromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromDate(String value) {
        this.fromDate = value;
    }

    /**
     * Gets the value of the toDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * Sets the value of the toDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToDate(String value) {
        this.toDate = value;
    }

    /**
     * Gets the value of the chargeType property.
     * 
     * @return
     *     possible object is
     *     {@link CancellationChargeTypeForHotel }
     *     
     */
    public CancellationChargeTypeForHotel getChargeType() {
        return chargeType;
    }

    /**
     * Sets the value of the chargeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancellationChargeTypeForHotel }
     *     
     */
    public void setChargeType(CancellationChargeTypeForHotel value) {
        this.chargeType = value;
    }

    /**
     * Gets the value of the cancellationCharge property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCancellationCharge() {
        return cancellationCharge;
    }

    /**
     * Sets the value of the cancellationCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCancellationCharge(BigDecimal value) {
        this.cancellationCharge = value;
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
     * Gets the value of the prefCancellationCharge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefCancellationCharge() {
        return prefCancellationCharge;
    }

    /**
     * Sets the value of the prefCancellationCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefCancellationCharge(String value) {
        this.prefCancellationCharge = value;
    }

}
