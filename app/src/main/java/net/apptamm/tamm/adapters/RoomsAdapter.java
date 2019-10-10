package net.apptamm.tamm.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.Tamm.Hotels.wcf.ArrayOfRequestedRooms;
import com.Tamm.Hotels.wcf.ArrayOfSuppInfo;
import com.Tamm.Hotels.wcf.ArrayOfSupplement;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.CancelPolicies;
import com.Tamm.Hotels.wcf.Enums;
import com.Tamm.Hotels.wcf.HotelRoomAvailabilityResponse;
import com.Tamm.Hotels.wcf.Hotel_Room;
import com.Tamm.Hotels.wcf.Rate;
import com.Tamm.Hotels.wcf.RequestedRooms;
import com.Tamm.Hotels.wcf.RoomCombination;
import com.Tamm.Hotels.wcf.RoomInformation;
import com.Tamm.Hotels.wcf.SuppInfo;
import com.Tamm.Hotels.wcf.Supplement;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.apptamm.tamm.R;
import net.apptamm.tamm.activities.ChooseBookingDate;
import net.apptamm.tamm.activities.WelcomeActivity;
import net.apptamm.tamm.activities.checkroom;
import net.apptamm.tamm.helper.SharedPreferencesManger;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.ViewHolder> {

    private final Context context;
    Activity activity;
    private Hotel_Room hotel_room;
    private final String date1;
    private final String date2;
    private final int noOfRooms;
    private final int resultIndex;
    private final String mHOtelCode;
    private final AuthenticationData authenticandata;
    private final String sessionId;
    private List<Hotel_Room> rooms;
    RoomInformation roomInformation;
    private String roomInstructions;
    private String description;
    HotelRoomAvailabilityResponse response;
    BasicHttpBinding_IHotelService1 service;
    AuthenticationData authenticationData;
    private int noOfTimes;
    ArrayList<Integer> roomIndices;
    ArrayList<Integer> possiblerooms;
    Type fooType;
    ArrayList<RoomCombination> possibleCombinations;
    ArrayOfRequestedRooms arrayOfRooms;
    private double sum;
    private Integer accountPlan;
    private String feesFree;
    private String feesMember;
    private String inclusion;


    public RoomsAdapter(ArrayList<Integer> roomCombs, Activity activity, AuthenticationData data, BasicHttpBinding_IHotelService1 service,
                        HotelRoomAvailabilityResponse response, List<Hotel_Room> rooms, Hotel_Room hotel_room,
                        String date1, String date2, int noOfRooms, int resultIndex, String mHotelCode, AuthenticationData authenticationData, String sessionId, Context context) {
        this.rooms = rooms;
        this.hotel_room = hotel_room;
        this.date1 = date1;
        this.date2 = date2;
        this.noOfRooms = noOfRooms;
        this.resultIndex = resultIndex;
        this.mHOtelCode = mHotelCode;
        this.authenticandata = authenticationData;
        this.sessionId = sessionId;
        this.context = context;
        this.roomInformation = hotel_room.RoomAdditionalInfo;
        this.response = response;
        this.service = service;
        this.authenticationData = data;
        this.activity = activity;
        notifyDataSetChanged();
        String roomIndexArrayStr = SharedPreferencesManger.LoadStringData(context, "roomIndexArray");
        Gson gson = new Gson();
        ArrayList<Double> tempRoomIndices = new ArrayList<>();
        tempRoomIndices = gson.fromJson(roomIndexArrayStr, ArrayList.class);
//        ArrayList<Integer> roomIndexArrayInt = new ArrayList<>();
//        for (double aDouble : roomIndices) {
//            roomIndexArrayInt.ic_add((int)aDouble);
//        }
        roomIndices = new ArrayList<>();
        if (tempRoomIndices != null) {
            for (double tempRoomIndex : tempRoomIndices) {
                roomIndices.add((int) tempRoomIndex);
            }

        }

        fooType = new TypeToken<ArrayList<RoomCombination>>() {
        }.getType();

        String roomComb = SharedPreferencesManger.LoadStringData(context, "RoomComb");
        possibleCombinations = (ArrayList<RoomCombination>) new Gson().fromJson(roomComb, fooType);

        this.possiblerooms = roomCombs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder;
        View linearLayout = LayoutInflater.from(context)
                .inflate(R.layout.rooms_row, parent, false);
        holder = new ViewHolder(linearLayout);

        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String roomType = rooms.get(position).RoomTypeName;
        hotel_room = rooms.get(position);

        feesFree = SharedPreferencesManger.LoadStringData(context, "feesFree");
        feesMember = SharedPreferencesManger.LoadStringData(context, "feesMember");

//        String feesMemberForEachRoom = SharedPreferencesManger.LoadStringData(context, "feesMemberForEachRoom");
//        String feesFreeForEachRoom = SharedPreferencesManger.LoadStringData(context, "feesFreeForEachRoom");
        accountPlan = SharedPreferencesManger.LoadIntegerData(context, "accountPlan");


        SharedPreferencesManger.SaveData(context, "RoomComb", new Gson().toJson(possibleCombinations, fooType));






//        Hotel_Room hotel_room1 = rooms.get(1);
        String mealType = rooms.get(position).MealType;
        inclusion = rooms.get(position).Inclusion;




        SharedPreferencesManger.SaveData(context, "inclusion", mealType);

        String currency = rooms.get(position).RoomRate.Currency;
        CancelPolicies cancelPolicies = rooms.get(position).CancelPolicies;

        String gustMode = SharedPreferencesManger.LoadStringData(context, "guestMode");

        BigDecimal roomprice = rooms.get(position).RoomRate.TotalFare;


        if (gustMode != null) {


            holder.roomPrice.setText(roomprice.toString());

        } else {

            String roomPromotion = rooms.get(position).RoomPromtion;


            if (accountPlan == 1) {

                double price_ = Double.parseDouble(roomprice.toString());
                double price_1 = Double.parseDouble(feesFree);


                sum = Double.sum(price_1, price_);
                holder.roomPrice.setText(currency + " " + sum);

            } else if (accountPlan == 0) {

                double price_ = Double.parseDouble(roomprice.toString());
                double price_1 = Double.parseDouble(feesMember);


                sum = Double.sum(price_1, price_);
                holder.roomPrice.setText(currency + " " + sum);


            }


        }


        roomInformation = rooms.get(position).RoomAdditionalInfo;
//        BigDecimal price = rooms.get(position).Supplements.get(position).Price;
        if (rooms.get(position).Inclusion != null) {
            holder.mName.setText(roomType + "\n" + "Inclusion :" + inclusion);


        }


        holder.mName.setText(roomType);
//        holder.roomPrice.setText((CharSequence) price);

        ArrayOfSupplement arrayOfSupplement = rooms.get(position).Supplements;
        Gson gson = new Gson();
        String arrayOfsupString = gson.toJson(arrayOfSupplement);
        SharedPreferencesManger.SaveData((Activity) context, "suppArray", arrayOfsupString);
        if (arrayOfSupplement != null) {
            for (Supplement supplement : arrayOfSupplement) {
                boolean requiredSupplement = supplement.SuppIsMandatory;

            }
        }
        //image
        if (roomInformation != null) {
            List<String> images = rooms.get(position).RoomAdditionalInfo.ImageURLs;
            Glide.with(context).load(images).into(holder.img_photo_hotel);
            roomInstructions = rooms.get(position).MealType;
            description = rooms.get(position).RoomAdditionalInfo.Description;
        } else {


            holder.img_photo_hotel.setImageResource(R.drawable.no_image_available);

        }
        holder.roomBooken.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {


//                                                     SharedPreferencesManger.SaveData(activity, "roomPrice", String.valueOf(sum));


                                                     if (possibleCombinations == null || possibleCombinations.size() == 0) {
                                                         ArrayList<RoomCombination> optionsForBooking = response.OptionsForBooking.RoomCombination;
                                                         possibleCombinations = new ArrayList();

//
                                                         for (RoomCombination roomCombination : optionsForBooking) {
                                                             for (int i : roomCombination.RoomIndex) {
                                                                 if (i == rooms.get(position).RoomIndex) {

                                                                     possibleCombinations.add(roomCombination);
                                                                     String test = roomCombination.TestElement;

                                                                 }


                                                             }

                                                         }

                                                     } else {

                                                         // FIXME: 30/07/19 ic_add logic

                                                         // FIXME: 29/07/19 prevent duplicate room indices

                                                         for (RoomCombination possibleCombination : possibleCombinations) {
                                                             if (!possibleCombination.RoomIndex.contains(rooms.get(position).RoomIndex)) {
                                                                 possibleCombinations.remove(possibleCombination);
                                                             }
                                                         }
                                                     }
                                                     possiblerooms = new ArrayList<>();
                                                     possiblerooms.clear();
                                                     for (RoomCombination roomCombination : possibleCombinations) {

                                                         possiblerooms.addAll(roomCombination.RoomIndex);

                                                     }
                                                     roomIndices.add(rooms.get(position).RoomIndex);

                                                     for (Integer roomIndex : roomIndices) {
                                                         if (possiblerooms.contains(roomIndex)) {
                                                             possiblerooms.remove(roomIndex);
                                                         }
                                                     }
                                                     // TODO: 28/07/19 open new activity using possiblerooms
                                                     int noOfRooms = SharedPreferencesManger.LoadIntegerData(context, "noOfRooms");
                                                     // FIXME: 29/07/19 more tha two rooms
                                                     noOfTimes = SharedPreferencesManger.LoadIntegerData(context, "noOfTimes");
                                                     if (noOfTimes == 0) {
                                                         noOfTimes = 2;
                                                     }
                                                     if (noOfRooms > 1 && noOfTimes <= noOfRooms) {

                                                         String reqRoomString = SharedPreferencesManger.LoadStringData(context, "arrayOfroomsreq");

                                                         arrayOfRooms = gson.fromJson(reqRoomString, ArrayOfRequestedRooms.class);
                                                         if (arrayOfRooms == null) {
                                                             arrayOfRooms = new ArrayOfRequestedRooms();

                                                         }
                                                         RequestedRooms requestedRooms = new RequestedRooms();
                                                         requestedRooms.RatePlanCode = rooms.get(position).RatePlanCode;
                                                         requestedRooms.RoomIndex = rooms.get(position).RoomIndex;
                                                         requestedRooms.RoomRate = new Rate();
                                                         if (rooms.get(position).Supplements != null) {
                                                             requestedRooms.Supplements = new ArrayOfSuppInfo();
                                                             for (Supplement supplement : rooms.get(position).Supplements) {
                                                                 SuppInfo suppInfo = new SuppInfo();
                                                                 suppInfo.SuppChargeType = Enums.SuppChargeType.valueOf(supplement.SuppChargeType.name());
                                                                 suppInfo.Price = supplement.Price;
                                                                 if (supplement.SuppIsMandatory) {
                                                                     suppInfo.SuppIsSelected = true;

                                                                 }
                                                                 requestedRooms.Supplements.add(suppInfo);
                                                             }
                                                         }

                                                                                                                           
                                                         requestedRooms.RoomRate.RoomFare = rooms.get(position).RoomRate.RoomFare;
                                                         requestedRooms.RoomRate.RoomTax = rooms.get(position).RoomRate.RoomTax;
                                                         requestedRooms.RoomRate.TotalFare = rooms.get(position).RoomRate.TotalFare;
                                                         requestedRooms.RoomTypeCode = rooms.get(position).RoomTypeCode;
                                                         requestedRooms.RoomTypeName = rooms.get(position).RoomTypeName;

                                                         arrayOfRooms.add(requestedRooms);

                                                         String requestedRoomsString = gson.toJson(arrayOfRooms);
                                                         SharedPreferencesManger.SaveData(context, "arrayOfroomsreq", requestedRoomsString);

                                                         AlertDialog.Builder alert = new AlertDialog.Builder(context);
                                                         alert.setMessage("Please select next room");
                                                         alert.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                                                             @Override
                                                             public void onClick(DialogInterface dialog, int which) {
                                                                 ((Activity) context).finish();
                                                                 Intent intent = new Intent(context, ChooseBookingDate.class);
                                                                 intent.putExtra("roomcomb", new Gson().toJson(possiblerooms));
                                                                 context.startActivity(intent);
                                                                 noOfTimes++;
                                                                 SharedPreferencesManger.SaveData(context, "noOfTimes", noOfTimes);
                                                                 String roomIndexStr = gson.toJson(roomIndices);
                                                                 SharedPreferencesManger.SaveData(context, "roomIndexArray", roomIndexStr);
                                                             }
                                                         });
                                                         alert.show();
                                                     } else {

                                                         Intent intent = new Intent(context, checkroom.class);

                                                         intent.putExtra("noOfRooms", noOfRooms);
                                                         intent.putExtra("resultIndex", resultIndex);
                                                         intent.putExtra("date1", date1);
                                                         intent.putExtra("date2", date2);
                                                         intent.putExtra("mHOtelCode", mHOtelCode);
//                intent.putExtra("authenticandata", new Gson().toJson(authenticandata));
                                                         intent.putExtra("roomIndex", position + 1);
                                                         intent.putExtra("smok", roomInstructions);
                                                         intent.putExtra("roomTybe", roomType);


                                                         intent.putExtra("roomPrice", holder.roomPrice.getText().toString());


                                                         intent.putExtra("description", description);
                                                         intent.putExtra("mealTybe", mealType);
//                                                     intent.putExtra("roomPrice", String.valueOf(sum));
                                                         intent.putExtra("currency", currency);
                                                         SharedPreferencesManger.SaveData(activity, "currency", currency);
//                                                         SharedPreferencesManger.SaveData(activity, "roomPrice", String.valueOf(sum));
                                                         SharedPreferencesManger.SaveData(activity, "roomIndex", position);
                                                         SharedPreferencesManger.SaveData(activity, "roomType", roomType);
                                                         String roomIndexStr = gson.toJson(roomIndices);
                                                         SharedPreferencesManger.SaveData(context, "roomIndexArray", roomIndexStr);
                                                         try {
                                                             SharedPreferencesManger.SaveData(activity, "deadLine", cancelPolicies.LastCancellationDeadline.toString());

                                                         } catch (Exception e) {


                                                         }

// FIXME: 29/07/19 send right rooms
                                                         String reqRoomString = SharedPreferencesManger.LoadStringData(context, "arrayOfroomsreq");

                                                         arrayOfRooms = gson.fromJson(reqRoomString, ArrayOfRequestedRooms.class);
                                                         if (arrayOfRooms == null) {
                                                             arrayOfRooms = new ArrayOfRequestedRooms();

                                                         }
                                                         RequestedRooms requestedRooms = new RequestedRooms();
                                                         requestedRooms.RatePlanCode = rooms.get(position).RatePlanCode;
                                                         requestedRooms.RoomIndex = rooms.get(position).RoomIndex;
                                                         requestedRooms.RoomRate = new Rate();
                                                         if (rooms.get(position).Supplements != null) {
                                                             requestedRooms.Supplements = new ArrayOfSuppInfo();
                                                             for (Supplement supplement : rooms.get(position).Supplements) {
                                                                 SuppInfo suppInfo = new SuppInfo();
                                                                 suppInfo.SuppChargeType = Enums.SuppChargeType.valueOf(supplement.SuppChargeType.name());
                                                                 suppInfo.Price = supplement.Price;
                                                                 if (supplement.SuppIsMandatory) {
                                                                     suppInfo.SuppIsSelected = true;

                                                                 }
                                                                 requestedRooms.Supplements.add(suppInfo);
                                                             }
                                                         }
                                                         requestedRooms.RoomRate.RoomFare = rooms.get(position).RoomRate.RoomFare;
                                                         requestedRooms.RoomRate.RoomTax = rooms.get(position).RoomRate.RoomTax;
                                                         requestedRooms.RoomRate.TotalFare = rooms.get(position).RoomRate.TotalFare;
                                                         requestedRooms.RoomTypeCode = rooms.get(position).RoomTypeCode;
                                                         arrayOfRooms.add(requestedRooms);

                                                         String requestedRoomsString = gson.toJson(arrayOfRooms);
                                                         SharedPreferencesManger.SaveData((Activity) context, "arrayOfroomsreq", requestedRoomsString);
                                                         SharedPreferencesManger.SaveData(context, "RoomComb", null);

                                                         String gustMode = SharedPreferencesManger.LoadStringData(context, "guestMode");
                                                         if (gustMode != null) {


                                                             AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                                                             alertDialogBuilder.setTitle("You in gust Mode");
                                                             alertDialogBuilder
                                                                     .setMessage("You hav to Sign Up First")
                                                                     .setCancelable(true).setPositiveButton("Sign up", new DialogInterface.OnClickListener() {
                                                                 @Override
                                                                 public void onClick(DialogInterface dialogInterface, int i) {

                                                                     SharedPreferencesManger.remove(context, "guestMode");

                                                                     // TODO: 7/28/2019  intent to Registration Fragment
                                                                     Intent intent1 = new Intent(activity, WelcomeActivity.class);

                                                                     context.startActivity(intent1);

                                                                 }
                                                             });
                                                             alertDialogBuilder.show();


                                                             // Toast.makeText(context, "You hav to Sign Up First", Toast.LENGTH_SHORT).show();


                                                         } else {

                                                             context.startActivity(intent);
                                                         }


                                                     }
                                                 }
                                             }
        );


    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mName, roomPrice;
        public ImageView img_photo_hotel;
        public Button roomBooken;


        public ViewHolder(View linearLayout) {
            super(linearLayout);

            this.mName = linearLayout.findViewById(R.id.nametext_room);
            this.img_photo_hotel = linearLayout.findViewById(R.id.room_image);
            this.roomPrice = linearLayout.findViewById(R.id.room_price);
            this.roomBooken = linearLayout.findViewById(R.id.room_booking_btn);


        }
    }


}
