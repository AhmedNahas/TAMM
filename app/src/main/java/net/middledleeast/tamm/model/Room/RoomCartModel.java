package net.middledleeast.tamm.model.Room;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RoomCartModel {


    public RoomCartModel( String country, String image, String namehotel, String price, String city) {

        this.Country = country;
        this.Image = image;
        this.Namehotel = namehotel;
        this.Price = price;
        this.City = city;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey
    private int id;


    @ColumnInfo
    private String Country;

    @ColumnInfo
    private String Image;


    @ColumnInfo
    private String Namehotel;

    @ColumnInfo
    private String Price;

    public RoomCartModel() {
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

    @ColumnInfo
    private String City;


}
