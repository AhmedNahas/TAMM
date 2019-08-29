package net.middledleeast.tamm.model.Room;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.Tamm.Hotels.wcf.AmendmentRequestType;

@Entity
public class RoomCartModel {


    public RoomCartModel( String country, String image, String namehotel, String price, String city) {

        this.Country = country;
        this.Image = image;
        this.Namehotel = namehotel;
        this.Price = price;
        this.City = city;
    }


    public RoomCartModel(String untile, String imageRoom, String checkIn , String CheckOut , String BookingId   ,  String ConfirmationNo ,

                          String resultIndex , String hotel_name

                         ) {
        this.hotel_name = hotel_name;
        this.resultIndex = resultIndex;
        this.ConfirmationNo = ConfirmationNo;
        this.untile = untile;
        this.imageRoom = imageRoom;
        this.checkIn = checkIn;
        this.CheckOut = CheckOut;
        this.BookingId = BookingId;



    }


    public RoomCartModel() {
    }

    @PrimaryKey
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo
    private String hotel_name;

    @ColumnInfo
    private String resultIndex;

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

    @ColumnInfo
    private String ConfirmationNo;




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

    @ColumnInfo
    private String City;


}