
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CheckOutRes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckOutRes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Date" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="DateAction" use="required" type="{http://TekTravel/HotelBookingApi}DateActionRes" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckOutRes")
public class CheckOutRes {

    @XmlAttribute(name = "Date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlAttribute(name = "DateAction", required = true)
    protected DateActionRes dateAction;

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the dateAction property.
     * 
     * @return
     *     possible object is
     *     {@link DateActionRes }
     *     
     */
    public DateActionRes getDateAction() {
        return dateAction;
    }

    /**
     * Sets the value of the dateAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateActionRes }
     *     
     */
    public void setDateAction(DateActionRes value) {
        this.dateAction = value;
    }

}
