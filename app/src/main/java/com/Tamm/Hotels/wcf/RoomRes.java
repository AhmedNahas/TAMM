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
import org.ksoap2.serialization.AttributeInfo;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.ArrayList;
import java.util.Hashtable;

public class RoomRes extends AttributeContainer implements KvmSerializable {


    public ArrayList<AmendGuestRes> Guest = new ArrayList<AmendGuestRes>();

    public Enums.RoomRequested Amended = Enums.RoomRequested.FirstRoom;
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
        if (inObj.hasAttribute("Amended")) {
            java.lang.Object j = inObj.getAttribute("Amended");
            if (j != null) {
                Amended = Enums.RoomRequested.fromString(j.toString());
            }
        }

    }


    protected boolean loadProperty(PropertyInfo info, SoapObject soapObject, ExtendedSoapSerializationEnvelope __envelope) {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("Guest")) {
            if (obj != null) {
                if (this.Guest == null) {
                    this.Guest = new java.util.ArrayList<AmendGuestRes>();
                }
                java.lang.Object j = obj;
                AmendGuestRes j1 = (AmendGuestRes) __envelope.get(j, AmendGuestRes.class, false);
                this.Guest.add(j1);
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
        if (propertyIndex >= 0 && propertyIndex < 0 + this.Guest.size()) {
            java.lang.Object Guest = this.Guest.get(propertyIndex - (0));
            return Guest != null ? Guest : SoapPrimitive.NullNilElement;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 0 + Guest.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        if (propertyIndex >= 0 && propertyIndex < 0 + this.Guest.size()) {
            info.type = AmendGuestRes.class;
            info.name = "Guest";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }



    @Override
    public int getAttributeCount() {
        return 1;
    }

    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
        if (index == 0) {
            info.name = "Amended";
            info.namespace = "";
            if (this.Amended != null) {
                info.setValue(this.Amended);
            }

        }
    }

    @Override
    public void getAttribute(int i, AttributeInfo attributeInfo) {

    }

    @Override
    public void setAttribute(AttributeInfo attributeInfo) {

    }    
}

