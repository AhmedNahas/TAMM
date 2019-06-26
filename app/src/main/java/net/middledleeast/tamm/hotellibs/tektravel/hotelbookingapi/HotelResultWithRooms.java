
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Hotel_ResultWithRooms complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Hotel_ResultWithRooms"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ResultIndex" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="HotelInfo" type="{http://TekTravel/HotelBookingApi}HotelInfo" minOccurs="0"/&gt;
 *         &lt;element name="MinHotelPrice" type="{http://TekTravel/HotelBookingApi}MinHotelPrice" minOccurs="0"/&gt;
 *         &lt;element name="HotelRooms" type="{http://TekTravel/HotelBookingApi}ArrayOfHotel_Room" minOccurs="0"/&gt;
 *         &lt;element name="OptionsForBooking" type="{http://TekTravel/HotelBookingApi}BookingOptions" minOccurs="0"/&gt;
 *         &lt;element name="MoreRoomsAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="IsPkgProperty" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="IsPackageRate" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Hotel_ResultWithRooms", propOrder = {
    "resultIndex",
    "hotelInfo",
    "minHotelPrice",
    "hotelRooms",
    "optionsForBooking",
    "moreRoomsAvailable",
    "isPkgProperty",
    "isPackageRate"
})
public class HotelResultWithRooms {

    @XmlElement(name = "ResultIndex")
    protected int resultIndex;
    @XmlElement(name = "HotelInfo")
    protected HotelInfo hotelInfo;
    @XmlElement(name = "MinHotelPrice")
    protected MinHotelPrice minHotelPrice;
    @XmlElement(name = "HotelRooms")
    protected ArrayOfHotelRoom hotelRooms;
    @XmlElement(name = "OptionsForBooking")
    protected BookingOptions optionsForBooking;
    @XmlElement(name = "MoreRoomsAvailable")
    protected boolean moreRoomsAvailable;
    @XmlElement(name = "IsPkgProperty")
    protected boolean isPkgProperty;
    @XmlElement(name = "IsPackageRate")
    protected boolean isPackageRate;

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
     * Gets the value of the hotelRooms property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfHotelRoom }
     *     
     */
    public ArrayOfHotelRoom getHotelRooms() {
        return hotelRooms;
    }

    /**
     * Sets the value of the hotelRooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfHotelRoom }
     *     
     */
    public void setHotelRooms(ArrayOfHotelRoom value) {
        this.hotelRooms = value;
    }

    /**
     * Gets the value of the optionsForBooking property.
     * 
     * @return
     *     possible object is
     *     {@link BookingOptions }
     *     
     */
    public BookingOptions getOptionsForBooking() {
        return optionsForBooking;
    }

    /**
     * Sets the value of the optionsForBooking property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookingOptions }
     *     
     */
    public void setOptionsForBooking(BookingOptions value) {
        this.optionsForBooking = value;
    }

    /**
     * Gets the value of the moreRoomsAvailable property.
     * 
     */
    public boolean isMoreRoomsAvailable() {
        return moreRoomsAvailable;
    }

    /**
     * Sets the value of the moreRoomsAvailable property.
     * 
     */
    public void setMoreRoomsAvailable(boolean value) {
        this.moreRoomsAvailable = value;
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

}
