
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfBookingsBasedOnDate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBookingsBasedOnDate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Booking" type="{http://TekTravel/HotelBookingApi}BookingsBasedOnDate" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBookingsBasedOnDate", propOrder = {
    "booking"
})
public class ArrayOfBookingsBasedOnDate {

    @XmlElement(name = "Booking", nillable = true)
    protected List<BookingsBasedOnDate> booking;

    /**
     * Gets the value of the booking property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the booking property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBooking().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BookingsBasedOnDate }
     * 
     * 
     */
    public List<BookingsBasedOnDate> getBooking() {
        if (booking == null) {
            booking = new ArrayList<BookingsBasedOnDate>();
        }
        return this.booking;
    }

}
