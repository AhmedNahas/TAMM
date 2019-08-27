package net.middledleeast.tamm.model.Room;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RoomCartModel {


    public RoomCartModel( String name, String image, String namehotel) {
        this.Name = name;
        this.Image = image;
        this. Namehotel = namehotel;
    }

    public RoomCartModel() {
    }

    @PrimaryKey
    private int id;


    @ColumnInfo
    private String Name;

    @ColumnInfo
    private String Image;


    @ColumnInfo
    private String Namehotel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
}
