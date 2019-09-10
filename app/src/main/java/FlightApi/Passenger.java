
package FlightApi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Passenger {

    @SerializedName("PassportIssueCountryCode")
    @Expose
    private Object passportIssueCountryCode;
    @SerializedName("PassportIssueDate")
    @Expose
    private String passportIssueDate;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("Mobile1")
    @Expose
    private String mobile1;
    @SerializedName("Mobile1CountryCode")
    @Expose
    private String mobile1CountryCode;
    @SerializedName("Mobile2")
    @Expose
    private Object mobile2;
    @SerializedName("IsLeadPax")
    @Expose
    private Boolean isLeadPax;
    @SerializedName("DateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("Type")
    @Expose
    private Integer type;
    @SerializedName("PassportNo")
    @Expose
    private String passportNo;
    @SerializedName("Nationality")
    @Expose
    private Nationality nationality;
    @SerializedName("Country")
    @Expose
    private Country country;
    @SerializedName("City")
    @Expose
    private City city;
    @SerializedName("AddressLine1")
    @Expose
    private String addressLine1;
    @SerializedName("AddressLine2")
    @Expose
    private Object addressLine2;
    @SerializedName("Gender")
    @Expose
    private Integer gender;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Meal")
    @Expose
    private Meal meal;
    @SerializedName("Seat")
    @Expose
    private Object seat;
    @SerializedName("Fare")
    @Expose
    private Fare fare;
    @SerializedName("FFAirline")
    @Expose
    private Object fFAirline;
    @SerializedName("FFNumber")
    @Expose
    private Object fFNumber;
    @SerializedName("PassportExpiry")
    @Expose
    private String passportExpiry;
    @SerializedName("PaxBaggage")
    @Expose
    private List<Object> paxBaggage = null;
    @SerializedName("PaxMeal")
    @Expose
    private List<Object> paxMeal = null;
    @SerializedName("IDCardNo")
    @Expose
    private Object iDCardNo;
    @SerializedName("ZipCode")
    @Expose
    private Object zipCode;
    @SerializedName("PaxSeat")
    @Expose
    private Object paxSeat;
    @SerializedName("Ticket")
    @Expose
    private Object ticket;

    public Object getPassportIssueCountryCode() {
        return passportIssueCountryCode;
    }

    public void setPassportIssueCountryCode(Object passportIssueCountryCode) {
        this.passportIssueCountryCode = passportIssueCountryCode;
    }

    public String getPassportIssueDate() {
        return passportIssueDate;
    }

    public void setPassportIssueDate(String passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getMobile1CountryCode() {
        return mobile1CountryCode;
    }

    public void setMobile1CountryCode(String mobile1CountryCode) {
        this.mobile1CountryCode = mobile1CountryCode;
    }

    public Object getMobile2() {
        return mobile2;
    }

    public void setMobile2(Object mobile2) {
        this.mobile2 = mobile2;
    }

    public Boolean getIsLeadPax() {
        return isLeadPax;
    }

    public void setIsLeadPax(Boolean isLeadPax) {
        this.isLeadPax = isLeadPax;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public Object getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(Object addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Object getSeat() {
        return seat;
    }

    public void setSeat(Object seat) {
        this.seat = seat;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public Object getFFAirline() {
        return fFAirline;
    }

    public void setFFAirline(Object fFAirline) {
        this.fFAirline = fFAirline;
    }

    public Object getFFNumber() {
        return fFNumber;
    }

    public void setFFNumber(Object fFNumber) {
        this.fFNumber = fFNumber;
    }

    public String getPassportExpiry() {
        return passportExpiry;
    }

    public void setPassportExpiry(String passportExpiry) {
        this.passportExpiry = passportExpiry;
    }

    public List<Object> getPaxBaggage() {
        return paxBaggage;
    }

    public void setPaxBaggage(List<Object> paxBaggage) {
        this.paxBaggage = paxBaggage;
    }

    public List<Object> getPaxMeal() {
        return paxMeal;
    }

    public void setPaxMeal(List<Object> paxMeal) {
        this.paxMeal = paxMeal;
    }

    public Object getIDCardNo() {
        return iDCardNo;
    }

    public void setIDCardNo(Object iDCardNo) {
        this.iDCardNo = iDCardNo;
    }

    public Object getZipCode() {
        return zipCode;
    }

    public void setZipCode(Object zipCode) {
        this.zipCode = zipCode;
    }

    public Object getPaxSeat() {
        return paxSeat;
    }

    public void setPaxSeat(Object paxSeat) {
        this.paxSeat = paxSeat;
    }

    public Object getTicket() {
        return ticket;
    }

    public void setTicket(Object ticket) {
        this.ticket = ticket;
    }

}
