package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Tamm.Hotels.wcf.AmendInformation;
import com.Tamm.Hotels.wcf.AmendmentRequestType;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.CheckInReq;
import com.Tamm.Hotels.wcf.Enums;
import com.Tamm.Hotels.wcf.HotelCancelResponse;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.model.Room.RoomCartModel;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookedAdapter extends RecyclerView.Adapter<BookedAdapter.BookedViewHolder> {
    private AuthenticationData authenticandata;

    Context context;
    List<RoomCartModel> allData ;
    RequestQueue requestQueue;
    private static final String SENDBOOKEDHOTEL = "http://egyptgoogle.com/backend/canceltionbooking/insertcanceltion.php";


    private BasicHttpBinding_IHotelService1 service;
    private String checkIn , hotel_name,checkOut,imageRoom,bookedon,booking,tripname,leadguest,city;
    private int noofguest;
    private String confirmationNo;
    private String bookingId;
    private String cancellationcharge;
    private String cancelledOn;



    public BookedAdapter(Context context, List<RoomCartModel> allData) {
        this.context = context;
        this.allData = allData ;

    }


    @NonNull
    @Override



    public BookedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mybook_raw,parent,false);
        return new BookedViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull BookedViewHolder holder, int position) {


        RoomCartModel roomCartModel = allData.get(position);

        checkIn = roomCartModel.getCheckIn();
        hotel_name = roomCartModel.getHotel_name();
        checkOut = roomCartModel.getCheckOut();
        imageRoom = roomCartModel.getImageRoom();
        bookedon=roomCartModel.getBooked();
        booking =roomCartModel.getBooking();
        tripname=roomCartModel.getTripname();
        leadguest=roomCartModel.getLeadguest();
        noofguest=roomCartModel.getNoofguest();
        city =roomCartModel.getCity();




        Glide.with(context).load(imageRoom).into(holder.iv_image_booked);

        String untile = roomCartModel.getUntile();
        holder.tv_cancellation.setText(untile);
        holder.tv_name_hotel_booked.setText(hotel_name);
        holder.tv_checkin_booked.setText(checkIn);
        holder.tv_checkout_booked.setText(checkOut);



        AmendmentRequestType amendmentRequestType = new AmendmentRequestType();
        amendmentRequestType.Type = Enums.AmendmentType.OfflineAmendment;
        AmendInformation amendInformation = new AmendInformation();
        amendInformation.CheckIn = new CheckInReq();
        amendInformation.CheckIn.Date = new DateTime(checkIn);

        bookingId = roomCartModel.getBookingId();


        confirmationNo = roomCartModel.getConfirmationNo();


        holder.btn_cancel_booked.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Calendar calendar = Calendar.getInstance();

                Date futureDate = calendar.getTime();
                cancelledOn = new SimpleDateFormat("yyyy-MM-dd").format(futureDate);


                try {


                    service = new BasicHttpBinding_IHotelService1();
                    service.enableLogging = true;
                    authenticandata = new AuthenticationData();
                    authenticandata.UserName = (context.getString(R.string.user_name_tamm));
                    authenticandata.Password = (context.getString(R.string.passowrd_tamm));

                    connectdatabasecancel();

                    HotelCancelResponse hotelCancelResponse = service.HotelCancel(0, Enums.CancelRequestType.HotelCancel, "Test","5K6RUT" , authenticandata);

                    int code = hotelCancelResponse.RequestStatus.getCode();

                    BigDecimal cancellationCharge = hotelCancelResponse.CancellationCharge;
                    cancellationcharge = cancellationCharge.toString();

                    String description = hotelCancelResponse.Status.Description;

                    Toast.makeText(context, "cod is : "+code+"" +
                            "   "+description, Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

        holder.btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });




    }

    @Override
    public int getItemCount() {

        return allData.size();
    }

    public class BookedViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_image_booked;
        TextView  tv_name_hotel_booked,tv_checkin_booked,tv_checkout_booked,tv_cancellation,tv_checkin_txt,tv_checkout_txt,tv_cancellation_policy;
        Button btn_edit,btn_cancel_booked;


        public BookedViewHolder(@NonNull View itemView) {
            super(itemView);


            iv_image_booked=itemView.findViewById(R.id.iv_image_booked);


            tv_name_hotel_booked=itemView.findViewById(R.id.tv_name_hotel_booked);
            tv_checkin_booked=itemView.findViewById(R.id.tv_checkin_booked);
            tv_checkout_booked=itemView.findViewById(R.id.tv_checkout_booked);
            tv_cancellation=itemView.findViewById(R.id.tv_cancellation);
            tv_checkin_txt=itemView.findViewById(R.id.tv_checkin_txt);
            tv_checkout_txt=itemView.findViewById(R.id.tv_checkout_txt);
            tv_cancellation_policy=itemView.findViewById(R.id.tv_cancellation_policy);


            btn_edit=itemView.findViewById(R.id.btn_edit);
            btn_cancel_booked=itemView.findViewById(R.id.btn_cancel_booked);






        }
    }




    private void connectdatabasecancel() {

        StringRequest request = new StringRequest(Request.Method.POST, SENDBOOKEDHOTEL, new Response.Listener<String>() {

            @Override

            public void onResponse(String response) {

                Toast.makeText(context,"Booked", Toast.LENGTH_SHORT).show();

                Log.e("HI", "onResponse: "+ response );

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"error", Toast.LENGTH_SHORT).show();
                Log.e("HI", "onResponse: "+ error );


            }

        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("hotelname", hotel_name);
                parameters.put("booked", bookedon);
                parameters.put("booking","Vouched");
                parameters.put("checkin", checkIn);
                parameters.put("checkout",checkOut );
                parameters.put("tboconfno", confirmationNo);
                parameters.put("tripid", bookingId);
                parameters.put("tripname",tripname);
                parameters.put("leadguest",leadguest);
                parameters.put("noofguest", String.valueOf(noofguest));
                parameters.put("cancelationdate", cancelledOn);
                parameters.put("city",city);
                parameters.put("canceltionfeesperoom",cancellationcharge);






                return parameters;
            }
        };
        requestQueue.add(request);
    }









}
