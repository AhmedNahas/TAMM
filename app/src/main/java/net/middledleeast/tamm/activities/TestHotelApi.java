package net.middledleeast.tamm.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.hotellibs.org.tempuri.HotelService;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.AmendmentRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.AmendmentResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.AuthenticationData;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.AvailabilityAndPricingRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.AvailabilityAndPricingResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.CityWiseNotificationRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.CityWiseNotificationResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.CountryListRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.CountryListResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.DestinationCityListRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.DestinationCityListResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.GenerateInvoiceRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.GenerateInvoiceResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.GiataHotelCodesRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.GiataHotelCodesResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelBookRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelBookResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelBookingDetailBasedOnDateRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelBookingDetailBasedOnDateResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelBookingDetailRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelBookingDetailResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelCancelRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelCancelResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelCancellationPolicyRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelCancellationPolicyResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelCodesRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelCodesResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelDetailsRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelDetailsResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelRoomAvailabilityRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelRoomAvailabilityResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelSearchRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelSearchResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelSearchWithRoomsRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.HotelSearchWithRoomsResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.Hotels;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.IHotelService;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.ObjectFactory;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.TagInfoRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.TagInfoResponse;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.TopDestinationsRequest;
import net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi.TopDestinationsResponse;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


public class TestHotelApi extends AppCompatActivity implements IHotelService {

    ObjectFactory objectFactory;

    public static XMLGregorianCalendar toXMLGregorianCalendar(Calendar c)
            throws DatatypeConfigurationException {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(c.getTimeInMillis());
        XMLGregorianCalendar xc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        return xc;
    }


//    private static SOAPMessage createSOAPRequest() throws Exception {
//        MessageFactoryImpl messageFactory = (MessageFactoryImpl) MessageFactoryImpl.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
//        SOAPMessage soapMessage = messageFactory.createMessage();
//        SOAPPartImpl soapPart = (SOAPPartImpl) soapMessage.getSOAPPart();
//
//        String serverURI = "http://TekTravel/HotelBookingApi";
//
//        // SOAP Envelope
//        SOAPEnvelope envelope = soapPart.getEnvelope();
//        envelope.addNamespaceDeclaration("hot", serverURI);
//
//        // SOAP Header
//        SOAPHeader header = envelope.getHeader();
//        header.addNamespaceDeclaration("wsa", "http://www.w3.org/2005/08/addressing");
//        SOAPElement soapHeaderElem = header.addChildElement("Credentials", "hot");
//        soapHeaderElem.addAttribute(new QName("UserName"), "kuldeep");
//        soapHeaderElem.addAttribute(new QName("Password"), "54321");
//        SOAPElement soapHeaderElem1 = header.addChildElement("Action", "wsa");
//        soapHeaderElem1.addTextNode("http://TekTravel/HotelBookingApi/DestinationCityList");
//        SOAPElement soapHeaderElem2 = header.addChildElement("To", "wsa");
//        soapHeaderElem2.addTextNode("http://api.tbotechnology.in/HotelAPI_V7/HotelService.svc");
//
//        // SOAP Body
//        SOAPBody soapBody = envelope.getBody();
//
//        SOAPElement soapBodyElem = soapBody.addChildElement("DestinationCityListRequest", "hot");
//        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("CountryCode", "hot");
//        soapBodyElem1.addTextNode("IN");
//
//        MimeHeaders headers = soapMessage.getMimeHeaders();
//        headers.addHeader("Content-Type", "application/soap+xml;charset=UTF-8");
//
//        soapMessage.saveChanges();
//
//        /* Print the request message */
//        System.out.print("Request SOAP Message = ");
//        soapMessage.writeTo(System.out);
//        System.out.println();
//
//        return soapMessage;
//    }

    @Override
    public HotelBookingDetailResponse hotelBookingDetail(HotelBookingDetailRequest parameters) {
        return null;
    }

    @Override
    public HotelBookingDetailBasedOnDateResponse hotelBookingDetailBasedOnDate(HotelBookingDetailBasedOnDateRequest parameters) {
        return null;
    }

