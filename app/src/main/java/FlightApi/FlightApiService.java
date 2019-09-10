package FlightApi;



import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface FlightApiService {
    String TBO_FLIGHT_API = "https://xmloutapi.tboair.com/api/v1/";

    @Headers("Content-Type: application/json")
    @POST("Authenticate/ValidateAgency")
    Call<FlightAuthentication> getAuthentication(@Header("Content-Type") String content_type,
                                                 @Body FlightAuthentication body);

    @Headers("Content-Type: application/json")
    @POST("Search/Search")
    Call<SearchFlightsResponse> getFlightSearch(@Header("Content-Type") String content_type,
                                        @Body SearchFlights body);


    @Headers("Content-Type: application/json")
    @POST("Detail/FareRules")
    Call<FareRuleResponse> getFareRuleResponse(@Header("Content-Type") String content_type,
                                                @Body FareRuleRequest body);

    // Nahas
    @Headers("Content-Type: application/json")
    @POST("Detail/FareQuote")
    Call<FareQuoteRespone> getFareQuote(@Header("Content-Type") String content_type,
                                               @Body FareQuote body);

    // Nahas
    @Headers("Content-Type: application/json")
    @POST("Detail/GetSSR")
    Call<FlightSSRRespone> getSSRResponse(@Header("Content-Type") String content_type,
                                        @Body FlightSSR body);


    @Headers("Content-Type: application/json")
    @POST("Booking/Book")
    Call<GetBookingResponse> getFlightBook(@Header("Content-Type") String content_type,
                                           @Body BookFlight body);



}
