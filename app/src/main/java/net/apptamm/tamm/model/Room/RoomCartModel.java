package net.apptamm.tamm.model.Room;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RoomCartModel {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;

    @ColumnInfo
    private String To;



    @ColumnInfo
    private String AirLinePhoto;


    public String getAirLinePhoto() {
        return AirLinePhoto;
    }

    public void setAirLinePhoto(String airLinePhoto) {
        AirLinePhoto = airLinePhoto;
    }

    public String getAirLineName() {
        return AirLineName;
    }

    public void setAirLineName(String airLineName) {
        AirLineName = airLineName;
    }

    public String getAirLinePhotoReturn() {
        return AirLinePhotoReturn;
    }

    public void setAirLinePhotoReturn(String airLinePhotoReturn) {
        AirLinePhotoReturn = airLinePhotoReturn;
    }

    public String getAirLineNAmeReturn() {
        return AirLineNAmeReturn;
    }

    public void setAirLineNAmeReturn(String airLineNAmeReturn) {
        AirLineNAmeReturn = airLineNAmeReturn;
    }

    public String getToReturn() {
        return ToReturn;
    }

    public void setToReturn(String toReturn) {
        ToReturn = toReturn;
    }

    public String getFromReturn() {
        return FromReturn;
    }

    public void setFromReturn(String fromReturn) {
        FromReturn = fromReturn;
    }

    public String getFLghtNoReturn() {
        return FLghtNoReturn;
    }

    public void setFLghtNoReturn(String FLghtNoReturn) {
        this.FLghtNoReturn = FLghtNoReturn;
    }

    public String getDateReturn() {
        return DateReturn;
    }

    public void setDateReturn(String dateReturn) {
        DateReturn = dateReturn;
    }

    public String getTimeReturn() {
        return TimeReturn;
    }

    public void setTimeReturn(String timeReturn) {
        TimeReturn = timeReturn;
    }




    @ColumnInfo
    private String AirLineName;


    public RoomCartModel(String airLinePhotoReturn, String airLineNAmeReturn, String toReturn, String fromReturn, String FLghtNoReturn, String dateReturn, String
            timeReturn,

    String namePassenger, String from, String to, String flightNo, String date, String AirlinePhoto, String AirlineName, String time, String ticketNo

    ) {
        AirLinePhotoReturn = airLinePhotoReturn;
        AirLineNAmeReturn = airLineNAmeReturn;
        ToReturn = toReturn;
        FromReturn = fromReturn;
        this.FLghtNoReturn = FLghtNoReturn;
        DateReturn = dateReturn;
        TimeReturn = timeReturn;
        NamePassenger = namePassenger;
        From = from;
        To = to;
        FlightNo = flightNo;
        Date = date;
        this.AirLineName = AirlineName;
        this.AirLinePhoto = AirlinePhoto;
        Time = time;
        TicketNo = ticketNo;

    }

    @ColumnInfo
    private String AirLinePhotoReturn;


    @ColumnInfo
    private String AirLineNAmeReturn;


    @ColumnInfo
    private String ToReturn;


    @ColumnInfo
    private String FromReturn;


    @ColumnInfo
    private String FLghtNoReturn;


    @ColumnInfo
    private String DateReturn;



    @ColumnInfo
    private String TimeReturn;














    @ColumnInfo
    private String FlightNo;

    public String getFlightNo() {
        return FlightNo;
    }

    @ColumnInfo
    private String Date;

    @ColumnInfo
    private String Gate;

    @ColumnInfo
    private String Seat;

    @ColumnInfo
    private String Time;

    @ColumnInfo
    private String TicketNo;


    @ColumnInfo
    private String booked;

    @ColumnInfo
    private String booking;

    @ColumnInfo
    private String tripname;

    @ColumnInfo
    private String City;

    @ColumnInfo
    private String ConfirmationNo;


    @ColumnInfo
    private String leadguest;

    @ColumnInfo
    private int noofguest;


    @ColumnInfo
    private String canceldate;

    @ColumnInfo
    private String citymethod;

    @ColumnInfo
    private String cancelfees;

    @ColumnInfo
    private String untile;

    @ColumnInfo
    private String imageRoom;


    @ColumnInfo
    private String checkIn;


    @ColumnInfo
    private String CheckOut;


    @ColumnInfo
    private String BookingId;

    @ColumnInfo
    private String Country;

    @ColumnInfo
    private String Image;


    @ColumnInfo
    private String Namehotel;

    @ColumnInfo
    private String Price;


    @ColumnInfo
    private String NamePassenger;


    @ColumnInfo
    private String From;
    @ColumnInfo
    private String hotel_name;

    @ColumnInfo
    private String resultIndex;

    public RoomCartModel(String country, String image, String namehotel, String price, String city) {

        this.Country = country;
        this.Image = image;
        this.Namehotel = namehotel;
        this.Price = price;
        this.City = city;
    }


    public RoomCartModel(String untile, String imageRoom, String checkIn, String CheckOut, String BookingId, String ConfirmationNo,

                         String resultIndex, String hotel_name,

                         String booked, String booking, String tripname, String leadguest, int noofguest, String citymethod) {

        this.hotel_name = hotel_name;
        this.resultIndex = resultIndex;
        this.ConfirmationNo = ConfirmationNo;
        this.untile = untile;
        this.imageRoom = imageRoom;
        this.checkIn = checkIn;
        this.CheckOut = CheckOut;
        this.BookingId = BookingId;
        this.booked = booked;
        this.booking = booking;
        this.tripname = tripname;
        this.leadguest = leadguest;
        this.noofguest = noofguest;
        this.citymethod = citymethod;

    }


    public RoomCartModel() {
    }


    public RoomCartModel(String namePassenger, String from, String to, String flightNo, String date, String AirlinePhoto, String AirlineName, String time, String ticketNo) {
        NamePassenger = namePassenger;
        From = from;
        To = to;
        FlightNo = flightNo;
        Date = date;
       this.AirLineName = AirlineName;
       this.AirLinePhoto = AirlinePhoto;
        Time = time;
        TicketNo = ticketNo;
    }


    public String getNamePassenger() {
        return NamePassenger;
    }

    public void setNamePassenger(String namePassenger) {
        NamePassenger = namePassenger;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }


    public void setFlightNo(String flightNo) {
        FlightNo = flightNo;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getGate() {
        return Gate;
    }

    public void setGate(String gate) {
        Gate = gate;
    }

    public String getSeat() {
        return Seat;
    }

    public void setSeat(String seat) {
        Seat = seat;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getTicketNo() {
        return TicketNo;
    }

    public void setTicketNo(String ticketNo) {
        TicketNo = ticketNo;
    }


    public String getBooked() {
        return booked;
    }

    public void setBooked(String booked) {
        this.booked = booked;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    public String getTripname() {
        return tripname;
    }

    public void setTripname(String tripname) {
        this.tripname = tripname;
    }

    public String getLeadguest() {
        return leadguest;
    }

    public void setLeadguest(String leadguest) {
        this.leadguest = leadguest;
    }

    public int getNoofguest() {
        return noofguest;
    }

    public void setNoofguest(int noofguest) {
        this.noofguest = noofguest;
    }

    public String getCanceldate() {
        return canceldate;
    }

    public void setCanceldate(String canceldate) {
        this.canceldate = canceldate;
    }

    public String getCitymethod() {
        return citymethod;
    }

    public void setCitymethod(String citymethod) {
        this.citymethod = citymethod;
    }

    public String getCancelfees() {
        return cancelfees;
    }

    public void setCancelfees(String cancelfees) {
        this.cancelfees = cancelfees;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getResultIndex() {
        return resultIndex;
    }

    public void setResultIndex(String resultIndex) {
        this.resultIndex = resultIndex;
    }

    public String getConfirmationNo() {
        return ConfirmationNo;
    }

    public void setConfirmationNo(String confirmationNo) {
        ConfirmationNo = confirmationNo;
    }


    public String getUntile() {
        return untile;
    }

    public void setUntile(String untile) {
        this.untile = untile;
    }

    public String getImageRoom() {
        return imageRoom;
    }

    public void setImageRoom(String imageRoom) {
        this.imageRoom = imageRoom;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return CheckOut;
    }

    public void setCheckOut(String checkOut) {
        CheckOut = checkOut;
    }

    public String getBookingId() {
        return BookingId;
    }

    public void setBookingId(String bookingId) {
        BookingId = bookingId;
    }


    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getNamehotel() {
        return Namehotel;
    }

    public void setNamehotel(String namehotel) {
        Namehotel = namehotel;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }


}
