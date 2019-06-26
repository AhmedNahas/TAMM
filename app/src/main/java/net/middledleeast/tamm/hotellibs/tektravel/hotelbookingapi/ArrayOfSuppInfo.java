
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSuppInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSuppInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SuppInfo" type="{http://TekTravel/HotelBookingApi}SuppInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSuppInfo", propOrder = {
    "suppInfo"
})
public class ArrayOfSuppInfo {

    @XmlElement(name = "SuppInfo", nillable = true)
    protected List<SuppInfo> suppInfo;

    /**
     * Gets the value of the suppInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the suppInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSuppInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SuppInfo }
     * 
     * 
     */
    public List<SuppInfo> getSuppInfo() {
        if (suppInfo == null) {
            suppInfo = new ArrayList<SuppInfo>();
        }
        return this.suppInfo;
    }

}
