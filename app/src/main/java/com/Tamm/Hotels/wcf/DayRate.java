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

import java.math.BigDecimal;
import java.util.Hashtable;

public class DayRate extends AttributeContainer implements KvmSerializable {


    public org.joda.time.DateTime Date;

    public BigDecimal BaseFare = BigDecimal.ZERO;
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
        if (inObj.hasAttribute("Date")) {
            java.lang.Object j = inObj.getAttribute("Date");
            if (j != null) {
                Date = Helper.ConvertFromWebService(j.toString());
            }
        }
        if (inObj.hasAttribute("BaseFare")) {
            java.lang.Object j = inObj.getAttribute("BaseFare");
            if (j != null) {
                BaseFare = new BigDecimal(j.toString());
            }
        }

    }


    protected boolean loadProperty(PropertyInfo info, SoapObject soapObject, ExtendedSoapSerializationEnvelope __envelope) {
        java.lang.Object obj = info.getValue();
        return false;
    }

    public java.lang.Object getOriginalXmlSource() {
        return __source;
    }


    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 0;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
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
            info.name = "Date";
            info.namespace = "";
            if (this.Date != null) {
                info.setValue(this.Date);
            }

        }
        if (index == 1) {
            info.name = "BaseFare";
            info.namespace = "";
            if (this.BaseFare != null) {
                info.setValue(this.BaseFare);
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

