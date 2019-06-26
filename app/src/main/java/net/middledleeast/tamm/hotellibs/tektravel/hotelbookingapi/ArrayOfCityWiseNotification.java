
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCityWiseNotification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCityWiseNotification"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CityWiseNotification" type="{http://TekTravel/HotelBookingApi}CityWiseNotification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCityWiseNotification", propOrder = {
    "cityWiseNotification"
})
public class ArrayOfCityWiseNotification {

    @XmlElement(name = "CityWiseNotification", nillable = true)
    protected List<CityWiseNotification> cityWiseNotification;

    /**
     * Gets the value of the cityWiseNotification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cityWiseNotification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCityWiseNotification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CityWiseNotification }
     * 
     * 
     */
    public List<CityWiseNotification> getCityWiseNotification() {
        if (cityWiseNotification == null) {
            cityWiseNotification = new ArrayList<CityWiseNotification>();
        }
        return this.cityWiseNotification;
    }

}
