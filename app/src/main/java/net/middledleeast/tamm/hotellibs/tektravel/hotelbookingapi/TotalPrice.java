
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TotalPrice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TotalPrice"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="BeforeAmendmentPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="AfterAmendmentPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TotalPrice")
public class TotalPrice {

    @XmlAttribute(name = "BeforeAmendmentPrice", required = true)
    protected BigDecimal beforeAmendmentPrice;
    @XmlAttribute(name = "AfterAmendmentPrice", required = true)
    protected BigDecimal afterAmendmentPrice;

    /**
     * Gets the value of the beforeAmendmentPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBeforeAmendmentPrice() {
        return beforeAmendmentPrice;
    }

    /**
     * Sets the value of the beforeAmendmentPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBeforeAmendmentPrice(BigDecimal value) {
        this.beforeAmendmentPrice = value;
    }

    /**
     * Gets the value of the afterAmendmentPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAfterAmendmentPrice() {
        return afterAmendmentPrice;
    }

    /**
     * Sets the value of the afterAmendmentPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAfterAmendmentPrice(BigDecimal value) {
        this.afterAmendmentPrice = value;
    }

}
