
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="VoucherBooking" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="PaymentModeType" use="required" type="{http://TekTravel/HotelBookingApi}PaymentModeType" /&gt;
 *       &lt;attribute name="CvvNumber" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentInfo")
public class PaymentInfo {

    @XmlAttribute(name = "VoucherBooking", required = true)
    protected boolean voucherBooking;
    @XmlAttribute(name = "PaymentModeType", required = true)
    protected PaymentModeType paymentModeType;
    @XmlAttribute(name = "CvvNumber")
    protected String cvvNumber;

    /**
     * Gets the value of the voucherBooking property.
     * 
     */
    public boolean isVoucherBooking() {
        return voucherBooking;
    }

    /**
     * Sets the value of the voucherBooking property.
     * 
     */
    public void setVoucherBooking(boolean value) {
        this.voucherBooking = value;
    }

    /**
     * Gets the value of the paymentModeType property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentModeType }
     *     
     */
    public PaymentModeType getPaymentModeType() {
        return paymentModeType;
    }

    /**
     * Sets the value of the paymentModeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentModeType }
     *     
     */
    public void setPaymentModeType(PaymentModeType value) {
        this.paymentModeType = value;
    }

    /**
     * Gets the value of the cvvNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCvvNumber() {
        return cvvNumber;
    }

    /**
     * Sets the value of the cvvNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCvvNumber(String value) {
        this.cvvNumber = value;
    }

}
