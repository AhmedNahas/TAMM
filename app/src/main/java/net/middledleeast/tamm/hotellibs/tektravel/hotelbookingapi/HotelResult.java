
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Hotel_Result complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Hotel_Result"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ResultIndex" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="HotelInfo" type="{http://TekTravel/HotelBookingApi}HotelInfo" minOccurs="0"/&gt;
 *         &lt;element name="MinHotelPrice" type="{http://TekTravel/HotelBookingApi}MinHotelPrice" minOccurs="0"/&gt;
 *         &lt;element name="IsPkgProperty" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="RoomDetails" type="{http://TekTravel/HotelBookingApi}ArrayOfRooms" minOccurs="0"/&gt;
 *         &lt;element name="IsPackageRate" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="MappedHotel" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Hotel_Result", propOrder = {
    "resultIndex",
    "hotelInfo",
    "minHotelPrice",
    "isPkgProperty",
    "roomDetails",
    "isPackageRate",
    "mappedHotel"
})
public class HotelResult {

    @XmlElement(name = "ResultIndex")
    protected int resultIndex;
    @XmlElement(name = "HotelInfo")
    protected HotelInfo hotelInfo;
    @XmlElement(name = "MinHotelPrice")
    protected MinHotelPrice minHotelPrice;
    @XmlElement(name = "IsPkgProperty")
    protected boolean isPkgProperty;
    @XmlElement(name = "RoomDetails")
    protected ArrayOfRooms roomDetails;
    @XmlElement(name = "IsPackageRate")
    protected boolean isPackageRate;
    @XmlElement(name = "MappedHotel")
    protected boolean mappedHotel;

    /**
     * Gets the value of the resultIndex property.
     * 
     */
    public int getResultIndex() {
        return resultIndex;
    }

    /**
     * Sets the value of the resultIndex property.
     * 
     */
    public void setResultIndex(int value) {
        this.resultIndex = value;
    }

    /**
     * Gets the value of the hotelInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HotelInfo }
     *     
     */
    public HotelInfo getHotelInfo() {
        return hotelInfo;
    }

    /**
     * Sets the value of the hotelInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelInfo }
     *     
     */
    public void setHotelInfo(HotelInfo value) {
        this.hotelInfo = value;
    }

    /**
     * Gets the value of the minHotelPrice property.
     * 
     * @return
     *     possible object is
     *     {@link MinHotelPrice }
     *     
     */
    public MinHotelPrice getMinHotelPrice() {
        return minHotelPrice;
    }

    /**
     * Sets the value of the minHotelPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MinHotelPrice }
     *     
     */
    public void setMinHotelPrice(MinHotelPrice value) {
        this.minHotelPrice = value;
    }

    /**
     * Gets the value of the isPkgProperty property.
     * 
     */
    public boolean isIsPkgProperty() {
        return isPkgProperty;
    }

    /**
     * Sets the value of the isPkgProperty property.
     * 
     */
    public void setIsPkgProperty(boolean value) {
        this.isPkgProperty = value;
    }

    /**
     * Gets the value of the roomDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRooms }
     *     
     */
    public ArrayOfRooms getRoomDetails() {
        return roomDetails;
    }

    /**
     * Sets the value of the roomDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRooms }
     *     
     */
    public void setRoomDetails(ArrayOfRooms value) {
        this.roomDetails = value;
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
     * Gets the value of the mappedHotel property.
     * 
     */
    public boolean isMappedHotel() {
        return mappedHotel;
    }

    /**
     * Sets the value of the mappedHotel property.
     * 
     */
    public void setMappedHotel(boolean value) {
        this.mappedHotel = value;
    }

}
