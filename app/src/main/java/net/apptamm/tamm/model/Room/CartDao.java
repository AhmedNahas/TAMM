package net.apptamm.tamm.model.Room;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CartDao {

    @Insert
    public void addoffer(RoomCartModel roomCartModel);



    @Query("SELECT * fROM RoomCartModel")
    List<RoomCartModel> getAllData();


    @Query("delete from RoomCartModel")
    void deletAll();

    @Delete
    void deleteItem(RoomCartModel ... cartModels);
    @Update
    void update(RoomCartModel ... cartModels);


}
