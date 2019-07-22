//package net.middledleeast.tamm.helper.room;
//
//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.Query;
//import androidx.room.Update;
//
//import java.util.List;
//
//@Dao
//public interface CountryDeo {
//    @Query("SELECT * fROM RoomcountrytModel")
//    List<RoomcountrytModel> getAllData();
//
//    @Insert
//    void insertAll(RoomcountrytModel... cartModels);
//
//    @Query("delete from RoomcountrytModel")
//    void deletAll();
//
//    @Delete
//    void deleteItem(RoomcountrytModel ... cartModels);
//    @Update
//    void update(RoomcountrytModel ... cartModels);
//}