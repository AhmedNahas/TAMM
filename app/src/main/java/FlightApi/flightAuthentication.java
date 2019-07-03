package FlightApi;

import com.google.gson.annotations.SerializedName;

public class flightAuthentication {


    private final static long serialVersionUID = 8182398129840084807L;
    @SerializedName("UserName")

    private String userName;
    @SerializedName("Password")

    private String password;
    @SerializedName("BookingMode")

    private String bookingMode;
    @SerializedName("IPAddress")

    private String iPAddress;

    /**
     * No args constructor for use in serialization
     */
    public flightAuthentication() {
    }

    /**
     * @param bookingMode
     * @param userName
     * @param iPAddress
     * @param password
     */
    public flightAuthentication(String userName, String password, String bookingMode, String iPAddress) {
        super();
        this.userName = userName;
        this.password = password;
        this.bookingMode = bookingMode;
        this.iPAddress = iPAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public flightAuthentication withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public flightAuthentication withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getBookingMode() {
        return bookingMode;
    }

    public void setBookingMode(String bookingMode) {
        this.bookingMode = bookingMode;
    }

    public flightAuthentication withBookingMode(String bookingMode) {
        this.bookingMode = bookingMode;
        return this;
    }

    public String getIPAddress() {
        return iPAddress;
    }

    public void setIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    public flightAuthentication withIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
        return this;
    }

}
