
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AmendmentDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AmendmentDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="BeforeAmendmentPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="AfterAmendmentPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="CreditNoteAmount" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="DebitNoteAmount" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmendmentDetails")
public class AmendmentDetails {

    @XmlAttribute(name = "BeforeAmendmentPrice", required = true)
    protected BigDecimal beforeAmendmentPrice;
    @XmlAttribute(name = "AfterAmendmentPrice", required = true)
    protected BigDecimal afterAmendmentPrice;
    @XmlAttribute(name = "CreditNoteAmount", required = true)
    protected BigDecimal creditNoteAmount;
    @XmlAttribute(name = "DebitNoteAmount", required = true)
    protected BigDecimal debitNoteAmount;

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

    /**
     * Gets the value of the creditNoteAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCreditNoteAmount() {
        return creditNoteAmount;
    }

    /**
     * Sets the value of the creditNoteAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCreditNoteAmount(BigDecimal value) {
        this.creditNoteAmount = value;
    }

    /**
     * Gets the value of the debitNoteAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDebitNoteAmount() {
        return debitNoteAmount;
    }

    /**
     * Sets the value of the debitNoteAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDebitNoteAmount(BigDecimal value) {
        this.debitNoteAmount = value;
    }

}
