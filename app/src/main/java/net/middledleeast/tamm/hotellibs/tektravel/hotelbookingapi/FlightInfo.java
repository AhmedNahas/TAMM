
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FlightInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FlightInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="ArrivingByFlight" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="flightName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="flightNumber" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Hour" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Minutes" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="remarks" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlightInfo")
public class FlightInfo {

    @XmlAttribute(name = "ArrivingByFlight", required = true)
    protected boolean arrivingByFlight;
    @XmlAttribute(name = "flightName")
    protected String flightName;
    @XmlAttribute(name = "flightNumber")
    protected String flightNumber;
    @XmlAttribute(name = "Hour")
    protected String hour;
    @XmlAttribute(name = "Minutes")
    protected String minutes;
    @XmlAttribute(name = "remarks")
    protected String remarks;

    /**
     * Gets the value of the arrivingByFlight property.
     * 
     */
    public boolean isArrivingByFlight() {
        return arrivingByFlight;
    }

    /**
     * Sets the value of the arrivingByFlight property.
     * 
     */
    public void setArrivingByFlight(boolean value) {
        this.arrivingByFlight = value;
    }

    /**
     * Gets the value of the flightName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightName() {
        return flightName;
    }

    /**
     * Sets the value of the flightName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightName(String value) {
        this.flightName = value;
    }

    /**
     * Gets the value of the flightNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Sets the value of the flightNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightNumber(String value) {
        this.flightNumber = value;
    }

    /**
     * Gets the value of the hour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHour() {
        return hour;
    }

    /**
     * Sets the value of the hour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHour(String value) {
        this.hour = value;
    }

    /**
     * Gets the value of the minutes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinutes() {
        return minutes;
    }

    /**
     * Sets the value of the minutes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinutes(String value) {
        this.minutes = value;
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
