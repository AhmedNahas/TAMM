package FlightApi;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface FlightApiService {
    String TBO_FLIGHT_API = "https://xmloutapi.tboair.com/api/v1/";

    @POST(TBO_FLIGHT_API + "Authenticate/ValidateAgency")
    Call<FlightAuthentication> getAuthentication(
            @Query("UserName") String userName
            , @Query("Password") String password,
            @Query("BookingMode") String bookingMode,
            @Query("IPAddress") String ipAddress);

}
