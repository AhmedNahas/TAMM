
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="AgencyBalance" use="required" type="{http://TekTravel/HotelBookingApi}AccountBalance" /&gt;
 *       &lt;attribute name="AgencyBlocked" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountInfo")
public class AccountInfo {

    @XmlAttribute(name = "AgencyBalance", required = true)
    protected AccountBalance agencyBalance;
    @XmlAttribute(name = "AgencyBlocked", required = true)
    protected boolean agencyBlocked;

    /**
     * Gets the value of the agencyBalance property.
     * 
     * @return
     *     possible object is
     *     {@link AccountBalance }
     *     
     */
    public AccountBalance getAgencyBalance() {
        return agencyBalance;
    }

    /**
     * Sets the value of the agencyBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountBalance }
     *     
     */
    public void setAgencyBalance(AccountBalance value) {
        this.agencyBalance = value;
    }

    /**
     * Gets the value of the agencyBlocked property.
     * 
     */
    public boolean isAgencyBlocked() {
        return agencyBlocked;
    }

    /**
     * Sets the value of the agencyBlocked property.
     * 
     */
    public void setAgencyBlocked(boolean value) {
        this.agencyBlocked = value;
    }

}
