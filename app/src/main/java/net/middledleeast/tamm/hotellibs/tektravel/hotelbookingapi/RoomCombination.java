
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoomCombination complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoomCombination"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RoomIndex" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="TestElement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomCombination", propOrder = {
    "roomIndex",
    "testElement"
})
public class RoomCombination {

    @XmlElement(name = "RoomIndex", type = Integer.class)
    protected List<Integer> roomIndex;
    @XmlElement(name = "TestElement")
    protected String testElement;

    /**
     * Gets the value of the roomIndex property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomIndex property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomIndex().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getRoomIndex() {
        if (roomIndex == null) {
            roomIndex = new ArrayList<Integer>();
        }
        return this.roomIndex;
    }

    /**
     * Gets the value of the testElement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestElement() {
        return testElement;
    }

    /**
     * Sets the value of the testElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestElement(String value) {
        this.testElement = value;
    }

}
