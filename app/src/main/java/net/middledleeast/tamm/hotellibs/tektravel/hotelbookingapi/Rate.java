
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Rate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Rate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="RoomFare" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="RoomTax" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="TotalFare" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rate")
public class Rate {

    @XmlAttribute(name = "RoomFare", required = true)
    protected BigDecimal roomFare;
    @XmlAttribute(name = "RoomTax", required = true)
    protected BigDecimal roomTax;
    @XmlAttribute(name = "TotalFare", required = true)
    protected BigDecimal totalFare;

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

}
