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

import java.util.Hashtable;

public class RoomInfo extends AttributeContainer implements KvmSerializable {

    
    public String Description;

    public ArrayOfString5 Images;

    public String RoomPromotion;

    public String Inclusion;

    public String RoomName;

    public String RoomTypeCode;
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
        if (inObj.hasAttribute("RoomName")) {
            java.lang.Object j = inObj.getAttribute("RoomName");
            if (j != null) {
                RoomName = j.toString();
            }
        }
        if (inObj.hasAttribute("RoomTypeCode")) {
            java.lang.Object j = inObj.getAttribute("RoomTypeCode");
            if (j != null) {
                RoomTypeCode = j.toString();
            }
        }

    }


    protected boolean loadProperty(PropertyInfo info, SoapObject soapObject, ExtendedSoapSerializationEnvelope __envelope) {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("Description")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.Description = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.Description = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("Images")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.Images = (ArrayOfString5) __envelope.get(j, ArrayOfString5.class, false);
            }
            return true;
        }
        if (info.name.equals("RoomPromotion")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.RoomPromotion = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.RoomPromotion = (String) obj;
                }
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
            return this.Description != null ? this.Description : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 1) {
            return this.Images != null ? this.Images : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 2) {
            return this.RoomPromotion != null ? this.RoomPromotion : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 3) {
            return this.Inclusion != null ? this.Inclusion : SoapPrimitive.NullSkip;
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
            info.name = "Description";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 1) {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "Images";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 2) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "RoomPromotion";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 3) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Inclusion";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }



    @Override
    public int getAttributeCount() {
        return 2;
    }

    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
        if (index == 0) {
            info.name = "RoomName";
            info.namespace = "";
            if (this.RoomName != null) {
                info.setValue(this.RoomName);
            }

        }
        if (index == 1) {
            info.name = "RoomTypeCode";
            info.namespace = "";
            if (this.RoomTypeCode != null) {
                info.setValue(this.RoomTypeCode);
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
