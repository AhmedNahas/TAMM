
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
 *         &lt;element name="ResultIndex" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="AvailableForBook" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="AvailableForConfirmBook" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="CancellationPoliciesAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="HotelCancellationPolicies" type="{http://TekTravel/HotelBookingApi}HotelCancellationPolicies" minOccurs="0"/&gt;
 *         &lt;element name="PriceVerification" type="{http://TekTravel/HotelBookingApi}PriceVerification" minOccurs="0"/&gt;
 *         &lt;element name="AccountInfo" type="{http://TekTravel/HotelBookingApi}AccountInfo" minOccurs="0"/&gt;
 *         &lt;element name="HotelDetailsVerification" type="{http://TekTravel/HotelBookingApi}HotelDetailsVerification" minOccurs="0"/&gt;
 *         &lt;element name="HotelDetails" type="{http://TekTravel/HotelBookingApi}APIHotelDetails" minOccurs="0"/&gt;
 *         &lt;element name="IsFlightDetailsMandatory" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "resultIndex",
    "availableForBook",
    "availableForConfirmBook",
    "cancellationPoliciesAvailable",
    "hotelCancellationPolicies",
    "priceVerification",
    "accountInfo",
    "hotelDetailsVerification",
    "hotelDetails",
    "isFlightDetailsMandatory"
})
@XmlRootElement(name = "AvailabilityAndPricingResponse")
public class AvailabilityAndPricingResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "ResultIndex")
    protected int resultIndex;
    @XmlElement(name = "AvailableForBook")
    protected boolean availableForBook;
    @XmlElement(name = "AvailableForConfirmBook")
    protected boolean availableForConfirmBook;
    @XmlElement(name = "CancellationPoliciesAvailable")
    protected boolean cancellationPoliciesAvailable;
    @XmlElement(name = "HotelCancellationPolicies")
    protected HotelCancellationPolicies hotelCancellationPolicies;
    @XmlElement(name = "PriceVerification")
    protected PriceVerification priceVerification;
    @XmlElement(name = "AccountInfo")
    protected AccountInfo accountInfo;
    @XmlElement(name = "HotelDetailsVerification")
    protected HotelDetailsVerification hotelDetailsVerification;
    @XmlElement(name = "HotelDetails")
    protected APIHotelDetails hotelDetails;
    @XmlElement(name = "IsFlightDetailsMandatory")
    protected boolean isFlightDetailsMandatory;

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
     * Gets the value of the availableForBook property.
     * 
     */
    public boolean isAvailableForBook() {
        return availableForBook;
    }

    /**
     * Sets the value of the availableForBook property.
     * 
     */
    public void setAvailableForBook(boolean value) {
        this.availableForBook = value;
    }

    /**
     * Gets the value of the availableForConfirmBook property.
     * 
     */
    public boolean isAvailableForConfirmBook() {
        return availableForConfirmBook;
    }

    /**
     * Sets the value of the availableForConfirmBook property.
     * 
     */
    public void setAvailableForConfirmBook(boolean value) {
        this.availableForConfirmBook = value;
    }

    /**
     * Gets the value of the cancellationPoliciesAvailable property.
     * 
     */
    public boolean isCancellationPoliciesAvailable() {
        return cancellationPoliciesAvailable;
    }

    /**
     * Sets the value of the cancellationPoliciesAvailable property.
     * 
     */
    public void setCancellationPoliciesAvailable(boolean value) {
        this.cancellationPoliciesAvailable = value;
    }

    /**
     * Gets the value of the hotelCancellationPolicies property.
     * 
     * @return
     *     possible object is
     *     {@link HotelCancellationPolicies }
     *     
     */
    public HotelCancellationPolicies getHotelCancellationPolicies() {
        return hotelCancellationPolicies;
    }

    /**
     * Sets the value of the hotelCancellationPolicies property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelCancellationPolicies }
     *     
     */
    public void setHotelCancellationPolicies(HotelCancellationPolicies value) {
        this.hotelCancellationPolicies = value;
    }

    /**
     * Gets the value of the priceVerification property.
     * 
     * @return
     *     possible object is
     *     {@link PriceVerification }
     *     
     */
    public PriceVerification getPriceVerification() {
        return priceVerification;
    }

    /**
     * Sets the value of the priceVerification property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceVerification }
     *     
     */
    public void setPriceVerification(PriceVerification value) {
        this.priceVerification = value;
    }

    /**
     * Gets the value of the accountInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AccountInfo }
     *     
     */
    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    /**
     * Sets the value of the accountInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountInfo }
     *     
     */
    public void setAccountInfo(AccountInfo value) {
        this.accountInfo = value;
    }

    /**
     * Gets the value of the hotelDetailsVerification property.
     * 
     * @return
     *     possible object is
     *     {@link HotelDetailsVerification }
     *     
     */
    public HotelDetailsVerification getHotelDetailsVerification() {
        return hotelDetailsVerification;
    }

    /**
     * Sets the value of the hotelDetailsVerification property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelDetailsVerification }
     *     
     */
    public void setHotelDetailsVerification(HotelDetailsVerification value) {
        this.hotelDetailsVerification = value;
    }

    /**
     * Gets the value of the hotelDetails property.
     * 
     * @return
     *     possible object is
     *     {@link APIHotelDetails }
     *     
     */
    public APIHotelDetails getHotelDetails() {
        return hotelDetails;
    }

    /**
     * Sets the value of the hotelDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link APIHotelDetails }
     *     
     */
    public void setHotelDetails(APIHotelDetails value) {
        this.hotelDetails = value;
    }

    /**
     * Gets the value of the isFlightDetailsMandatory property.
     * 
     */
    public boolean isIsFlightDetailsMandatory() {
        return isFlightDetailsMandatory;
    }

    /**
     * Sets the value of the isFlightDetailsMandatory property.
     * 
     */
    public void setIsFlightDetailsMandatory(boolean value) {
        this.isFlightDetailsMandatory = value;
    }

}