    @Override
    public GiataHotelCodesResponse giataHotelCodeList(GiataHotelCodesRequest parameters) {
        return null;
    }

    @Override
    public HotelBookResponse hotelBook(HotelBookRequest parameters) {
        return null;
    }

    @Override
    public DestinationCityListResponse destinationCityList(DestinationCityListRequest parameters) {
        return null;
    }

    @Override
    public GenerateInvoiceResponse generateInvoice(GenerateInvoiceRequest parameters) {
        return null;
    }

    @Override
    public AvailabilityAndPricingResponse availabilityAndPricing(AvailabilityAndPricingRequest parameters) {
        return null;
    }

    @Override
    public HotelCancellationPolicyResponse hotelCancellationPolicyForAllRooms(HotelCancellationPolicyRequest parameters) {
        return null;
    }

    @Override
    public HotelCodesResponse hotelCodeList(HotelCodesRequest parameters) {
        return null;
    }

    @Override
    public HotelCancelResponse hotelCancel(HotelCancelRequest parameters) {
        return null;
    }

    @Override
    public HotelSearchWithRoomsResponse hotelSearchWithRooms(HotelSearchWithRoomsRequest parameters) {
        return null;
    }

    @Override
    public HotelCancellationPolicyResponse hotelCancellationPolicy(HotelCancellationPolicyRequest parameters) {
        return null;
    }

    @Override
    public CityWiseNotificationResponse cityWiseNotification(CityWiseNotificationRequest parameters) {
        return null;
    }

    @Override
    public TopDestinationsResponse topDestinations(TopDestinationsRequest parameters) {
        return null;
    }

    @Override
    public AmendmentResponse amendment(AmendmentRequest parameters) {
        return null;
    }

    @Override
    public CountryListResponse countryList(CountryListRequest parameters) {
        return null;
    }

    @Override
    public TagInfoResponse tagInfo(TagInfoRequest parameters) {
        return null;
    }

    @Override
    public HotelDetailsResponse hotelDetails(HotelDetailsRequest parameters) {
        return null;
    }

    @Override
    public HotelRoomAvailabilityResponse availableHotelRooms(HotelRoomAvailabilityRequest parameters) {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        try
//        {
//        // Create SOAP Connection
//        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
//        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
//
//        // Send SOAP Message to SOAP Server
//        String endpoint = "http://api.tbotechnology.in/HotelAPI_V7/HotelService.svc";
//        SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), endpoint);
//        soapResponse.writeTo(System.out);
//
//        soapConnection.close();
//    } catch (Exception e) {
//        System.err.println("Error occurred while sending SOAP Request to Server");
//        e.printStackTrace();
//    }
        objectFactory = new ObjectFactory();
        AuthenticationData authenticationData = objectFactory.createAuthenticationData();
        authenticationData.setSiteName("https://api.tbotechnology.in/hotelapi_v7/hotelservice.svc");
        authenticationData.setUserName("Tammtest");
        authenticationData.setPassword("Tam@18418756");
        objectFactory.createCredentials(authenticationData);
        objectFactory.createAPIHotelDetails();
        objectFactory.createAccountInfo();
        HotelSearchRequest hotelSearchRequest = objectFactory.createHotelSearchRequest();
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.DAY_OF_MONTH, 28);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.DAY_OF_MONTH, 30);
        try {
            hotelSearchRequest.setCheckInDate(toXMLGregorianCalendar(cal1));
            hotelSearchRequest.setCheckOutDate(toXMLGregorianCalendar(cal2));
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        HotelSearchResponse hotelSearchResponse = hotelSearch(hotelSearchRequest);
        Hotels hotels = objectFactory.createHotels();
        HotelService hotelService = new HotelService();
//       String test = String.valueOf(2);
//        HotelService hotelService = new HotelService();
        System.out.println("Heio: " + hotelSearchResponse.getStatus());
    }

    @Override
    public HotelSearchResponse hotelSearch(HotelSearchRequest parameters) {

        return new HotelSearchResponse();
    }
}
