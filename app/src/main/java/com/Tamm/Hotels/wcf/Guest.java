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
import org.ksoap2.serialization.AttributeInfo;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

public class Guest extends AttributeContainer implements KvmSerializable {


    public String Title;

    public String FirstName;

    public String LastName;

    public Integer Age = 0;

    public Boolean LeadGuest = false;

    public Enums.GuestType GuestType = Enums.GuestType.Adult;

    public Integer GuestInRoom = 0;
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
        if (inObj.hasAttribute("LeadGuest")) {
            java.lang.Object j = inObj.getAttribute("LeadGuest");
            if (j != null) {
                LeadGuest = new Boolean(j.toString());
            }
        }
        if (inObj.hasAttribute("GuestType")) {
            java.lang.Object j = inObj.getAttribute("GuestType");
            if (j != null) {
                GuestType = Enums.GuestType.fromString(j.toString());
            }
        }
        if (inObj.hasAttribute("GuestInRoom")) {
            java.lang.Object j = inObj.getAttribute("GuestInRoom");
            if (j != null) {
                GuestInRoom = Integer.parseInt(j.toString());
            }
        }

    }


    protected boolean loadProperty(PropertyInfo info, SoapObject soapObject, ExtendedSoapSerializationEnvelope __envelope) {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("Title")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.Title = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.Title = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("FirstName")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.FirstName = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.FirstName = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("LastName")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.LastName = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.LastName = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("Age")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.Age = Integer.parseInt(j.toString());
                    }
                } else if (obj instanceof Integer) {
                    this.Age = (Integer) obj;
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
            return this.Title != null ? this.Title : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 1) {
            return this.FirstName != null ? this.FirstName : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 2) {
            return this.LastName != null ? this.LastName : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 3) {
            return Age;
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
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Title";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "FirstName";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 2) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "LastName";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 3) {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "Age";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }


    @Override
    public int getAttributeCount() {
        return 3;
    }

    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
        if (index == 0) {
            info.name = "LeadGuest";
            info.namespace = "";
            if (this.LeadGuest != null) {
                info.setValue(this.LeadGuest);
            }

        }
        if (index == 1) {
            info.name = "GuestType";
            info.namespace = "";
            if (this.GuestType != null) {
                info.setValue(this.GuestType);
            }

        }
        if (index == 2) {
            info.name = "GuestInRoom";
            info.namespace = "";
            if (this.GuestInRoom != null) {
                info.setValue(this.GuestInRoom);
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

