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

public class Hotel_ResultWithRooms extends AttributeContainer implements KvmSerializable {


    public Integer ResultIndex = 0;
    
    public HotelInfo HotelInfo;

    public MinHotelPrice MinHotelPrice;

    public ArrayOfHotel_Room HotelRooms;

    public BookingOptions OptionsForBooking;

    public Boolean MoreRoomsAvailable = false;

    public Boolean IsPkgProperty = false;

    public Boolean IsPackageRate = false;
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
        if (info.name.equals("HotelInfo")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.HotelInfo = (HotelInfo) __envelope.get(j, HotelInfo.class, false);
            }
            return true;
        }
        if (info.name.equals("MinHotelPrice")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.MinHotelPrice = (MinHotelPrice) __envelope.get(j, MinHotelPrice.class, false);
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
        if (info.name.equals("MoreRoomsAvailable")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.MoreRoomsAvailable = new Boolean(j.toString());
                    }
                } else if (obj instanceof Boolean) {
                    this.MoreRoomsAvailable = (Boolean) obj;
                }
            }
            return true;
        }
        if (info.name.equals("IsPkgProperty")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.IsPkgProperty = new Boolean(j.toString());
                    }
                } else if (obj instanceof Boolean) {
                    this.IsPkgProperty = (Boolean) obj;
                }
            }
            return true;
        }
        if (info.name.equals("IsPackageRate")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.IsPackageRate = new Boolean(j.toString());
                    }
                } else if (obj instanceof Boolean) {
                    this.IsPackageRate = (Boolean) obj;
                }
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
            return ResultIndex;
        }
        if (propertyIndex == 1) {
            return this.HotelInfo != null ? this.HotelInfo : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 2) {
            return this.MinHotelPrice != null ? this.MinHotelPrice : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 3) {
            return this.HotelRooms != null ? this.HotelRooms : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 4) {
            return this.OptionsForBooking != null ? this.OptionsForBooking : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 5) {
            return MoreRoomsAvailable;
        }
        if (propertyIndex == 6) {
            return IsPkgProperty;
        }
        if (propertyIndex == 7) {
            return IsPackageRate;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 8;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        if (propertyIndex == 0) {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "ResultIndex";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 1) {
            info.type = HotelInfo.class;
            info.name = "HotelInfo";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 2) {
            info.type = MinHotelPrice.class;
            info.name = "MinHotelPrice";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 3) {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "HotelRooms";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 4) {
            info.type = BookingOptions.class;
            info.name = "OptionsForBooking";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 5) {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "MoreRoomsAvailable";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 6) {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "IsPkgProperty";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 7) {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "IsPackageRate";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }


}

