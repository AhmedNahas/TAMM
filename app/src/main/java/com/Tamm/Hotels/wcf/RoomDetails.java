package com.Tamm.Hotels.wcf;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.5.5.5
//
// Created by Quasar Development 
//
//---------------------------------------------------


import org.ksoap2.serialization.AttributeContainer;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.ArrayList;
import java.util.Hashtable;

public class RoomDetails extends AttributeContainer implements KvmSerializable {


    public Integer AdultCount = 0;

    public Integer ChildCount = 0;

    public ArrayList<Integer> ChildAge = new ArrayList<Integer>();

    public String RoomName;

    public ArrayList<String> Ameneties = new ArrayList<String>();

    public ArrayOfGuest GuestInfo;

    public String Inclusion;

    public String RoomPromtion;

    public String RoomInstructions;

    public ArrayOfSupp_info Supplements;

    public RoomRate RoomRate;

    public String RoomEssentialInfo;

    public String MealType;
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
        if (info.name.equals("AdultCount")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.AdultCount = Integer.parseInt(j.toString());
                    }
                } else if (obj instanceof Integer) {
                    this.AdultCount = (Integer) obj;
                }
            }
            return true;
        }
        if (info.name.equals("ChildCount")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.ChildCount = Integer.parseInt(j.toString());
                    }
                } else if (obj instanceof Integer) {
                    this.ChildCount = (Integer) obj;
                }
            }
            return true;
        }
        if (info.name.equals("ChildAge")) {
            if (obj != null) {
                if (this.ChildAge == null) {
                    this.ChildAge = new java.util.ArrayList<Integer>();
                }
                java.lang.Object j = obj;
                Integer j1 = Integer.parseInt(j.toString());
                this.ChildAge.add(j1);
            }
            return true;
        }
        if (info.name.equals("RoomName")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.RoomName = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.RoomName = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("Ameneties")) {
            if (obj != null) {
                if (this.Ameneties == null) {
                    this.Ameneties = new java.util.ArrayList<String>();
                }
                java.lang.Object j = obj;
                String j1 = j.toString();
                this.Ameneties.add(j1);
            }
            return true;
        }
        if (info.name.equals("GuestInfo")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.GuestInfo = (ArrayOfGuest) __envelope.get(j, ArrayOfGuest.class, false);
            }
            return true;
        }
        if (info.name.equals("Inclusion")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.Inclusion = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.Inclusion = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("RoomPromtion")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.RoomPromtion = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.RoomPromtion = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("RoomInstructions")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.RoomInstructions = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.RoomInstructions = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("Supplements")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.Supplements = (ArrayOfSupp_info) __envelope.get(j, ArrayOfSupp_info.class, false);
            }
            return true;
        }
        if (info.name.equals("RoomRate")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.RoomRate = (RoomRate) __envelope.get(j, RoomRate.class, false);
            }
            return true;
        }
        if (info.name.equals("RoomEssentialInfo")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.RoomEssentialInfo = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.RoomEssentialInfo = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("MealType")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.MealType = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.MealType = (String) obj;
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
            return AdultCount;
        }
        if (propertyIndex == 1) {
            return ChildCount;
        }
        if (propertyIndex >= 2 && propertyIndex < 2 + this.ChildAge.size()) {
            java.lang.Object ChildAge = this.ChildAge.get(propertyIndex - (2));
            return ChildAge != null ? ChildAge : SoapPrimitive.NullNilElement;
        }
        if (propertyIndex == 2 + this.ChildAge.size()) {
            return this.RoomName != null ? this.RoomName : SoapPrimitive.NullSkip;
        }
        if (propertyIndex >= 3 + this.ChildAge.size() && propertyIndex < 3 + this.ChildAge.size() + this.Ameneties.size()) {
            java.lang.Object Ameneties = this.Ameneties.get(propertyIndex - (3 + this.ChildAge.size()));
            return Ameneties != null ? Ameneties : SoapPrimitive.NullNilElement;
        }
        if (propertyIndex == 3 + this.ChildAge.size() + this.Ameneties.size()) {
            return this.GuestInfo != null ? this.GuestInfo : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 4 + this.ChildAge.size() + this.Ameneties.size()) {
            return this.Inclusion != null ? this.Inclusion : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 5 + this.ChildAge.size() + this.Ameneties.size()) {
            return this.RoomPromtion != null ? this.RoomPromtion : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 6 + this.ChildAge.size() + this.Ameneties.size()) {
            return this.RoomInstructions != null ? this.RoomInstructions : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 7 + this.ChildAge.size() + this.Ameneties.size()) {
            return this.Supplements != null ? this.Supplements : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 8 + this.ChildAge.size() + this.Ameneties.size()) {
            return this.RoomRate != null ? this.RoomRate : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 9 + this.ChildAge.size() + this.Ameneties.size()) {
            return this.RoomEssentialInfo != null ? this.RoomEssentialInfo : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 10 + this.ChildAge.size() + this.Ameneties.size()) {
            return this.MealType != null ? this.MealType : SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 11 + ChildAge.size() + Ameneties.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        if (propertyIndex == 0) {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "AdultCount";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 1) {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "ChildCount";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex >= 2 && propertyIndex < 2 + this.ChildAge.size()) {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "ChildAge";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 2 + this.ChildAge.size()) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "RoomName";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex >= 3 + this.ChildAge.size() && propertyIndex < 3 + this.ChildAge.size() + this.Ameneties.size()) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Ameneties";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 3 + this.ChildAge.size() + this.Ameneties.size()) {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "GuestInfo";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 4 + this.ChildAge.size() + this.Ameneties.size()) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Inclusion";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 5 + this.ChildAge.size() + this.Ameneties.size()) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "RoomPromtion";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 6 + this.ChildAge.size() + this.Ameneties.size()) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "RoomInstructions";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 7 + this.ChildAge.size() + this.Ameneties.size()) {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "Supplements";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 8 + this.ChildAge.size() + this.Ameneties.size()) {
            info.type = RoomRate.class;
            info.name = "RoomRate";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 9 + this.ChildAge.size() + this.Ameneties.size()) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "RoomEssentialInfo";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 10 + this.ChildAge.size() + this.Ameneties.size()) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "MealType";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }


}

