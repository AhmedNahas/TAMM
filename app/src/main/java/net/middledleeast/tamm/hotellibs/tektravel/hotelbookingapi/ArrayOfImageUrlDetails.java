
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfImageUrlDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfImageUrlDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ImageUrl" type="{http://TekTravel/HotelBookingApi}ImageUrlDetails" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfImageUrlDetails", propOrder = {
    "imageUrl"
})
public class ArrayOfImageUrlDetails {

    @XmlElement(name = "ImageUrl", nillable = true)
    protected List<ImageUrlDetails> imageUrl;

    /**
     * Gets the value of the imageUrl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the imageUrl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImageUrl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImageUrlDetails }
     * 
     * 
     */
    public List<ImageUrlDetails> getImageUrl() {
        if (imageUrl == null) {
            imageUrl = new ArrayList<ImageUrlDetails>();
        }
        return this.imageUrl;
    }

}
