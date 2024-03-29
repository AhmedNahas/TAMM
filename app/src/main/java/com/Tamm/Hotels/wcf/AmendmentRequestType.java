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

import java.util.Hashtable;

public class AmendmentRequestType extends AttributeContainer implements KvmSerializable {


    public Enums.AmendmentType Type = Enums.AmendmentType.CheckStatus;

    public Enums.PriceChange PriceChange = Enums.PriceChange.InformationRequired;
    
    public String Remarks;
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
        if (inObj.hasAttribute("Type")) {
            java.lang.Object j = inObj.getAttribute("Type");
            if (j != null) {
                Type = Enums.AmendmentType.fromString(j.toString());
            }
        }
        if (inObj.hasAttribute("PriceChange")) {
            java.lang.Object j = inObj.getAttribute("PriceChange");
            if (j != null) {
                PriceChange = Enums.PriceChange.fromString(j.toString());
            }
        }
        if (inObj.hasAttribute("Remarks")) {
            java.lang.Object j = inObj.getAttribute("Remarks");
            if (j != null) {
                Remarks = j.toString();
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
        return 3;
    }

    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
        if (index == 0) {
            info.name = "Type";
            info.namespace = "";
            if (this.Type != null) {
                info.setValue(this.Type);
            }

        }
        if (index == 1) {
            info.name = "PriceChange";
            info.namespace = "";
            if (this.PriceChange != null) {
                info.setValue(this.PriceChange);
            }

        }
        if (index == 2) {
            info.name = "Remarks";
            info.namespace = "";
            if (this.Remarks != null) {
                info.setValue(this.Remarks);
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

