package com.Tamm.Hotels.wcf;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.5.6.0
//
// Created by Quasar Development 
//
//---------------------------------------------------


import org.ksoap2.serialization.AttributeContainer;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

public class HotelRoomAvailabilityResponse extends AttributeContainer implements KvmSerializable {

    
    public ResponseStatus Status;

    public Integer ResultIndex = 0;
    
    public ArrayOfHotel_Room HotelRooms;

    public BookingOptions OptionsForBooking;
    private transient java.lang.Object __source;


    public void loadFromSoap(java.lang.Object paramObj, ExtendedSoapSerializationEnvelope __envelope) {
        if (paramObj == null)
            return;
        AttributeContainer inObj = (AttributeContainer) paramObj;
        __source = inObj;
        if (inObj instanceof SoapObject) {
            SoapObject soapObject = (SoapObject) inObj;
            int size = soapObject.getPropertyCount();
            for (int i0 = 0; i0 < size; i0++) {
                PropertyInfo info = soapObject.getPropertyInfo(i0);
                if (!loadProperty(info, soapObject, __envelope)) {
                }
            } 
        }

    }


    protected boolean loadProperty(PropertyInfo info, SoapObject soapObject, ExtendedSoapSerializationEnvelope __envelope) {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("Status")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.Status = (ResponseStatus) __envelope.get(j, ResponseStatus.class, false);
            }
            return true;
        }
        if (info.name.equals("ResultIndex")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.ResultIndex = Integer.parseInt(j.toString());
                    }
                } else if (obj instanceof Integer) {
                    this.ResultIndex = (Integer) obj;
                }
            }
            return true;
        }
        if (info.name.equals("HotelRooms")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.HotelRooms = (ArrayOfHotel_Room) __envelope.get(j, ArrayOfHotel_Room.class, false);
            }
            return true;
        }
        if (info.name.equals("OptionsForBooking")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.OptionsForBooking = (BookingOptions) __envelope.get(j, BookingOptions.class, false);
            }
            return true;
        }
        return false;
    }

    public java.lang.Object getOriginalXmlSource() {
        return __source;
    }    
    

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if (propertyIndex == 0) {
            return this.Status != null ? this.Status : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 1) {
            return ResultIndex;
        }
        if (propertyIndex == 2) {
            return this.HotelRooms != null ? this.HotelRooms : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 3) {
            return this.OptionsForBooking != null ? this.OptionsForBooking : SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 4;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        if (propertyIndex == 0) {
            info.type = ResponseStatus.class;
            info.name = "Status";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 1) {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "ResultIndex";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 2) {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "HotelRooms";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 3) {
            info.type = BookingOptions.class;
            info.name = "OptionsForBooking";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }


}
