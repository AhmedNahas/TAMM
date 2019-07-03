package FlightApi;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface FlightApiService {
    String TBO_FLIGHT_API = "https://xmloutapi.tboair.com/api/v1/";

    @Headers("Content-Type: application/json")
    @POST("Authenticate/ValidateAgency")
    Call<FlightAuthentication> getAuthentication(@Header("Content-Type") String content_type,
            @Query("UserName") String userName
            , @Query("Password") String password,
            @Query("BookingMode") String bookingMode,
            @Query("IPAddress") String ipAddress);


}
