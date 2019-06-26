
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for APIBookingDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APIBookingDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Rating" type="{http://TekTravel/HotelBookingApi}HotelInfoHotelRating"/&gt;
 *         &lt;element name="AddressLine1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AddressLine2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Map" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CheckInDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="CheckOutDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="BookingDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="HotelCancelPolicies" type="{http://TekTravel/HotelBookingApi}CancelPolicies" minOccurs="0"/&gt;
 *         &lt;element name="HotelPolicyDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FlightInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SpecialRequest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Roomtype" type="{http://TekTravel/HotelBookingApi}ArrayOfRoomDetails" minOccurs="0"/&gt;
 *         &lt;element name="AmendmentDetails" type="{http://TekTravel/HotelBookingApi}AmendmentDetails" minOccurs="0"/&gt;
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NoOfRooms" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="AgencyDetails" type="{http://TekTravel/HotelBookingApi}AgencyDetails" minOccurs="0"/&gt;
 *         &lt;element name="AOTNumbers" type="{http://TekTravel/HotelBookingApi}AOTNumbers" minOccurs="0"/&gt;
 *         &lt;element name="CityId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="TripName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TBOHotelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentCancellationCharges" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="AppliedCancellationCharges" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="BookingId" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="AmendmentStatus" use="required" type="{http://TekTravel/HotelBookingApi}RequestStatus" /&gt;
 *       &lt;attribute name="BookingStatus" use="required" type="{http://TekTravel/HotelBookingApi}APIHotelBookingStatus" /&gt;
 *       &lt;attribute name="VoucherStatus" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="InvoiceNumber" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SupplierReferenceNo" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ConfirmationNo" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="HotelConfirmationNo" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APIBookingDetail", propOrder = {
    "hotelName",
    "rating",
    "addressLine1",
    "addressLine2",
    "map",
    "city",
    "checkInDate",
    "checkOutDate",
    "bookingDate",
    "hotelCancelPolicies",
    "hotelPolicyDetails",
    "flightInfo",
    "specialRequest",
    "roomtype",
    "amendmentDetails",
    "currency",
    "noOfRooms",
    "agencyDetails",
    "aotNumbers",
    "cityId",
    "tripName",
    "tboHotelCode",
    "currentCancellationCharges",
    "appliedCancellationCharges"
})
public class APIBookingDetail {

    @XmlElement(name = "HotelName")
    protected String hotelName;
    @XmlElement(name = "Rating", required = true)
    @XmlSchemaType(name = "string")
    protected HotelInfoHotelRating rating;
    @XmlElement(name = "AddressLine1")
    protected String addressLine1;
    @XmlElement(name = "AddressLine2")
    protected String addressLine2;
    @XmlElement(name = "Map")
    protected String map;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "CheckInDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar checkInDate;
    @XmlElement(name = "CheckOutDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar checkOutDate;
    @XmlElement(name = "BookingDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar bookingDate;
    @XmlElement(name = "HotelCancelPolicies")
    protected CancelPolicies hotelCancelPolicies;
    @XmlElement(name = "HotelPolicyDetails")
    protected String hotelPolicyDetails;
    @XmlElement(name = "FlightInfo")
    protected String flightInfo;
    @XmlElement(name = "SpecialRequest")
    protected String specialRequest;
    @XmlElement(name = "Roomtype")
    protected ArrayOfRoomDetails roomtype;
    @XmlElement(name = "AmendmentDetails")
    protected AmendmentDetails amendmentDetails;
    @XmlElement(name = "Currency")
    protected String currency;
    @XmlElement(name = "NoOfRooms")
    protected int noOfRooms;
    @XmlElement(name = "AgencyDetails")
    protected AgencyDetails agencyDetails;
    @XmlElement(name = "AOTNumbers")
    protected AOTNumbers aotNumbers;
    @XmlElement(name = "CityId")
    protected int cityId;
    @XmlElement(name = "TripName")
    protected String tripName;
    @XmlElement(name = "TBOHotelCode")
    protected String tboHotelCode;
    @XmlElement(name = "CurrentCancellationCharges")
    protected BigDecimal currentCancellationCharges;
    @XmlElement(name = "AppliedCancellationCharges")
    protected BigDecimal appliedCancellationCharges;
    @XmlAttribute(name = "BookingId", required = true)
    protected int bookingId;
    @XmlAttribute(name = "AmendmentStatus", required = true)
    protected RequestStatus amendmentStatus;
    @XmlAttribute(name = "BookingStatus", required = true)
    protected APIHotelBookingStatus bookingStatus;
    @XmlAttribute(name = "VoucherStatus", required = true)
    protected boolean voucherStatus;
    @XmlAttribute(name = "InvoiceNumber")
    protected String invoiceNumber;
    @XmlAttribute(name = "SupplierReferenceNo")
    protected String supplierReferenceNo;
    @XmlAttribute(name = "ConfirmationNo")
    protected String confirmationNo;
    @XmlAttribute(name = "HotelConfirmationNo")
    protected String hotelConfirmationNo;

    /**
     * Gets the value of the hotelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Sets the value of the hotelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelName(String value) {
        this.hotelName = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link HotelInfoHotelRating }
     *     
     */
    public HotelInfoHotelRating getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelInfoHotelRating }
     *     
     */
    public void setRating(HotelInfoHotelRating value) {
        this.rating = value;
    }

    /**
     * Gets the value of the addressLine1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Sets the value of the addressLine1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine1(String value) {
        this.addressLine1 = value;
    }

    /**
     * Gets the value of the addressLine2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Sets the value of the addressLine2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine2(String value) {
        this.addressLine2 = value;
    }

    /**
     * Gets the value of the map property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMap() {
        return map;
    }

    /**
     * Sets the value of the map property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMap(String value) {
        this.map = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the checkInDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckInDate() {
        return checkInDate;
    }

    /**
     * Sets the value of the checkInDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckInDate(XMLGregorianCalendar value) {
        this.checkInDate = value;
    }

    /**
     * Gets the value of the checkOutDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Sets the value of the checkOutDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckOutDate(XMLGregorianCalendar value) {
        this.checkOutDate = value;
    }

    /**
     * Gets the value of the bookingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBookingDate() {
        return bookingDate;
    }

    /**
     * Sets the value of the bookingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBookingDate(XMLGregorianCalendar value) {
        this.bookingDate = value;
    }

    /**
     * Gets the value of the hotelCancelPolicies property.
     * 
     * @return
     *     possible object is
     *     {@link CancelPolicies }
     *     
     */
    public CancelPolicies getHotelCancelPolicies() {
        return hotelCancelPolicies;
    }

    /**
     * Sets the value of the hotelCancelPolicies property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelPolicies }
     *     
     */
    public void setHotelCancelPolicies(CancelPolicies value) {
        this.hotelCancelPolicies = value;
    }

    /**
     * Gets the value of the hotelPolicyDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelPolicyDetails() {
        return hotelPolicyDetails;
    }

    /**
     * Sets the value of the hotelPolicyDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelPolicyDetails(String value) {
        this.hotelPolicyDetails = value;
    }

    /**
     * Gets the value of the flightInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightInfo() {
        return flightInfo;
    }

    /**
     * Sets the value of the flightInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightInfo(String value) {
        this.flightInfo = value;
    }

    /**
     * Gets the value of the specialRequest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialRequest() {
        return specialRequest;
    }

    /**
     * Sets the value of the specialRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialRequest(String value) {
        this.specialRequest = value;
    }

    /**
     * Gets the value of the roomtype property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRoomDetails }
     *     
     */
    public ArrayOfRoomDetails getRoomtype() {
        return roomtype;
    }

    /**
     * Sets the value of the roomtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRoomDetails }
     *     
     */
    public void setRoomtype(ArrayOfRoomDetails value) {
        this.roomtype = value;
    }

    /**
     * Gets the value of the amendmentDetails property.
     * 
     * @return
     *     possible object is
     *     {@link AmendmentDetails }
     *     
     */
    public AmendmentDetails getAmendmentDetails() {
        return amendmentDetails;
    }

    /**
     * Sets the value of the amendmentDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmendmentDetails }
     *     
     */
    public void setAmendmentDetails(AmendmentDetails value) {
        this.amendmentDetails = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the noOfRooms property.
     * 
     */
    public int getNoOfRooms() {
        return noOfRooms;
    }

    /**
     * Sets the value of the noOfRooms property.
     * 
     */
    public void setNoOfRooms(int value) {
        this.noOfRooms = value;
    }

    /**
     * Gets the value of the agencyDetails property.
     * 
     * @return
     *     possible object is
     *     {@link AgencyDetails }
     *     
     */
    public AgencyDetails getAgencyDetails() {
        return agencyDetails;
    }

    /**
     * Sets the value of the agencyDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link AgencyDetails }
     *     
     */
    public void setAgencyDetails(AgencyDetails value) {
        this.agencyDetails = value;
    }

    /**
     * Gets the value of the aotNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link AOTNumbers }
     *     
     */
    public AOTNumbers getAOTNumbers() {
        return aotNumbers;
    }

    /**
     * Sets the value of the aotNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link AOTNumbers }
     *     
     */
    public void setAOTNumbers(AOTNumbers value) {
        this.aotNumbers = value;
    }

    /**
     * Gets the value of the cityId property.
     * 
     */
    public int getCityId() {
        return cityId;
    }

    /**
     * Sets the value of the cityId property.
     * 
     */
    public void setCityId(int value) {
        this.cityId = value;
    }

    /**
     * Gets the value of the tripName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTripName() {
        return tripName;
    }

    /**
     * Sets the value of the tripName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTripName(String value) {
        this.tripName = value;
    }

    /**
     * Gets the value of the tboHotelCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTBOHotelCode() {
        return tboHotelCode;
    }

    /**
     * Sets the value of the tboHotelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTBOHotelCode(String value) {
        this.tboHotelCode = value;
    }

    /**
     * Gets the value of the currentCancellationCharges property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCurrentCancellationCharges() {
        return currentCancellationCharges;
    }

    /**
     * Sets the value of the currentCancellationCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCurrentCancellationCharges(BigDecimal value) {
        this.currentCancellationCharges = value;
    }

    /**
     * Gets the value of the appliedCancellationCharges property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAppliedCancellationCharges() {
        return appliedCancellationCharges;
    }

    /**
     * Sets the value of the appliedCancellationCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAppliedCancellationCharges(BigDecimal value) {
        this.appliedCancellationCharges = value;
    }

    /**
     * Gets the value of the bookingId property.
     * 
     */
    public int getBookingId() {
        return bookingId;
    }

    /**
     * Sets the value of the bookingId property.
     * 
     */
    public void setBookingId(int value) {
        this.bookingId = value;
    }

    /**
     * Gets the value of the amendmentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link RequestStatus }
     *     
     */
    public RequestStatus getAmendmentStatus() {
        return amendmentStatus;
    }

    /**
     * Sets the value of the amendmentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestStatus }
     *     
     */
    public void setAmendmentStatus(RequestStatus value) {
        this.amendmentStatus = value;
    }

    /**
     * Gets the value of the bookingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link APIHotelBookingStatus }
     *     
     */
    public APIHotelBookingStatus getBookingStatus() {
        return bookingStatus;
    }

    /**
     * Sets the value of the bookingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link APIHotelBookingStatus }
     *     
     */
    public void setBookingStatus(APIHotelBookingStatus value) {
        this.bookingStatus = value;
    }

    /**
     * Gets the value of the voucherStatus property.
     * 
     */
    public boolean isVoucherStatus() {
        return voucherStatus;
    }

    /**
     * Sets the value of the voucherStatus property.
     * 
     */
    public void setVoucherStatus(boolean value) {
        this.voucherStatus = value;
    }

    /**
     * Gets the value of the invoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Sets the value of the invoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceNumber(String value) {
        this.invoiceNumber = value;
    }

    /**
     * Gets the value of the supplierReferenceNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierReferenceNo() {
        return supplierReferenceNo;
    }

    /**
     * Sets the value of the supplierReferenceNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierReferenceNo(String value) {
        this.supplierReferenceNo = value;
    }

    /**
     * Gets the value of the confirmationNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmationNo() {
        return confirmationNo;
    }

    /**
     * Sets the value of the confirmationNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmationNo(String value) {
        this.confirmationNo = value;
    }

    /**
     * Gets the value of the hotelConfirmationNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelConfirmationNo() {
        return hotelConfirmationNo;
    }

    /**
     * Sets the value of the hotelConfirmationNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelConfirmationNo(String value) {
        this.hotelConfirmationNo = value;
    }

}
