
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoomRate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoomRate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DayRates" type="{http://TekTravel/HotelBookingApi}ArrayOfDayRate" minOccurs="0"/&gt;
 *         &lt;element name="ExtraGuestCharges" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="ChildCharges" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="Discount" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="OtherCharges" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="ServiceTax" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="IsPackageRate" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="B2CRates" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="AgentMarkUp" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="RoomFare" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="RoomTax" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="PrefPrice" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="HeadGSAMarkUp" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="TotalFare" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="PrefCurrency" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomRate", propOrder = {
    "dayRates",
    "extraGuestCharges",
    "childCharges",
    "discount",
    "otherCharges",
    "serviceTax"
})
public class RoomRate {

    @XmlElement(name = "DayRates")
    protected ArrayOfDayRate dayRates;
    @XmlElement(name = "ExtraGuestCharges", required = true)
    protected BigDecimal extraGuestCharges;
    @XmlElement(name = "ChildCharges", required = true)
    protected BigDecimal childCharges;
    @XmlElement(name = "Discount", required = true)
    protected BigDecimal discount;
    @XmlElement(name = "OtherCharges", required = true)
    protected BigDecimal otherCharges;
    @XmlElement(name = "ServiceTax", required = true)
    protected BigDecimal serviceTax;
    @XmlAttribute(name = "IsPackageRate", required = true)
    protected boolean isPackageRate;
    @XmlAttribute(name = "B2CRates", required = true)
    protected boolean b2CRates;
    @XmlAttribute(name = "AgentMarkUp", required = true)
    protected BigDecimal agentMarkUp;
    @XmlAttribute(name = "Currency")
    protected String currency;
    @XmlAttribute(name = "RoomFare", required = true)
    protected BigDecimal roomFare;
    @XmlAttribute(name = "RoomTax", required = true)
    protected BigDecimal roomTax;
    @XmlAttribute(name = "PrefPrice")
    protected String prefPrice;
    @XmlAttribute(name = "HeadGSAMarkUp")
    protected String headGSAMarkUp;
    @XmlAttribute(name = "TotalFare", required = true)
    protected BigDecimal totalFare;
    @XmlAttribute(name = "PrefCurrency")
    protected String prefCurrency;

    /**
     * Gets the value of the dayRates property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDayRate }
     *     
     */
    public ArrayOfDayRate getDayRates() {
        return dayRates;
    }

    /**
     * Sets the value of the dayRates property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDayRate }
     *     
     */
    public void setDayRates(ArrayOfDayRate value) {
        this.dayRates = value;
    }

    /**
     * Gets the value of the extraGuestCharges property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getExtraGuestCharges() {
        return extraGuestCharges;
    }

    /**
     * Sets the value of the extraGuestCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setExtraGuestCharges(BigDecimal value) {
        this.extraGuestCharges = value;
    }

    /**
     * Gets the value of the childCharges property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getChildCharges() {
        return childCharges;
    }

    /**
     * Sets the value of the childCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setChildCharges(BigDecimal value) {
        this.childCharges = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDiscount(BigDecimal value) {
        this.discount = value;
    }

    /**
     * Gets the value of the otherCharges property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOtherCharges() {
        return otherCharges;
    }

    /**
     * Sets the value of the otherCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOtherCharges(BigDecimal value) {
        this.otherCharges = value;
    }

    /**
     * Gets the value of the serviceTax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getServiceTax() {
        return serviceTax;
    }

    /**
     * Sets the value of the serviceTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setServiceTax(BigDecimal value) {
        this.serviceTax = value;
    }

    /**
     * Gets the value of the isPackageRate property.
     * 
     */
    public boolean isIsPackageRate() {
        return isPackageRate;
    }

    /**
     * Sets the value of the isPackageRate property.
     * 
     */
    public void setIsPackageRate(boolean value) {
        this.isPackageRate = value;
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
     * Gets the value of the agentMarkUp property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAgentMarkUp() {
        return agentMarkUp;
    }

    /**
     * Sets the value of the agentMarkUp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAgentMarkUp(BigDecimal value) {
        this.agentMarkUp = value;
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
     * Gets the value of the roomFare property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRoomFare() {
        return roomFare;
    }

    /**
     * Sets the value of the roomFare property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRoomFare(BigDecimal value) {
        this.roomFare = value;
    }

    /**
     * Gets the value of the roomTax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRoomTax() {
        return roomTax;
    }

    /**
     * Sets the value of the roomTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRoomTax(BigDecimal value) {
        this.roomTax = value;
    }

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
     * Gets the value of the headGSAMarkUp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeadGSAMarkUp() {
        return headGSAMarkUp;
    }

    /**
     * Sets the value of the headGSAMarkUp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeadGSAMarkUp(String value) {
        this.headGSAMarkUp = value;
    }

    /**
     * Gets the value of the totalFare property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalFare() {
        return totalFare;
    }

    /**
     * Sets the value of the totalFare property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalFare(BigDecimal value) {
        this.totalFare = value;
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

}
