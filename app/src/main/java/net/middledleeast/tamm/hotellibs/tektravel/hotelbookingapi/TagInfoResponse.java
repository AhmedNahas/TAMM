
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Status" type="{http://TekTravel/HotelBookingApi}ResponseStatus" minOccurs="0"/&gt;
 *         &lt;element name="TagInfos" type="{http://TekTravel/HotelBookingApi}ArrayOfTagInfos" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "status",
    "tagInfos"
})
@XmlRootElement(name = "TagInfoResponse")
public class TagInfoResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "TagInfos")
    protected ArrayOfTagInfos tagInfos;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseStatus }
     *     
     */
    public ResponseStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseStatus }
     *     
     */
    public void setStatus(ResponseStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the tagInfos property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTagInfos }
     *     
     */
    public ArrayOfTagInfos getTagInfos() {
        return tagInfos;
    }

    /**
     * Sets the value of the tagInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTagInfos }
     *     
     */
    public void setTagInfos(ArrayOfTagInfos value) {
        this.tagInfos = value;
    }

}
