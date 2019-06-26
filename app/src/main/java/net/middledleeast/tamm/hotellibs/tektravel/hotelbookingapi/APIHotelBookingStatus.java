
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for APIHotelBookingStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="APIHotelBookingStatus"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Failed"/&gt;
 *     &lt;enumeration value="Confirmed"/&gt;
 *     &lt;enumeration value="Cancelled"/&gt;
 *     &lt;enumeration value="Pending"/&gt;
 *     &lt;enumeration value="Rejected"/&gt;
 *     &lt;enumeration value="Vouchered"/&gt;
 *     &lt;enumeration value="CancellationInProgress"/&gt;
 *     &lt;enumeration value="CxlRequestSentToHotel"/&gt;
 *     &lt;enumeration value="WaitingForPayment"/&gt;
 *     &lt;enumeration value="CancelledAndRefundAwaited"/&gt;
 *     &lt;enumeration value="Requested"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "APIHotelBookingStatus")
@XmlEnum
public enum APIHotelBookingStatus {

    @XmlEnumValue("Failed")
    FAILED("Failed"),
    @XmlEnumValue("Confirmed")
    CONFIRMED("Confirmed"),
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("Pending")
    PENDING("Pending"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected"),
    @XmlEnumValue("Vouchered")
    VOUCHERED("Vouchered"),
    @XmlEnumValue("CancellationInProgress")
    CANCELLATION_IN_PROGRESS("CancellationInProgress"),
    @XmlEnumValue("CxlRequestSentToHotel")
    CXL_REQUEST_SENT_TO_HOTEL("CxlRequestSentToHotel"),
    @XmlEnumValue("WaitingForPayment")
    WAITING_FOR_PAYMENT("WaitingForPayment"),
    @XmlEnumValue("CancelledAndRefundAwaited")
    CANCELLED_AND_REFUND_AWAITED("CancelledAndRefundAwaited"),
    @XmlEnumValue("Requested")
    REQUESTED("Requested");
    private final String value;

    APIHotelBookingStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static APIHotelBookingStatus fromValue(String v) {
        for (APIHotelBookingStatus c: APIHotelBookingStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
