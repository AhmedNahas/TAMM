
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RequestStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RequestStatus"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Unprocessed"/&gt;
 *     &lt;enumeration value="RequestSent"/&gt;
 *     &lt;enumeration value="InProgress"/&gt;
 *     &lt;enumeration value="AgentApprovalPending"/&gt;
 *     &lt;enumeration value="PendingWithSupplier"/&gt;
 *     &lt;enumeration value="Amended"/&gt;
 *     &lt;enumeration value="Withdrawn"/&gt;
 *     &lt;enumeration value="Rejected"/&gt;
 *     &lt;enumeration value="Cancelled"/&gt;
 *     &lt;enumeration value="NotRequested"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RequestStatus")
@XmlEnum
public enum RequestStatus {

    @XmlEnumValue("Unprocessed")
    UNPROCESSED("Unprocessed"),
    @XmlEnumValue("RequestSent")
    REQUEST_SENT("RequestSent"),
    @XmlEnumValue("InProgress")
    IN_PROGRESS("InProgress"),
    @XmlEnumValue("AgentApprovalPending")
    AGENT_APPROVAL_PENDING("AgentApprovalPending"),
    @XmlEnumValue("PendingWithSupplier")
    PENDING_WITH_SUPPLIER("PendingWithSupplier"),
    @XmlEnumValue("Amended")
    AMENDED("Amended"),
    @XmlEnumValue("Withdrawn")
    WITHDRAWN("Withdrawn"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected"),
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("NotRequested")
    NOT_REQUESTED("NotRequested");
    private final String value;

    RequestStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RequestStatus fromValue(String v) {
        for (RequestStatus c: RequestStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
