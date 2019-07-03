package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SearchFlights implements Serializable {

    private final static long serialVersionUID = -607291032323431408L;
    @SerializedName("IPAddress")
    @Expose
    private String iPAddress;
    @SerializedName("TokenId")
    @Expose
    private String tokenId;
    @SerializedName("JourneyType")
    @Expose
    private long journeyType;
    @SerializedName("AdultCount")
    @Expose
    private long adultCount;
    @SerializedName("ChildCount")
    @Expose
    private long childCount;
    @SerializedName("InfantCount")
    @Expose
    private long infantCount;
    @SerializedName("FlightCabinClass")
    @Expose
    private long flightCabinClass;
    @SerializedName("Segment")
    @Expose
    private List<Segment> segment = new ArrayList<Segment>();

    /**
     * No args constructor for use in serialization
     */
    public SearchFlights() {
    }

    /**
     * @param tokenId
     * @param childCount
     * @param segment
     * @param adultCount
     * @param infantCount
     * @param iPAddress
     * @param flightCabinClass
     * @param journeyType
     */
    public SearchFlights(String iPAddress, String tokenId, long journeyType, long adultCount, long childCount, long infantCount, long flightCabinClass, List<Segment> segment) {
        super();
        this.iPAddress = iPAddress;
        this.tokenId = tokenId;
        this.journeyType = journeyType;
        this.adultCount = adultCount;
        this.childCount = childCount;
        this.infantCount = infantCount;
        this.flightCabinClass = flightCabinClass;
        this.segment = segment;
    }

    public String getIPAddress() {
        return iPAddress;
    }

    public void setIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    public SearchFlights withIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
        return this;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public SearchFlights withTokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public long getJourneyType() {
        return journeyType;
    }

    public void setJourneyType(long journeyType) {
        this.journeyType = journeyType;
    }

    public SearchFlights withJourneyType(long journeyType) {
        this.journeyType = journeyType;
        return this;
    }

    public long getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(long adultCount) {
        this.adultCount = adultCount;
    }

    public SearchFlights withAdultCount(long adultCount) {
        this.adultCount = adultCount;
        return this;
    }

    public long getChildCount() {
        return childCount;
    }

    public void setChildCount(long childCount) {
        this.childCount = childCount;
    }

    public SearchFlights withChildCount(long childCount) {
        this.childCount = childCount;
        return this;
    }

    public long getInfantCount() {
        return infantCount;
    }

    public void setInfantCount(long infantCount) {
        this.infantCount = infantCount;
    }

    public SearchFlights withInfantCount(long infantCount) {
        this.infantCount = infantCount;
        return this;
    }

    public long getFlightCabinClass() {
        return flightCabinClass;
    }

    public void setFlightCabinClass(long flightCabinClass) {
        this.flightCabinClass = flightCabinClass;
    }

    public SearchFlights withFlightCabinClass(long flightCabinClass) {
        this.flightCabinClass = flightCabinClass;
        return this;
    }

    public List<Segment> getSegment() {
        return segment;
    }

    public void setSegment(List<Segment> segment) {
        this.segment = segment;
    }

    public SearchFlights withSegment(List<Segment> segment) {
        this.segment = segment;
        return this;
    }


    public class Segment implements Serializable {

        private final static long serialVersionUID = 7158243469548762065L;
        @SerializedName("Origin")
        @Expose
        private String origin;
        @SerializedName("Destination")
        @Expose
        private String destination;
        @SerializedName("PreferredDepartureTime")
        @Expose
        private String preferredDepartureTime;
        @SerializedName("PreferredArrivalTime")
        @Expose
        private String preferredArrivalTime;

        /**
         * No args constructor for use in serialization
         */
        public Segment() {
        }

        /**
         * @param preferredDepartureTime
         * @param origin
         * @param preferredArrivalTime
         * @param destination
         */
        public Segment(String origin, String destination, String preferredDepartureTime, String preferredArrivalTime) {
            super();
            this.origin = origin;
            this.destination = destination;
            this.preferredDepartureTime = preferredDepartureTime;
            this.preferredArrivalTime = preferredArrivalTime;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public Segment withOrigin(String origin) {
            this.origin = origin;
            return this;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public Segment withDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public String getPreferredDepartureTime() {
            return preferredDepartureTime;
        }

        public void setPreferredDepartureTime(String preferredDepartureTime) {
            this.preferredDepartureTime = preferredDepartureTime;
        }

        public Segment withPreferredDepartureTime(String preferredDepartureTime) {
            this.preferredDepartureTime = preferredDepartureTime;
            return this;
        }

        public String getPreferredArrivalTime() {
            return preferredArrivalTime;
        }

        public void setPreferredArrivalTime(String preferredArrivalTime) {
            this.preferredArrivalTime = preferredArrivalTime;
        }

        public Segment withPreferredArrivalTime(String preferredArrivalTime) {
            this.preferredArrivalTime = preferredArrivalTime;
            return this;
        }
    }
}