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

import java.util.Hashtable;
import java.util.Vector;


public class ArrayOfRoomRes extends Vector<RoomRes> implements KvmSerializable {
    private transient java.lang.Object __source;

    public void loadFromSoap(java.lang.Object inObj, ExtendedSoapSerializationEnvelope __envelope) {
        if (inObj == null)
            return;
        __source = inObj;
        SoapObject soapObject = (SoapObject) inObj;
        int size = soapObject.getPropertyCount();
        for (int i0 = 0; i0 < size; i0++) {
            java.lang.Object obj = soapObject.getProperty(i0);
            if (obj != null && obj instanceof AttributeContainer) {
                AttributeContainer j = (AttributeContainer) soapObject.getProperty(i0);
                RoomRes j1 = (RoomRes) __envelope.get(j, RoomRes.class, false);
                add(j1);
            }
        }
    }

    public java.lang.Object getSourceObject() {
        return __source;
    }

    @Override
    public java.lang.Object getProperty(int arg0) {
        return this.get(arg0) != null ? this.get(arg0) : SoapPrimitive.NullNilElement;
    }

    @Override
    public int getPropertyCount() {
        return this.size();
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        info.name = "RoomRes";
        info.type = RoomRes.class;
        info.namespace = "http://TekTravel/HotelBookingApi";
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }


}